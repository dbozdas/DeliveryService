package com.solvd.deliveryservice.dao.implDAO.vehicleDAO;

import com.solvd.deliveryservice.databasemodel.vehicle.Insurance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import static com.solvd.deliveryservice.connectionpool.DataSourceUtils.getConnection;
import static org.apache.logging.log4j.core.util.Closer.close;

public class InsuranceDAO {
    private static final Logger LOGGER = LogManager.getLogger(InsuranceDAO.class);

    private static final String INSERT = "INSERT INTO Deniz_Bozdas.Insurances VALUES(?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM Deniz_Bozdas.Insurances WHERE id=?";
    private static final String UPDATE = "UPDATE Deniz_Bozdas.Insurances  SET effective_Date=?, expiration_Date=?, liability_Coverage=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM Deniz_Bozdas.Insurances  WHERE id=?";

    public void insert(Insurance insurance) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setDate(1, insurance.getEffDate());
            stmt.setDate(2, insurance.getExpDate());
            stmt.setDouble(3, insurance.getCoverage());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                insurance.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            close(stmt);
            close(conn);
        }
    }



    public Insurance findById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Insurance insurance = new Insurance();
                insurance.setId(rs.getInt("id"));
                insurance.setEffDate(rs.getDate(""));
                insurance.setExpDate(rs.getDate(""));
                insurance.setCoverage(rs.getDouble(""));


                return insurance;
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



    public void update(Insurance insurance) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setDate(1, insurance.getEffDate());
            stmt.setDate(2, insurance.getExpDate());
            stmt.setDouble(3, insurance.getCoverage());

            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }

}



