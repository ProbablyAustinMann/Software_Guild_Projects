/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author austinmann
 */
public class DVDLibraryView {
    
    private UserIO io;
    
        public int printMenuAndGetSelection() {
            io.print("Main Menu");
            io.print("1. List Current DVD Collection");
            io.print("2. Add New DVD");
            io.print("3. View DVD Info");
            io.print("4. Edit DVD Info");
            io.print("5. Search DVD By Title");
            io.print("6. Remove DVD");
            io.print("7. Exit");
            
            return io.readInt("Please select from the above choices.", 1, 7);
        }
        
        public DVD getNewDVDInfo() {
            String title = io.readString("Please enter DVD title");
            String releaseDate = io.readString("Please enter movie release date");
            String rating = io.readString("Please enter MMPA rating");
            String directorName = io.readString("Please enter director");
            String studio = io.readString("Please enter producing studio");
            String notes = io.readString("Please enter any additional notes or comments");
            DVD currentDVD = new DVD(title);
            currentDVD.setReleaseDate(releaseDate);
            //LocalDate rd  = LocalDate.now();
            //rd = LocalDate.parse(releaseDate);
            //rd = LocalDate.parse(releaseDate, (DateTimeFormatter.ofPattern("MM/dd/yyyy")));
            currentDVD.setRating(rating);
            currentDVD.setDirectorName(directorName);
            currentDVD.setStudio(studio);
            currentDVD.setNotes(notes);
            return currentDVD;
        }
        
        public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
        }
        
        public void displayCreateSuccessBanner() {
            io.readString("DVD successfully created. Please hit enter to continue.");
        }
        
        public void displayDVDList(List<DVD> dvdList) {
            for (DVD currentDVD : dvdList) {
                io.print(currentDVD.getTitle() + " | " + currentDVD.getReleaseDate() + " | " 
                + currentDVD.getRating() + " | " + currentDVD.getDirectorName() + " | " 
                + currentDVD.getStudio() + " | " + currentDVD.getNotes());
            }
            io.readString("Please hit enter to continue");
        }
        
        public void displayDisplayAllBanner() {
            io.print("=== Display All DVDs ===");
        }
        
        public void displayDisplayDVDBanner() {
            io.print("=== Display DVD ===");
        }
        
        public String getTitleChoice() {
            return io.readString("Please enter DVD title");
        }
        
        public void displayDVD(DVD dvd) {
            if (dvd != null) {
                io.print(dvd.getTitle());
                io.print(dvd.getReleaseDate());
                io.print(dvd.getRating());
                io.print(dvd.getDirectorName());
                io.print(dvd.getStudio());
                io.print(dvd.getNotes());
            } else {
                io.print("DVD not found");
            }
            io.readString("Please hit enter to continue");
        }
        
        public void displayRemoveDVDBanner() {
            io.print("=== Remove DVD ===");
        }
        
        public void displayRemoveSuccessBanner() {
            io.readString("DVD successfully removed. Please hit enter to continue.");
        }
        
        public void displayExitBanner() {
            io.print("Good Bye!");
        }
        
        public void displayUnknownCommandBanner() {
            io.print("Unknown Command!");
        }
        
        public DVDLibraryView(UserIO io) {
            this.io = io;
        }
        
        public void displayErrorMessage(String errorMsg) {
            io.print("=== ERROR ===");
            io.print(errorMsg);
        }
        
        public void displayEditBanner() {
            io.print("=== Edit DVD ===");
        }
        
        public void displayEditSuccessBanner() {
            io.readString("Edit successful. Please hit enter to continue.");
        }
        
        public String getSearch() {
            String search = io.readString("Type search field here");
            return search;
        }
        
        public void displaySearchBanner() {
            io.print("=== Search DVD Library ===");
        }
        
}
