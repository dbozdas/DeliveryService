package com.solvd.deliveryservice.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.deliveryservice.dao.implDAO.addressDAO.AddressDAO;
import com.solvd.deliveryservice.databasemodel.order.MenuItem;
import com.solvd.deliveryservice.databasemodel.people.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class DomParse {
    private static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);

    public static void main(String[] args) throws IOException {

        try {
            File inputFile = new File("src/main/resources/input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            //LOGGER.info("Root element :" + doc.getDocumentElement().getNodeName());

            List<Customer> customerList = new ArrayList<>();
            //NodeList nList = doc.getElementsByTagName("customer");
            NodeList nList = doc.getDocumentElement().getChildNodes();


            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                LOGGER.info("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    LOGGER.info("Customer id : "
                            + eElement.getAttribute("id"));
                    LOGGER.info("First Name : "
                            + eElement
                            .getElementsByTagName("firstName")
                            .item(0)
                            .getTextContent());
                    LOGGER.info("Last Name : "
                            + eElement
                            .getElementsByTagName("lastName")
                            .item(0)
                            .getTextContent());
                    LOGGER.info("Date Of Birth : "
                            + eElement
                            .getElementsByTagName("dateOfBirth")
                            .item(0)
                            .getTextContent());
                    LOGGER.info("E-Mail : "
                            + eElement
                            .getElementsByTagName("email")
                            .item(0)
                            .getTextContent());
                    LOGGER.info("Phone Number : "
                            + eElement
                            .getElementsByTagName("phoneNumber")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

}
