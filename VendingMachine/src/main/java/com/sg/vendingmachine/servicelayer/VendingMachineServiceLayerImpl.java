/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.servicelayer;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.util.List;


/**
 *
 * @author austinmann
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {
    
    private VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;
    
    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public Item stockMachine(String machineNumber, Item item) throws
            VendingMachinePersistenceException {
        return dao.stockMachine(machineNumber, item);
    }

    @Override
    public List<Item> menuView() throws
            VendingMachinePersistenceException {
        return dao.menuView();
    }

    @Override
    public Item validateItem(String machineNumber) throws 
            VendingMachinePersistenceException, 
            VendingMachineNoItemInventoryException, 
            VendingMachineInsufficientFundsException {
            Item item = dao.promptItem(machineNumber);
        if (Integer.parseInt(item.getNumberInInventory()) <= 0) {
            throw new VendingMachineNoItemInventoryException("Error: That item isn't in stock!");
        } else {
        }
        return item;
    }
    
    @Override
    public Item editNumberInStock(Item item) throws 
            VendingMachinePersistenceException {
        return dao.editNumberInStock(item);
    }
    
    @Override
    public String checkUserInput(String userInput) throws 
            VendingMachineInsufficientFundsException {
        try {
            double userDouble = Double.parseDouble(userInput);
        } catch (NumberFormatException | NullPointerException e) {
            throw new VendingMachineInsufficientFundsException("C'mon Mark, that isn't valid.");
        }
        return userInput;
    }

}
