package com.solvd.deliveryservice.dao.implDAO.orderDAO;

import com.solvd.deliveryservice.databasemodel.order.MenuItem;
import com.solvd.deliveryservice.databasemodel.order.Order;
import com.solvd.deliveryservice.databasemodel.order.OrderMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import static com.solvd.deliveryservice.connectionpool.DataSourceUtils.getConnection;
import static org.apache.logging.log4j.core.util.Closer.close;

public class OrderMenuDAO {
    private static final Logger LOGGER = LogManager.getLogger(OrderMenuDAO.class);

    private static final String INSERT = "INSERT INTO Deniz_Bozdas.Orders_has_Menu_Items ALUES(?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM Deniz_Bozdas.Orders_has_Menu_Items WHERE id=?";
    private static final String UPDATE = "UPDATE Deniz_Bozdas.Orders_has_Menu_Items SET Orders_id=?,menu_Items_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Deniz_Bozdas.Orders_has_Menu_Items WHERE id=?";

    public void insert(OrderMenu orderMenu) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, orderMenu.getOrder());
            stmt.setObject(2, orderMenu.getMenuItem());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                orderMenu.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            close(stmt);
            close(conn);
        }
    }



    public OrderMenu findById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                OrderMenu orderMenu = new OrderMenu();
                orderMenu.setId(rs.getInt("id"));
                orderMenu.setOrder((Order) rs.getObject(""));
                orderMenu.setMenuItem((MenuItem) rs.getObject(""));

                return orderMenu;
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



    public void update(OrderMenu orderMenu) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setObject(1, orderMenu.getOrder());
            stmt.setObject(2, orderMenu.getMenuItem());
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }

}
