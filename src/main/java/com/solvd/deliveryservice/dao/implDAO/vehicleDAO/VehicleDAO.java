package com.solvd.deliveryservice.dao.implDAO.vehicleDAO;

import com.solvd.deliveryservice.databasemodel.people.Driver;
import com.solvd.deliveryservice.databasemodel.vehicle.Insurance;
import com.solvd.deliveryservice.databasemodel.vehicle.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import static com.solvd.deliveryservice.connectionpool.DataSourceUtils.getConnection;
import static org.apache.logging.log4j.core.util.Closer.close;

public class VehicleDAO {
    private static final Logger LOGGER = LogManager.getLogger(VehicleDAO.class);

    private static final String INSERT = "INSERT INTO Deniz_Bozdas.Vehicles VALUES(?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM Deniz_Bozdas.Vehicles WHERE id=?";
    private static final String UPDATE = "UPDATE Deniz_Bozdas.Vehicles SET plate_Number=?, make=?, model=?, year=?, inspection_Expireation_Date=?, Drivers_id=?, Insurances_id  WHERE id=?";
    private static final String DELETE = "DELETE FROM Deniz_Bozdas.Vehicles WHERE id=?";

    public void insert(Vehicle vehicle) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, vehicle.getPlateNumber());
            stmt.setString(2, vehicle.getMake());
            stmt.setString(3, vehicle.getModel());
            stmt.setInt(4, vehicle.getYear());
            stmt.setDate(5, vehicle.getInspectionExpDate());
            stmt.setObject(6, vehicle.getDriver());
            stmt.setObject(7, vehicle.getInsurance());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                vehicle.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            close(stmt);
            close(conn);
        }
    }



    public Vehicle findById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id"));
                vehicle.setPlateNumber(rs.getString(""));
                vehicle.setMake(rs.getString(""));
                vehicle.setModel(rs.getString(""));
                vehicle.setYear(rs.getInt(""));
                vehicle.setInspectionExpDate(rs.getDate(""));
                vehicle.setDriver((Driver) rs.getObject(""));
                vehicle.setInsurance((Insurance) rs.getObject(""));


                return vehicle;
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



    public void update(Vehicle vehicle) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, vehicle.getPlateNumber());
            stmt.setString(2, vehicle.getMake());
            stmt.setString(3, vehicle.getModel());
            stmt.setInt(4, vehicle.getYear());
            stmt.setDate(5, vehicle.getInspectionExpDate());
            stmt.setObject(6, vehicle.getDriver());
            stmt.setObject(7, vehicle.getInsurance());

            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }

}

