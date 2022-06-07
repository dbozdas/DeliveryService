package com.solvd.deliveryservice.dao.implDAO.orderDAO;

import com.solvd.deliveryservice.databasemodel.order.MenuItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import static com.solvd.deliveryservice.connectionpool.DataSourceUtils.getConnection;
import static org.apache.logging.log4j.core.util.Closer.close;

public class MenuItemDAO {
    private static final Logger LOGGER = LogManager.getLogger(MenuItemDAO.class);

    private static final String INSERT = "INSERT INTO Deniz_Bozdas.Menu_Items VALUES(?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM Deniz_Bozdas.Menu_Items  WHERE id=?";
    private static final String UPDATE = "UPDATE Deniz_Bozdas.Menu_Items  SET name=?, price=?, size=?, special_inst=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Deniz_Bozdas.Menu_Items  WHERE id=?";

    public void insert(MenuItem menuItem) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, menuItem.getName());
            stmt.setDouble(2, menuItem.getPrice());
            stmt.setString(3, menuItem.getSize());
            stmt.setString(4, menuItem.getSpecialInst());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                menuItem.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            close(stmt);
            close(conn);
        }

    }



    public MenuItem findById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                MenuItem menuItem = new MenuItem();
                menuItem.setId(rs.getInt("id"));
                menuItem.setName(rs.getString("name"));
                menuItem.setPrice(rs.getDouble("price"));
                menuItem.setSize(rs.getString("size"));
                menuItem.setSpecialInst(rs.getString("special_Inst"));

                return menuItem;
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



    public void update(MenuItem menuItem) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, menuItem.getName());
            stmt.setDouble(2, menuItem.getPrice());
            stmt.setString(3, menuItem.getSize());
            stmt.setString(4, menuItem.getSpecialInst());

            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }

}
