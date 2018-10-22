/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author austinmann
 */
public class VendingMachineDaoInMemImpl implements VendingMachineDao {

    List<Item> itemList;

    //creates the list of items to vend
    public VendingMachineDaoInMemImpl() {
        itemList = new ArrayList<>();

        Item item1 = new Item();
        item1.setMachineNumber(1);
        item1.setName("Snickers");
        item1.setPrice(new BigDecimal("1.25"));
        item1.setNumberInInventory(4);
        itemList.add(item1);

        Item item2 = new Item();
        item2.setMachineNumber(2);
        item2.setName("Milky Way");
        item2.setPrice(new BigDecimal("1.40"));
        item2.setNumberInInventory(5);
        itemList.add(item2);

        Item item3 = new Item();
        item3.setMachineNumber(3);
        item3.setName("Payday");
        item3.setPrice(new BigDecimal("1.60"));
        item3.setNumberInInventory(3);
        itemList.add(item3);

        Item item4 = new Item();
        item4.setMachineNumber(4);
        item4.setName("Lay's");
        item4.setPrice(new BigDecimal("1.50"));
        item4.setNumberInInventory(3);
        itemList.add(item4);

        Item item5 = new Item();
        item5.setMachineNumber(5);
        item5.setName("Doritos");
        item5.setPrice(new BigDecimal("1.30"));
        item5.setNumberInInventory(2);
        itemList.add(item5);

        Item item6 = new Item();
        item6.setMachineNumber(6);
        item6.setName("Chex Mix");
        item6.setPrice(new BigDecimal("1.70"));
        item6.setNumberInInventory(6);
        itemList.add(item6);

        Item item7 = new Item();
        item7.setMachineNumber(7);
        item7.setName("Coca Cola");
        item7.setPrice(new BigDecimal("2.05"));
        item7.setNumberInInventory(4);
        itemList.add(item7);

        Item item8 = new Item();
        item8.setMachineNumber(8);
        item8.setName("Sprite");
        item8.setPrice(new BigDecimal("1.85"));
        item8.setNumberInInventory(2);
        itemList.add(item8);

        Item item9 = new Item();
        item9.setMachineNumber(9);
        item9.setName("Dr. Pepper");
        item9.setPrice(new BigDecimal("1.75"));
        item9.setNumberInInventory(1);
        itemList.add(item9);
    }

    //method to get all items
    @Override
    public List<Item> getItems() {
        return itemList;
    }
    
    //method to get all attributes of a particular item
    @Override
    public Item getId(int input) {
        return itemList.get(input - 1);
    }
    
}