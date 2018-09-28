/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.service.FlooringMasteryInvalidDataException;
import com.sg.flooringmastery.service.FlooringMasteryNoOrderException;
import com.sg.flooringmastery.service.FlooringMasteryServiceLayer;
import com.sg.flooringmastery.ui.FlooringMasteryView;
import java.util.List;

/**
 *
 * @author austinmann
 */
public class FlooringMasteryController {

    FlooringMasteryView view;
    FlooringMasteryServiceLayer service;

    public FlooringMasteryController(FlooringMasteryView view, FlooringMasteryServiceLayer service) {
        this.view = view;
        this.service = service;
    }
    boolean modeChoice = true;

    public void run() {
        boolean keepGoing = true;
        int userSelection = 0;
        try {
            modeChoice = getMode();
            service.loadFile();
            while (keepGoing) {

                userSelection = getSelection();

                switch (userSelection) {
                    case 1:
                        displayOrders();
                        break;
                    case 2:
                        addOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        saveWork();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        view.displayUnknownCommandMessage();
                }
            }
        } catch (FlooringMasteryPersistenceException
                | FlooringMasteryInvalidDataException
                | FlooringMasteryNoOrderException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    //gets user menu choice
    private int getSelection() {
        return view.printMenuAndGetSelection();
    }

    //displays all orders of a particular date
    private void displayOrders() throws
            FlooringMasteryPersistenceException,
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException {
        String search = view.displayOrderListBanner();
        List<Order> results = service.displayOrder(search);
        view.displayOrderList(results);
    }

    //adds an order
    public void addOrder() throws
            FlooringMasteryPersistenceException,
            FlooringMasteryInvalidDataException,
            FlooringMasteryNoOrderException {
        boolean hasErrors = false;
        view.displayAddOrderBanner();
        do {
            Order currentOrder = view.getNewOrderInfo();
            try {
                Order checkedOrder = service.checkForValidData(currentOrder);
                Order newOrder = service.calculateCost(checkedOrder);
                service.addOrder(newOrder);
                int changes = view.saveChanges();
                convertModeChoice(changes);
                view.displayAddSuccessBanner();
                hasErrors = false;
            } catch (FlooringMasteryInvalidDataException | NullPointerException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    //removes an order
    private void removeOrder() throws
            FlooringMasteryPersistenceException,
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException {
        view.displayRemoveOrderBanner();
        String date = view.getDate();
        String number = view.getNumber();
        Order orderNumber = new Order(number);
        service.removeOrder(orderNumber, date);
        view.displayRemoveSuccessBaner();
    }

    //allows editing of an order
    private void editOrder() throws
            FlooringMasteryPersistenceException,
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException {
        boolean hasErrors = false;
        view.displayEditOrderBanner();
        do {
            String date = view.getDate();
            String number = view.getNumber();
            Order orderNumber = new Order(number);
            try {
                orderNumber = view.editOrder();
                Order checkedOrder = service.checkForValidData(orderNumber);
                service.editOrder(checkedOrder, date);
                view.displayEditSuccessBanner();
                hasErrors = false;
            } catch (FlooringMasteryInvalidDataException | NullPointerException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    //used to save work in production mode...
    public void saveWork() throws
            FlooringMasteryPersistenceException,
            FlooringMasteryNoOrderException,
            FlooringMasteryInvalidDataException {
        //...and prevents saving if in training mode
        if (modeChoice == false) {
            view.displayNoSaveBanner();
        } else {
            service.writeFile();
            view.displaySaveSuccessfulBanner();
        }
    }

    //used to choose between training mode and production mode
    public boolean getMode() throws
            FlooringMasteryInvalidDataException, 
            FlooringMasteryPersistenceException,
            FlooringMasteryNoOrderException {
        int userModeSelection = view.getMode();
        return convertInitialModeChoice(userModeSelection);
    }

    public boolean convertModeChoice(int userInput) throws
            FlooringMasteryInvalidDataException,
            FlooringMasteryPersistenceException,
            FlooringMasteryNoOrderException {
        boolean saveModeChoice = true;
        userInput = view.saveChanges();
        if (userInput == 1) {
            service.writeFile();
        }
        return saveModeChoice;
    }
    
        public boolean convertInitialModeChoice(int userInput) throws
            FlooringMasteryInvalidDataException {
        boolean modeChoice = true;
        userInput = view.getMode();
        if (userInput == 2) {
            modeChoice = false;
        }
        return modeChoice;
    }
}
