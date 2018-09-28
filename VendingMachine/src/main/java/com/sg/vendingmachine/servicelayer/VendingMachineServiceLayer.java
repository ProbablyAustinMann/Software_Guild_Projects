/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.servicelayer;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author austinmann
 */
public interface VendingMachineServiceLayer {
    
    
    
        Item stockMachine(String machineNumber, Item item) throws
            VendingMachinePersistenceException;
    
    List<Item> menuView() throws
            VendingMachinePersistenceException;

    
    Item validateItem(String machineNumber) throws
            VendingMachinePersistenceException,
            VendingMachineNoItemInventoryException,
            VendingMachineInsufficientFundsException;
    
    
    Item editNumberInStock(Item item) throws 
            VendingMachinePersistenceException;
    
    String checkUserInput(String userInput) throws 
            VendingMachineInsufficientFundsException;
    
}
