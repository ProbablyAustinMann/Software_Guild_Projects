/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.State;
import java.math.BigDecimal;

/**
 *
 * @author austinmann
 */
public interface FlooringMasteryStateDao {
    
        void loadStates() throws 
            FlooringMasteryPersistenceException;
    
    BigDecimal getTax(String nameOfState) throws 
            FlooringMasteryPersistenceException;
    
}
