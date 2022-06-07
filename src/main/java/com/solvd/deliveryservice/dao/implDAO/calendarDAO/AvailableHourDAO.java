package com.solvd.deliveryservice.dao.implDAO.calendarDAO;

import com.solvd.deliveryservice.databasemodel.calendar.AvailableHour;
import com.solvd.deliveryservice.databasemodel.calendar.Weekday;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import static com.solvd.deliveryservice.connectionpool.DataSourceUtils.getConnection;
import static org.apache.logging.log4j.core.util.Closer.close;

public class AvailableHourDAO {
    private static final Logger LOGGER = LogManager.getLogger(AvailableHourDAO.class);

    private static final String INSERT = "INSERT INTO Deniz_Bozdas.Available_Hours VALUES(?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM Deniz_Bozdas.Available_Hours WHERE id=?";
    private static final String UPDATE = "UPDATE Deniz_Bozdas.Available_Hours SET shift_Start_Time=?, shift_End_Time=?, Week_Days_id=?, Drivers_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Deniz_Bozdas.Available_Hours WHERE id=?";

    public void insert(AvailableHour availableHour) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setDate(1, availableHour.getShiftStartTime());
            stmt.setDate(2, availableHour.getShiftEndTime());
            stmt.setObject(3, availableHour.getWeekday());
            stmt.setObject(4, availableHour.getDriver());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                availableHour.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            close(stmt);
            close(conn);
        }

    }



    public AvailableHour findById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                AvailableHour availableHour = new AvailableHour();
                availableHour.setId(rs.getInt("id"));
                availableHour.setShiftStartTime(rs.getDate("shift_Start_Time"));
                availableHour.setShiftEndTime(rs.getDate("shift_End_Time"));
                availableHour.setWeekday((Weekday) rs.getObject("week_Day"));
                availableHour.setDriver((Driver) rs.getObject("driver"));

                return availableHour;
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



    public void update(AvailableHour availableHour) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setDate(1, availableHour.getShiftStartTime());
            stmt.setDate(2, availableHour.getShiftEndTime());
            stmt.setObject(3, availableHour.getWeekday());
            stmt.setObject(4, availableHour.getDriver());

            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }

}
