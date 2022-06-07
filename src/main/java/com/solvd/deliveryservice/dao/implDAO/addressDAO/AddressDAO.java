package com.solvd.deliveryservice.dao.implDAO.addressDAO;

import com.solvd.deliveryservice.dao.interfaceDAO.addressDAO.IAddressDAO;
import com.solvd.deliveryservice.databasemodel.address.Address;
import com.solvd.deliveryservice.databasemodel.address.ZipCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static com.solvd.deliveryservice.connectionpool.DataSourceUtils.getConnection;
import static org.apache.logging.log4j.core.util.Closer.close;


public class AddressDAO implements IAddressDAO {
    private static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);

    private static final String INSERT = "INSERT INTO Deniz_Bozdas.Addresses VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM Deniz_Bozdas.Addresses WHERE id=?";
    private static final String UPDATE = "UPDATE Deniz_Bozdas.Addresses SET streetNumber=?, streetName=?, zip_Codes_id=?, customers_id=?, drivers_id=?, restaurants_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Deniz_Bozdas.Addresses WHERE id=?";

    public void insert(Address address) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, address.getStreetNumber());
            stmt.setString(2, address.getStreetName());
            stmt.setObject(3, address.getZipCode());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                address.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            close(stmt);
            close(conn);
        }

    }



    public Address findById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Address address = new Address();
                address.setId(rs.getInt("id"));
                address.setStreetNumber(rs.getString("street_Number"));
                address.setStreetName(rs.getString("street_Name"));
                address.setZipCode((ZipCode) rs.getObject("zip_Code"));
                return address;
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



    public void update(Address address) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, address.getStreetNumber());
            stmt.setString(2, address.getStreetName());
            stmt.setObject(3,address.getZipCode());

            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }

}

