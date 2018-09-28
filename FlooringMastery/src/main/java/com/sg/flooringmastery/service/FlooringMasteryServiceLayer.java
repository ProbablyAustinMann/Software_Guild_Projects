/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import java.util.List;

/**
 *
 * @author austinmann
 */
public interface FlooringMasteryServiceLayer {

    List<Order> displayOrder(String date) throws
            FlooringMasteryPersistenceException,
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException;

    Order addOrder(Order order) throws
            FlooringMasteryInvalidDataException;

    Order editOrder(Order order, String date) throws
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException;

    Order removeOrder(Order order, String date) throws
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException;

    Order checkForValidData(Order order) throws
            FlooringMasteryInvalidDataException;

    void writeFile() throws
            FlooringMasteryPersistenceException,
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException;
    
    Order calculateCost(Order order) throws 
            FlooringMasteryPersistenceException,
            FlooringMasteryInvalidDataException;
    
    void loadFile() throws 
            FlooringMasteryPersistenceException;

}
