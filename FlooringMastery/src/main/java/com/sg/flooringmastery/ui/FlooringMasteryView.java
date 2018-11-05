/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.State;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author austinmann
 */
public class FlooringMasteryView {
    
    private UserIO io;
    
    public FlooringMasteryView(UserIO io){
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("******************************");
        io.print("FLOOR STORE");
        io.print("1. Display Orders");
        io.print("2. Add an Order");
        io.print("3. Edit an Order");
        io.print("4. Remove an Order");
        io.print("5. Save Current Work");
        io.print("6. Quit");
        io.print("******************************");
        
        return io.readInt("Please make a selection", 1, 1000000000);
    }
    
    public String displayOrderListBanner() {
       io.print("=== ORDER LIST ===");
        return io.readString("Please enter a date");
    }
    
    public void displayOrderList(List<Order> orderList) {
        for (Order currentOrder : orderList) {
            io.print(currentOrder.getOrderNumber() + " | " + 
                    currentOrder.getCustomerName() + " | " + 
                    currentOrder.getProduct().getMaterialName() + " | " + 
                    currentOrder.getState().getStateName() + " | " +
                    currentOrder.getArea() + " | " + 
                    currentOrder.getTotal());
        }
        io.print("=====================================================");
    }
    
    public void displayAddOrderBanner() {
        io.print("=== ADD NEW ORDER ===");
    }
    
    public Order getNewOrderInfo() throws FlooringMasteryPersistenceException {
        String orderNumber = UUID.randomUUID().toString().substring(0, 6);
        String stateName = io.readString("Enter state (OH, PA, MI, IN)");
        State nameOfState = new State(stateName.toUpperCase());
        String productName = io.readString("Enter flooring material (Carpet, Laminate, Tile, Wood)");
        Product nameOfProduct = new Product(productName);
        String date = io.readString("Enter date");
        String customerName = io.readString("Enter customer name");
        double area = io.readDouble("Enter area");
        Order newOrder = new Order();
        newOrder.setOrderNumber(orderNumber);
        newOrder.setState(nameOfState);
        newOrder.setProduct(nameOfProduct);
        newOrder.setDate(date);
        newOrder.setCustomerName(customerName);
        newOrder.setArea(area);
        return newOrder;  
    }
    
    public void displayAddSuccessBanner() {
        io.print("Order successfully added.");
    }
    
    public void displayEditOrderBanner() {
        io.print("=== EDIT ORDER ===");
    }
    
    public String getDate() {
        return io.readString("Enter order date");  
    }
    
    public String getNumber() {
        return io.readString("Enter order number");
    }

    public Order editOrder() throws
        FlooringMasteryPersistenceException {
        String orderNumber = getNumber();
        Order editedOrder = new Order();
        editedOrder.setOrderNumber(orderNumber);
          String stateName = io.readString("Enter state (OH, PA, MI, IN)");
          State nameOfState = new State(stateName.toUpperCase());
          if (stateName != null) {
              editedOrder.setState(nameOfState);
          }
          String productName = io.readString("Enter product");
          Product nameOfProduct = new Product(productName);
          if (productName != null) {
              editedOrder.setProduct(nameOfProduct);
          }
          String date = io.readString("Enter date");
          if (date != null) {
              editedOrder.setDate(date);
          }
          String name = io.readString("Enter name");
          if (name != null) {
              editedOrder.setCustomerName(name);
          }
          double area = io.readDouble("Enter area");
          if (area != 0) {
              editedOrder.setArea(area);
          }
          return editedOrder;
   }
    
    public void displayEditSuccessBanner() {
        io.print("Order successfully edited.");
    }
    
    public void displayRemoveOrderBanner() {
        io.print("=== REMOVE ORDER ===");
    }
    
    public void displayRemoveSuccessBaner() {
        io.print("Order successfully removed.");
    }
    
    public void displayErrorMessage(String errorMessage) {
        io.print("=== ERROR ===");
        io.print(errorMessage);
    }
    
    public void displayUnknownCommandMessage() {
        io.print("Unknown Command!");
    }
    
    public void displaySaveSuccessfulBanner() {
        io.print("Save Successful.");
    }
    
    public int getMode() {
        io.print("1. Production Mode");
        io.print("2. Training Mode");
        return io.readInt("Please make a selection", 1, 2);
    }
    
    public void displayNoSaveBanner() {
        io.print("This feature is unavailable in training mode");
    }
    
    public int saveChanges() {
        io.print("Would you like to save your changes?");
        io.print("1. Yes");
        io.print("2. No");
        return io.readInt("Please make a selection");
    }
}
