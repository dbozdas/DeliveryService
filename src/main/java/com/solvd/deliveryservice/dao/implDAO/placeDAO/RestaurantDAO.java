package com.solvd.deliveryservice.dao.implDAO.placeDAO;

import com.solvd.deliveryservice.databasemodel.address.Address;
import com.solvd.deliveryservice.databasemodel.place.Restaurant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;

import static com.solvd.deliveryservice.connectionpool.DataSourceUtils.getConnection;
import static org.apache.logging.log4j.core.util.Closer.close;

public class RestaurantDAO {
    private static final Logger LOGGER = LogManager.getLogger(RestaurantDAO.class);

    private static final String INSERT = "INSERT INTO Deniz_Bozdas.Restaurants VALUES(?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM Deniz_Bozdas.Restaurants  WHERE id=?";
    private static final String UPDATE = "UPDATE Deniz_Bozdas.Restaurants  SET name=?, phone_Number=?, rating=?, Address_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM Deniz_Bozdas.Restaurants  WHERE id=?";

    public void insert(Restaurant restaurant) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getPhoneNumber());
            stmt.setDouble(3, restaurant.getRating());
            stmt.setObject(4, restaurant.getAddress());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                restaurant.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            close(stmt);
            close(conn);
        }
    }



    public Restaurant findById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(rs.getInt("id"));
                restaurant.setName(rs.getString(""));
                restaurant.setPhoneNumber(rs.getString(""));
                restaurant.setRating(rs.getDouble(""));
                restaurant.setAddress((Address) rs.getObject(""));


                return restaurant;
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



    public void update(Restaurant restaurant) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, restaurant.getName());
            stmt.setString(5, restaurant.getPhoneNumber());
            stmt.setDouble(6, restaurant.getRating());
            stmt.setObject(7, restaurant.getAddress());

            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }

}



