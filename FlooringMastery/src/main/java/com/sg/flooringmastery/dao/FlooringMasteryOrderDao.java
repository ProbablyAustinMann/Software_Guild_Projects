/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.service.FlooringMasteryInvalidDataException;
import com.sg.flooringmastery.service.FlooringMasteryNoOrderException;
import java.util.List;

/**
 *
 * @author austinmann
 */
public interface FlooringMasteryOrderDao {
    
    public List<Order> displayOrder(String date) throws 
            FlooringMasteryPersistenceException,
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException;
    
    public Order addOrder(String orderNumber, Order order) throws 
            FlooringMasteryInvalidDataException;
    
    public Order editOrder(Order order, String date) throws 
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException;
    
    public Order removeOrder(Order order, String date) throws 
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException;
    
        List <Order> displayAllOrders() throws 
            FlooringMasteryPersistenceException;
        
        public void loadOrders() throws 
            FlooringMasteryPersistenceException;
    
}
