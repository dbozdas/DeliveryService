package com.solvd.deliveryservice.dao.implDAO.addressDAO;

import com.solvd.deliveryservice.databasemodel.address.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import static com.solvd.deliveryservice.connectionpool.DataSourceUtils.getConnection;
import static org.apache.logging.log4j.core.util.Closer.close;

public class StateDAO {
    private static final Logger LOGGER = LogManager.getLogger(StateDAO.class);

    private static final String INSERT = "INSERT INTO Deniz_Bozdas.States VALUES(?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM Deniz_Bozdas.States WHERE id=?";
    private static final String UPDATE = "UPDATE Deniz_Bozdas.States SET code=?, name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Deniz_Bozdas.States WHERE id=?";

    public void insert(State state) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, state.getCode());
            stmt.setString(2, state.getName());


            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                state.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }

    }


    public State findById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                State state = new State();
                state.setId(rs.getInt("id"));
                state.setCode(rs.getString("name"));
                state.setName(rs.getString("State_id"));


                return state;
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



    public void update(State state) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, state.getCode());
            stmt.setString(2, state.getName());


            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }


}
