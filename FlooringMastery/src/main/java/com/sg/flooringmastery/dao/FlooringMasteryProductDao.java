/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import java.math.BigDecimal;

/**
 *
 * @author austinmann
 */
public interface FlooringMasteryProductDao {
    
    void loadProducts() throws 
            FlooringMasteryPersistenceException;
    
    BigDecimal laborCost(String nameOfProduct) throws 
            FlooringMasteryPersistenceException;
    
    BigDecimal materialCost(String nameOfProduct) throws 
            FlooringMasteryPersistenceException;
    
}
