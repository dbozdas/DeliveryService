package com.solvd.deliveryservice.dao.implDAO.peopleDAO;

import com.solvd.deliveryservice.databasemodel.address.Address;
import com.solvd.deliveryservice.databasemodel.people.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import static com.solvd.deliveryservice.connectionpool.DataSourceUtils.getConnection;
import static org.apache.logging.log4j.core.util.Closer.close;

public class CustomerDAO {
    private static final Logger LOGGER = LogManager.getLogger(CustomerDAO.class);

    private static final String INSERT = "INSERT INTO Deniz_Bozdas.Customers VALUES(?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM Deniz_Bozdas.Customers WHERE id=?";
    private static final String UPDATE = "UPDATE Deniz_Bozdas.Customers SET first_Name=?, last_Name=?, date_Of_Birth=?, email=?, phone_Number=?, Address_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM Deniz_Bozdas.Customers WHERE id=?";

    public void insert(Customer customer) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setDate(3, customer.getDateOfBirth());
            stmt.setString(4, customer.getEmail());
            stmt.setString(5, customer.getPhoneNumber());
            stmt.setObject(6, customer.getAddress());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                customer.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            close(stmt);
            close(conn);
        }
    }



    public static Customer findById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString(""));
                customer.setLastName(rs.getString(""));
                customer.setDateOfBirth(rs.getDate(""));
                customer.setEmail(rs.getString(""));
                customer.setPhoneNumber(rs.getString(""));
                customer.setAddress((Address) rs.getObject(""));


                return customer;
            } else {
                return null;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
        return null;
    }


    public void delete(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }



    public void update(Customer customer) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setDate(3, customer.getDateOfBirth());
            stmt.setString(4, customer.getEmail());
            stmt.setString(5, customer.getPhoneNumber());
            stmt.setObject(6, customer.getAddress());

            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }

}

