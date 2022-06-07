package com.solvd.deliveryservice.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.deliveryservice.databasemodel.order.MenuItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JacksonParse {
    private static final Logger LOGGER = LogManager.getLogger(JacksonParse.class);

    public static void writeJsonFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            MenuItem menuItem = new MenuItem(8, "Ali", 15.00, "medium", "No nuts!");
            objectMapper.writeValue(new File("src/main/resources/menuItemWrite.json"), menuItem);

        } catch (JsonParseException e) {
            LOGGER.error(e.getMessage());
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static MenuItem readJsonFile() {
        MenuItem jsonMenuItem = null;
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            jsonMenuItem = objectMapper.readValue(new File("src/main/resources/menuItemRead.json"), MenuItem.class);
        }catch (JsonParseException e){
            LOGGER.error(e.getMessage());
        } catch (JsonProcessingException e){
            LOGGER.error(e.getMessage());
        } catch (IOException e){
            LOGGER.error(e.getMessage());
        }
        return jsonMenuItem;
    }
}

