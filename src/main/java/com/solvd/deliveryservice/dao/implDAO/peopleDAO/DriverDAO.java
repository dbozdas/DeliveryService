package com.solvd.deliveryservice.dao.implDAO.peopleDAO;

import com.solvd.deliveryservice.databasemodel.address.Address;
import com.solvd.deliveryservice.databasemodel.people.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import static com.solvd.deliveryservice.connectionpool.DataSourceUtils.getConnection;
import static org.apache.logging.log4j.core.util.Closer.close;

public class DriverDAO {
    private static final Logger LOGGER = LogManager.getLogger(DriverDAO.class);

    private static final String INSERT = "INSERT INTO Deniz_Bozdas.Drivers VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM Deniz_Bozdas.Drivers WHERE id=?";
    private static final String UPDATE = "UPDATE Deniz_Bozdas.Drivers SET first_Name=?, last_Name=?, date_Of_Birth=?, email=?, phone_Number=?, rating=?, Address_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM Deniz_Bozdas.Drivers WHERE id=?";

    public void insert(Driver driver) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, driver.getFirstName());
            stmt.setString(2, driver.getLastName());
            stmt.setDate(3, driver.getDateOfBirth());
            stmt.setString(4, driver.getEmail());
            stmt.setString(5, driver.getPhoneNumber());
            stmt.setDouble(6, driver.getRating());
            stmt.setObject(7, driver.getAddress());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                driver.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            close(stmt);
            close(conn);
        }
    }



    public Driver findById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Driver driver = new Driver();
                driver.setId(rs.getInt("id"));
                driver.setFirstName(rs.getString(""));
                driver.setLastName(rs.getString(""));
                driver.setDateOfBirth(rs.getDate(""));
                driver.setEmail(rs.getString(""));
                driver.setPhoneNumber(rs.getString(""));
                driver.setRating(rs.getDouble(""));
                driver.setAddress((Address) rs.getObject(""));


                return driver;
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



    public void update(Driver driver) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, driver.getFirstName());
            stmt.setString(2, driver.getLastName());
            stmt.setDate(3, driver.getDateOfBirth());
            stmt.setString(4, driver.getEmail());
            stmt.setString(5, driver.getPhoneNumber());
            stmt.setDouble(6, driver.getRating());
            stmt.setObject(7, driver.getAddress());

            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }

}


