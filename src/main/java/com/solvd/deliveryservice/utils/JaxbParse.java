package com.solvd.deliveryservice.utils;

import com.solvd.deliveryservice.databasemodel.people.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.bind.*;
import java.io.File;

public class JaxbParse {
    private static final Logger LOGGER = LogManager.getLogger(JaxbParse.class);

    public static void jaxbObjectToXML(Customer customer) {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Store XML to File
            File file = new File("src/main/resources/customerWrite.xml");

            //Writes XML file to file-system
            jaxbMarshaller.marshal(customer, file);

        } catch (JAXBException ex) {
            LOGGER.error(ex.getMessage());
        }

    }

    public Customer XMLtojaxbObject() {

        File xmlFile = new File("jaxb/customerRead.xml");
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(Customer.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Customer customer = (Customer) jaxbUnmarshaller.unmarshal(xmlFile);

            LOGGER.info(customer);

        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
        }

        return null ;
    }
}