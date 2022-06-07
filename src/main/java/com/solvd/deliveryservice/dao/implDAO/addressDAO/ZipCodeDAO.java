package com.solvd.deliveryservice.dao.implDAO.addressDAO;

import com.solvd.deliveryservice.databasemodel.address.City;
import com.solvd.deliveryservice.databasemodel.address.State;
import com.solvd.deliveryservice.databasemodel.address.ZipCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import static com.solvd.deliveryservice.connectionpool.DataSourceUtils.getConnection;
import static org.apache.logging.log4j.core.util.Closer.close;

public class ZipCodeDAO {
    private static final Logger LOGGER = LogManager.getLogger(ZipCodeDAO.class);

    private static final String INSERT = "INSERT INTO Deniz_Bozdas.Zip_Codes VALUES(?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM Deniz_Bozdas.Zip_Codes WHERE id=?";
    private static final String UPDATE = "UPDATE Deniz_Bozdas.Zip_Codes SET zip_Code=?, Cities_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Deniz_Bozdas.Zip_Codes WHERE id=?";

    public void insert(ZipCode zipCode) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, zipCode.getZipCode());
            stmt.setObject(2, zipCode.getCity());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                zipCode.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            close(stmt);
            close(conn);
        }

    }



    public ZipCode findById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ZipCode zipCode = new ZipCode();
                zipCode.setId(rs.getInt("id"));
                zipCode.setZipCode(rs.getString("zip_Code"));
                zipCode.setCity((City) rs.getObject("city"));

                return zipCode;
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



    public void update(ZipCode zipCode) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, zipCode.getZipCode());
            stmt.setObject(2, zipCode.getCity());

            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }

}
