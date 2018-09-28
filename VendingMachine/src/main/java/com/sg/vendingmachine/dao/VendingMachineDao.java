/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author austinmann
 */
public interface VendingMachineDao {
    
    Item stockMachine(String machineNumber, Item item) throws VendingMachinePersistenceException;
    
    List<Item> menuView() throws VendingMachinePersistenceException;
        
    Item promptItem(String machineNumber) throws VendingMachinePersistenceException;
        
    Item editNumberInStock(Item item) throws VendingMachinePersistenceException;
    
}
