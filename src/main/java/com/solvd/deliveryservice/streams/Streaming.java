package com.solvd.deliveryservice.streams;

import com.solvd.deliveryservice.databasemodel.people.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Streaming {
    private static final Logger LOGGER = LogManager.getLogger(Streaming.class);

    public static void main(String[] args) {

        List<Customer> customerLists = new ArrayList<Customer>();
        customerLists.stream()
                .map(e -> e.getAddress().getStreetName())
                .distinct()
                .forEach(System.out::println);

    }
}
