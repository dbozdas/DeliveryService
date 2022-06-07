package com.solvd.deliveryservice.dao.implDAO.orderDAO;

import com.solvd.deliveryservice.databasemodel.order.Order;
import com.solvd.deliveryservice.databasemodel.order.Status;
import com.solvd.deliveryservice.databasemodel.people.Customer;
import com.solvd.deliveryservice.databasemodel.place.Restaurant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import static com.solvd.deliveryservice.connectionpool.DataSourceUtils.getConnection;
import static org.apache.logging.log4j.core.util.Closer.close;

public class OrderDAO {
    private static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);

    private static final String INSERT = "INSERT INTO Deniz_Bozdas.Orders VALUES(?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM Deniz_Bozdas.Orders WHERE id=?";
    private static final String UPDATE = "UPDATE Deniz_Bozdas.Orders SET order_date=?,special_Instricitions=?, Customers_id=?, Restaurants_id=?, Drivers_id=?, Statuses_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Deniz_Bozdas.Orders WHERE id=?";

    public void insert(Order order) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setTimestamp(1, order.getOrderDate());
            stmt.setString(2, order.getSpecialInst());
            stmt.setObject(3, order.getCustomer());
            stmt.setObject(4, order.getDriver());
            stmt.setObject(5, order.getStatus());
            stmt.setObject(6, order.getRestaurant());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                order.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            close(stmt);
            close(conn);
        }
    }



    public Order findById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setOrderDate(rs.getTimestamp("order_Date"));
                order.setSpecialInst(rs.getString("Special_inst"));
                order.setCustomer((Customer) rs.getObject("customer"));
                order.setDriver((Driver) rs.getObject("driver"));
                order.setStatus((Status) rs.getObject("status"));
                order.setRestaurant((Restaurant) rs.getObject("restaurant"));

                return order;
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



    public void update(Order order) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setTimestamp(1, order.getOrderDate());
            stmt.setString(2, order.getSpecialInst());
            stmt.setObject(3, order.getCustomer());
            stmt.setObject(4, order.getDriver());
            stmt.setObject(5, order.getStatus());
            stmt.setObject(6, order.getRestaurant());
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }


    public Order getOrdersByCustomerId(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setOrderDate(rs.getTimestamp("order_Date"));
                order.setSpecialInst(rs.getString("Special_inst"));
                order.setCustomer((Customer) rs.getObject("customer"));
                order.setDriver((Driver) rs.getObject("driver"));
                order.setStatus((Status) rs.getObject("status"));
                order.setRestaurant((Restaurant) rs.getObject("restaurant"));

                return order;
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
}