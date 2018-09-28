/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author austinmann
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {
    
    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = " :: ";
    
    private Map<String, Item> items = new HashMap<>();
    
    @Override
    public Item stockMachine(String machineNumber, Item item) throws VendingMachinePersistenceException {
        Item newItem = items.put(machineNumber, item);
        writeInventory();
           return newItem;     
    }
    
    @Override
    public List<Item> menuView() throws VendingMachinePersistenceException {
        loadInventory();
        return new ArrayList<Item> (items.values()).stream()
                .filter(m -> !m.getNumberInInventory().equals("0"))
                .collect(Collectors.toList());
    }
    
    @Override
    public Item promptItem(String machineNumber) throws VendingMachinePersistenceException {
        return items.get(machineNumber);
    }

    @Override
    public Item editNumberInStock(Item item) throws VendingMachinePersistenceException {
        //Item item = vendItem();
        int stock = Integer.parseInt(item.getNumberInInventory());
        String toString = Integer.toString(stock - 1);
        item.setNumberInInventory(toString);
        writeInventory();
        return item;
    }
    
    private void loadInventory() throws VendingMachinePersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
            new BufferedReader(
            new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("-_- Could not load data into memory", e);
        }
        
        String currentLine;
        
        String[] currentTokens;
        
        while (scanner.hasNextLine()) {
            
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Item currentItem = new Item(currentTokens[0]);
            currentItem.setName(currentTokens[1]);
            currentItem.setPrice(currentTokens[2]);
            currentItem.setNumberInInventory(currentTokens[3]);
            items.put(currentItem.getMachineNumber(), currentItem);
        }
        scanner.close();
    }
    
    public void writeInventory() throws VendingMachinePersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Cound not save data", e);
        }
        
        
        List<Item> itemList = this.menuView();
        
        for (Item currentItem : itemList) {
            out.println(currentItem.getMachineNumber() + DELIMITER + currentItem.getName() + DELIMITER
            + currentItem.getPrice() + DELIMITER + currentItem.getNumberInInventory());
            out.flush();
        }
        out.close();
    }
}
