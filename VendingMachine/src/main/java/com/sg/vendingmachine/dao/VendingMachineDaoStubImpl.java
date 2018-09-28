/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author austinmann
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {
    
    Item onlyItem;
    List<Item> itemList = new ArrayList<>();
    
    public VendingMachineDaoStubImpl() {
        onlyItem = new Item("A8");
        onlyItem.setName("Hersheys");
        onlyItem.setPrice("1.00");
        onlyItem.setNumberInInventory("3");
        itemList.add(onlyItem);
    }

    @Override
    public Item stockMachine(String machineNumber, Item item) throws VendingMachinePersistenceException {
        if (machineNumber.equals(onlyItem.getMachineNumber())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public List<Item> menuView() throws VendingMachinePersistenceException {
        return itemList;
    }

    @Override
    public Item promptItem(String machineNumber) throws VendingMachinePersistenceException {
        if (machineNumber.equals(onlyItem.getMachineNumber())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public Item editNumberInStock(Item item) throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
