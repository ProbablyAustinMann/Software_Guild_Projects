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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author austinmann
 */
public class FlooringMasteryOrderDaoStubImpl implements FlooringMasteryOrderDao {
    
    Order onlyOrder;
    List<Order> orderList = new ArrayList<>();
    
    public FlooringMasteryOrderDaoStubImpl() {
        onlyOrder = new Order();
        onlyOrder.setOrderNumber("000001");
        State state = new State("OH");
        Product product = new Product("Tile");
        onlyOrder.setState(state);
        onlyOrder.setProduct(product);
        onlyOrder.setDate("1/1/1111");
        onlyOrder.setCustomerName("Jim");
        onlyOrder.setArea(111);
        
        orderList.add(onlyOrder);
    }

    @Override
    public List<Order> displayOrder(String date) throws FlooringMasteryNoOrderException, FlooringMasteryInvalidDataException {
        if (date.equals(onlyOrder.getDate())) {
            return (List<Order>) onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order addOrder(String orderNumber, Order order) throws FlooringMasteryInvalidDataException {
        if (orderNumber.equals(onlyOrder.getOrderNumber())) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order editOrder(Order order, String date) throws FlooringMasteryNoOrderException, FlooringMasteryInvalidDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order removeOrder(Order order, String date) throws FlooringMasteryNoOrderException, FlooringMasteryInvalidDataException {
       if (order.getOrderNumber().equals(onlyOrder.getOrderNumber())) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public List<Order> displayAllOrders() throws FlooringMasteryPersistenceException {
        return orderList;
    }

    @Override
    public void loadOrders() throws FlooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
