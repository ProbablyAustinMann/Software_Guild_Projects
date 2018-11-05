/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryOrderDao;
import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.FlooringMasteryProductDao;
import com.sg.flooringmastery.dao.FlooringMasteryStateDao;
import com.sg.flooringmastery.dto.Order;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author austinmann
 */
public class FlooringMasteryServiceLayerImpl implements FlooringMasteryServiceLayer {

    public static final String DELIMITER = ",";

    private Map<String, Order> orders = new HashMap<>();

    private FlooringMasteryOrderDao orderDao;
    private FlooringMasteryStateDao stateDao;
    private FlooringMasteryProductDao productDao;

    public FlooringMasteryServiceLayerImpl(FlooringMasteryOrderDao orderDao, FlooringMasteryStateDao stateDao, 
            FlooringMasteryProductDao productDao) {
        this.orderDao = orderDao;
        this.stateDao = stateDao;
        this.productDao = productDao;
    }

    @Override
    public List<Order> displayOrder(String date) throws
            FlooringMasteryPersistenceException,
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException {
        return orderDao.displayOrder(date);
    }

    @Override
    public Order addOrder(Order order) throws
            FlooringMasteryInvalidDataException {
        return orderDao.addOrder(order.getOrderNumber(), order);
    }

    @Override
    public Order editOrder(Order order, String date) throws
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException {
        return orderDao.editOrder(order, date);
    }

    @Override
    public Order removeOrder(Order order, String date) throws
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException {
        return orderDao.removeOrder(order, date);
    }

    @Override
    public Order checkForValidData(Order order) throws
            FlooringMasteryInvalidDataException {
        if (order.getState() == null || order.getProduct() == null
                || order.getDate().trim().length() == 0 || order.getCustomerName() == null
                || order.getArea() == 0 || order.getArea() < 0) {
            throw new FlooringMasteryInvalidDataException("Please fill out required fields");
        }
        return order;
    }

    //writes order info to a text file
    @Override
    public void writeFile() throws
            FlooringMasteryPersistenceException,
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException {
        List<Order> orderList = orderDao.displayAllOrders();
        List<String> date = getDates(orderList);
        for (String currentDate : date) {

            try {
                String orderFile = "Orders_" + currentDate + ".txt";
                PrintWriter out = new PrintWriter(new FileWriter(new File("orderData", orderFile)));
                orderList.stream().map((currentOrder) -> {
                    if (currentOrder.getDate().equals(currentDate)) {
                        out.println(currentOrder.getOrderNumber() + DELIMITER + currentOrder.getCustomerName() + DELIMITER
                                + currentOrder.getState().getStateName() + DELIMITER + currentOrder.getState().getTaxRate() + DELIMITER
                                + currentOrder.getProduct().getMaterialName() + DELIMITER + currentOrder.getArea() + DELIMITER
                                + currentOrder.getProduct().getMaterialCost() + DELIMITER + currentOrder.getProduct().getLaborCost() + DELIMITER
                                + currentOrder.getTotalMaterialCost() + DELIMITER + currentOrder.getTotalLaborCost() + DELIMITER
                                + currentOrder.getTotalTaxes() + DELIMITER + currentOrder.getTotal());
                    }
                    return currentOrder;
                }).forEachOrdered((_item) -> {
                    out.flush();
                });
                out.close();

            } catch (IOException e) {
                throw new FlooringMasteryPersistenceException("Could not save library data", e);
            }
        }
    }

    //calculates the total cost of the order
    @Override
    public Order calculateCost(Order order) throws
            FlooringMasteryPersistenceException,
            FlooringMasteryInvalidDataException {
        stateDao.loadStates();
        productDao.loadProducts();
        BigDecimal percentage = new BigDecimal("0.01");
        BigDecimal areaDecimal = new BigDecimal(order.getArea());
        BigDecimal tax = stateDao.getTax(order.getState().getStateName()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal taxRate = tax.multiply(percentage).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal rate = productDao.laborCost(order.getProduct().getMaterialName()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal materialCost = productDao.materialCost(order.getProduct().getMaterialName()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal totalMaterialWithoutTax = areaDecimal.multiply(materialCost).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal totalLaborWithoutTax = areaDecimal.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal totalWithoutTax = totalMaterialWithoutTax.add(totalLaborWithoutTax).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal totalTax = totalWithoutTax.multiply(taxRate).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal grandTotal = totalTax.add(totalWithoutTax).setScale(2, BigDecimal.ROUND_HALF_UP);

        order.getState();
        order.getState().setTaxRate(order.getState().getTaxRate());
        order.getProduct();
        order.getProduct().setLaborCost(order.getProduct().getLaborCost());
        order.getProduct().setMaterialCost(order.getProduct().getMaterialCost());
        order.setTotalMaterialCost(totalMaterialWithoutTax);
        order.setTotalLaborCost(totalLaborWithoutTax);
        order.setTotalTaxes(totalTax);
        order.setTotal(grandTotal);
        return order;
    }

    //lists dates in an array list
    private List<String> getDates(List<Order> orderList) {
        List<String> dates = new ArrayList<>();
        orderList.forEach((currentOrder) -> {
            dates.add(currentOrder.getDate());
        });
        return dates;
    }

    @Override
    public void loadFile() throws 
            FlooringMasteryPersistenceException {
        orderDao.loadOrders();
    }

}
