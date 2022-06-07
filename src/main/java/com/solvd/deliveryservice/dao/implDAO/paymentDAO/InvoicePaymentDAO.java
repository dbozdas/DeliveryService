package com.solvd.deliveryservice.dao.implDAO.paymentDAO;

import com.solvd.deliveryservice.databasemodel.payment.Invoice;
import com.solvd.deliveryservice.databasemodel.payment.InvoicePayment;
import com.solvd.deliveryservice.databasemodel.payment.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import static com.solvd.deliveryservice.connectionpool.DataSourceUtils.getConnection;
import static org.apache.logging.log4j.core.util.Closer.close;

public class InvoicePaymentDAO {
    private static final Logger LOGGER = LogManager.getLogger(InvoicePaymentDAO.class);

    private static final String INSERT = "INSERT INTO Deniz_Bozdas.Invoices_has_Payments VALUES(?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM Deniz_Bozdas.Invoices_has_Payments WHERE id=?";
    private static final String UPDATE = "UPDATE Deniz_Bozdas.Invoices_has_Payments SET Invoices_id=?, Payments_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Deniz_Bozdas.Invoices_has_Payments WHERE id=?";

    public void insert(InvoicePayment invoicePayment) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, invoicePayment.getInvoice());
            stmt.setObject(2, invoicePayment.getPayment());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                invoicePayment.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            close(stmt);
            close(conn);
        }
    }



    public InvoicePayment findById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                InvoicePayment invoicePayment = new InvoicePayment();
                invoicePayment.setId(rs.getInt("id"));
                invoicePayment.setInvoice((Invoice) rs.getObject("Invoices_id"));
                invoicePayment.setPayment((Payment) rs.getObject("Payments_id"));

                return invoicePayment;
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



    public void update(InvoicePayment invoicePayment) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setObject(1, invoicePayment.getInvoice());
            stmt.setObject(2, invoicePayment.getPayment());

            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(stmt);
            close(conn);
        }
    }

}
