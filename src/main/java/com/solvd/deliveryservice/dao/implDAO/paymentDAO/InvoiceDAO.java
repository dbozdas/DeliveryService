package com.solvd.deliveryservice.dao.implDAO.paymentDAO;

import com.solvd.deliveryservice.databasemodel.order.Order;
import com.solvd.deliveryservice.databasemodel.payment.Invoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import static com.solvd.deliveryservice.connectionpool.DataSourceUtils.getConnection;
import static org.apache.logging.log4j.core.util.Closer.close;

public class InvoiceDAO {
    private static final Logger LOGGER = LogManager.getLogger(InvoiceDAO.class);

    private static final String INSERT = "INSERT INTO Deniz_Bozdas.Invoices VALUES(?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM Deniz_Bozdas.Invoices WHERE id=?";
    private static final String UPDATE = "UPDATE Deniz_Bozdas.Invoices SET order_Amount=?, discount=?, tax=?, total_Amount=?, date_of_invoice=?, Orders_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Deniz_Bozdas.Invoices WHERE id=?";

    public void insert(Invoice invoice) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, invoice.getOrderAmount());
            stmt.setDouble(2, invoice.getDiscount());
            stmt.setDouble(3, invoice.getTax());
            stmt.setDouble(4, invoice.getTotalAmount());
            stmt.setDate(5, (Date) invoice.getInvoiceDate());
            stmt.setObject(6, invoice.getOrder());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                invoice.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            close(stmt);
            close(conn);
        }
    }



    public Invoice findById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setId(rs.getInt("id"));
                invoice.setOrderAmount(rs.getDouble("order_Amount"));
                invoice.setDiscount(rs.getDouble("discount"));
                invoice.setTax(rs.getDouble("tax"));
                invoice.setTotalAmount(rs.getDouble("total_Amount"));
                invoice.setInvoiceDate(rs.getDate("date_of_invoice"));
                invoice.setOrder((Order) rs.getObject("Orders_id"));

                return invoice;
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



    public void update(Invoice invoice) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setDouble(1, invoice.getOrderAmount());
            stmt.setDouble(2, invoice.getDiscount());
            stmt.setDouble(3, invoice.getTax());
            stmt.setDouble(4, invoice.getTotalAmount());
            stmt.setDate(5, (Date) invoice.getInvoiceDate());
            stmt.setObject(6, invoice.getOrder());

            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }

}
