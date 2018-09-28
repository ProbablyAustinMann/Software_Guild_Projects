/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.service.DVDLibraryDataValidationException;
import com.sg.dvdlibrary.service.DVDLibraryDuplicateTitleException;
import com.sg.dvdlibrary.service.DVDLibraryServiceLayer;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author austinmann
 */
public class DVDLibraryController {
    
    private DVDLibraryView view;
    private DVDLibraryServiceLayer service;
    
    public DVDLibraryController(DVDLibraryServiceLayer service, DVDLibraryView view) {
        this.service = service;
        this.view = view;
    }
    
    //allows user to use the UserIO
    private UserIO io = new UserIOConsoleImpl();
    
    //the main method that runs in the App class
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
        //as long as keepGoing is true, the loop continues
        while(keepGoing) {
            
            //gets a selection from the user
            menuSelection = getMenuSelection();
            
            //all the menu selections for controlling the application
            switch (menuSelection) {
                case 1:
                    listDVDs();
                    break;
                case 2:
                    createDVD();
                    break;
                case 3:
                    viewDVD();
                    break;
                case 4:
                    editDVD();
                    break;
                case 5:
                    searchLibrary();
                    break;
                case 6:
                    removeDVD();
                    break;
                //selecting 7 sets keepGoing to false, exiting the loop...
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }  
        }
        //...and displaying the exit message
        exitMessage();
    } catch (DVDLibraryPersistenceException e) {
        view.displayErrorMessage(e.getMessage());
    }
  }
    //the getter for the user menu selection
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    //method for creating a new DVD object
    private void createDVD() throws DVDLibraryPersistenceException {
        view.displayCreateDVDBanner();
        boolean hasErrors = false;
        do {
            DVD newDVD = view.getNewDVDInfo();
            try {
                service.addDVD(newDVD);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (DVDLibraryDuplicateTitleException | DVDLibraryDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);

    }
    
    //method for listing all DVD objects currently in the hashmap
    private void listDVDs() throws DVDLibraryPersistenceException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = service.getAllDVDs();
        view.displayDVDList(dvdList);
    }
    
    //displays a single DVD object based on user input
    private void viewDVD() throws DVDLibraryPersistenceException {
        view.displayDisplayDVDBanner();
        String title = view.getTitleChoice();
        DVD dvd = service.getDVD(title);
        view.displayDVD(dvd);
    }
    
    //permanently removes a DVD object from the hashmap
    public void removeDVD() throws DVDLibraryPersistenceException {
        view.displayRemoveDVDBanner();
        String title = view.getTitleChoice();
        service.removeDVD(title);
        view.displayRemoveSuccessBanner();
    }
    
    //displayed when user enters something other than 1-7 on the main menu
    public void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    //message displayed when a user exits the application
    public void exitMessage() {
        view.displayExitBanner();
    }

    
    //allows user to edit a DVD object
    private void editDVD() throws DVDLibraryPersistenceException {
        view.displayEditBanner();
        String title = view.getTitleChoice();
        service.removeDVD(title);
        boolean hasErrors = false;
        do {
            DVD newDVD = view.getNewDVDInfo();
            try {
                service.addDVD(newDVD);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (DVDLibraryDuplicateTitleException | DVDLibraryDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
        view.displayEditSuccessBanner();       
    }
    
    //allows user to serch for a particular DVD object
    private void searchLibrary() throws DVDLibraryPersistenceException {
        view.displaySearchBanner();
        String search = view.getSearch();
        List<DVD> results = service.searchLibrary(search);
        view.displayDVDList(results);
        
        
    }
}
