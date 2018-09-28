/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.servicelayer.VendingMachineInsufficientFundsException;
import com.sg.vendingmachine.servicelayer.VendingMachineNoItemInventoryException;
import com.sg.vendingmachine.servicelayer.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author austinmann
 */
public class VendingMachineController {
   
    VendingMachineView view;
    VendingMachineServiceLayer serviceLayer;
    private UserIO io = new UserIOConsoleImpl();

    
    public VendingMachineController(VendingMachineServiceLayer serviceLayer, VendingMachineView view) {
        this.serviceLayer = serviceLayer;
        this.view = view;
    }
        //variables
        boolean keepGoing = true;
        String userMoney;
        BigDecimal userDecimal;
        BigDecimal quarter = new BigDecimal(".25");
        BigDecimal dime = new BigDecimal(".10");
        BigDecimal nickel = new BigDecimal(".05");
        BigDecimal penny = new BigDecimal(".01");
        String userSelection;

    //the main attraction
    public void run() {
        
        try {

        while(keepGoing == true) {
        menuView();
        
        userMoney = takeMoney();
        if (userMoney.equalsIgnoreCase("Exit")) {
            keepGoing = false;
        } else if (userMoney.equals("Time to restock")) {
            stockMachine();
        } else {
            serviceLayer.checkUserInput(userMoney);
        }

        userDecimal = convertUserMoney();
        userSelection = promptItem();
        
        Item item = serviceLayer.validateItem(userSelection);

        vendItem(item);
        serviceLayer.editNumberInStock(item);
        
        }
    } catch (VendingMachinePersistenceException | 
            VendingMachineNoItemInventoryException | 
            NumberFormatException | 
            VendingMachineInsufficientFundsException e) {
        view.displayErrorMessage(e.getMessage());
    }
  }
    
    //I used this method to stock the machine
    private void stockMachine() throws VendingMachinePersistenceException {
        Item newItem = view.getNewItemInfo();
        serviceLayer.stockMachine(newItem.getMachineNumber(), newItem);
        view.addSuccessBanner();
    }
    
    //Displays the menu
    private void menuView() throws VendingMachinePersistenceException {
        view.displayGreetingBanner();
        List<Item> itemList = serviceLayer.menuView();
        view.displayMenuView(itemList);
    }
    //Takes money
    private String takeMoney() {
        return view.takeUserMoney();
    }
    
    //Prompts user for an item, dispenses the item, and gives change...
    private String promptItem() throws VendingMachinePersistenceException {
        return view.getUserSelection();
    }
    
    private void vendItem(Item item) throws VendingMachinePersistenceException {
        String itemPrice = item.getPrice();
        BigDecimal itemP = new BigDecimal(itemPrice);
        BigDecimal itemPriceDecimal = itemP.setScale(2, RoundingMode.HALF_UP);
        if (itemPriceDecimal.compareTo(userDecimal) <= 0) {
            view.vendUserItem(item);
            BigDecimal remainingChange = userDecimal.subtract(itemPriceDecimal);
            BigDecimal remainingQuarter[] = remainingChange.divideAndRemainder(quarter);
            io.print(remainingQuarter[0].toString() + " Quarters");
            BigDecimal remainingDime[] = remainingQuarter[1].divideAndRemainder(dime);
            io.print(remainingDime[0].toString() + " Dimes");
            BigDecimal remainingNickel[] = remainingDime[1].divideAndRemainder(nickel);
            io.print(remainingNickel[0].toString() + " Nickels");
            BigDecimal remainingPenny[] = remainingNickel[1].divideAndRemainder(penny);
            io.print(remainingPenny[0].toString() + " Pennies");
        //...or tells them they don't have enough money, returns their money, and returns them to the main menu
        } else {
            io.print("Not enough money! You only have $" + userMoney + "!");
        }
    }
    
    private BigDecimal convertUserMoney() {
        BigDecimal userD = new BigDecimal(userMoney);
        userDecimal = userD.setScale(2, RoundingMode.HALF_UP);
        return userDecimal;
    }
}
