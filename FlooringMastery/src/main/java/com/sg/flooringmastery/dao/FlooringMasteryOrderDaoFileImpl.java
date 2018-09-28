/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.State;
import com.sg.flooringmastery.service.FlooringMasteryInvalidDataException;
import com.sg.flooringmastery.service.FlooringMasteryNoOrderException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author austinmann
 */
public class FlooringMasteryOrderDaoFileImpl implements FlooringMasteryOrderDao {

    public static final String DELIMITER = ",";
    //list of orders
    private Map<String, Order> orders = new HashMap<>();
    //list of files from the createFileList method
    private List<String> fileList = new ArrayList<>();

    @Override
    public List<Order> displayOrder(String date) throws
            FlooringMasteryPersistenceException,
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException {

        ArrayList<Order> allOrders = new ArrayList<Order>(orders.values());
        ArrayList<Order> results = new ArrayList<Order>();
        //loadOrders();
        for (Order i : allOrders) {
            if (i.getDate().equals(date)) {
                results.add(i);
            }
        }
        return results;
    }

    @Override
    public Order addOrder(String orderNumber, Order order) throws
            FlooringMasteryInvalidDataException {
        Order newOrder = orders.put(orderNumber, order);
        return newOrder;
    }

    @Override
    public Order editOrder(Order order, String date) throws
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException {
        Order editedOrder = orders.replace(order.getOrderNumber(), order);
        return editedOrder;
    }

    @Override
    public Order removeOrder(Order order, String date) throws
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException {
        Order removedOrder = orders.remove(order.getOrderNumber());
        return removedOrder;
    }

    @Override
    public List<Order> displayAllOrders() throws
            FlooringMasteryPersistenceException {
        return new ArrayList<Order>(orders.values());
    }

    @Override
    //THIS FINALLY WORKS!!!!!!!!!!
    public void loadOrders() throws
            FlooringMasteryPersistenceException {
        Scanner scanner;
        
        //calls createFileList method
        List names = createFileList();
        //startes the loop by getting the file from the file array
        for (int i = 0; i < names.size(); i++) {
            String fileName = fileList.get(i);

            try {
                scanner = new Scanner(
                        new BufferedReader(
                                new FileReader(fileName)));

            } catch (FileNotFoundException e) {
                throw new FlooringMasteryPersistenceException("-_- Could not load data into memory", e);

            }
            //removes this first section of the file path and replaces it with nothing
            String trimTitle = fileName.replace("/Users/austinmann/NetBeansProjects/FlooringMastery/orderData/Orders_", "");
            //cuts off the '.txt. part
            String dateNumber = trimTitle.substring(0, 8);
            String currentLine;
            String[] currentTokens;

            //cycles through the file itself
            while (scanner.hasNextLine()) {

                currentLine = scanner.nextLine();
                currentTokens = currentLine.split(DELIMITER);
                Order currentOrder = new Order(currentTokens[0]);
                currentOrder.setCustomerName(currentTokens[1]);
                currentOrder.setState(new State(currentTokens[2]));
                currentOrder.getState().setTaxRate(new BigDecimal(currentTokens[3]));
                currentOrder.setProduct(new Product(currentTokens[4]));
                currentOrder.setArea(Double.parseDouble(currentTokens[5]));
                currentOrder.getProduct().setMaterialCost(new BigDecimal(currentTokens[6]));
                currentOrder.getProduct().setLaborCost(new BigDecimal(currentTokens[7]));
                currentOrder.setTotalLaborCost(new BigDecimal(currentTokens[8]));
                currentOrder.setTotalMaterialCost(new BigDecimal(currentTokens[9]));
                currentOrder.setTotalTaxes(new BigDecimal(currentTokens[10]));
                currentOrder.setTotal(new BigDecimal(currentTokens[11]));
                currentOrder.setDate(dateNumber);
                //adds file from the fileList array to the orderList array
                orders.put(currentOrder.getOrderNumber(), currentOrder);
            }
            scanner.close();
        }
    }

    public List<String> createFileList() {
        File file = new File("orderData/");
        File[] files = file.listFiles();
        for (File f : files) {
            fileList.add(f.getAbsolutePath());
        }
        return fileList;
    }
}
