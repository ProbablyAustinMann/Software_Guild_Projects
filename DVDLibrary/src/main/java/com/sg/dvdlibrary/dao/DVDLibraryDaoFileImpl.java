/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
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
/**
 *
 * @author austinmann
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    
    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = " :: ";
    
    @Override
    public DVD addDVD(String title, DVD dvd) 
    throws DVDLibraryPersistenceException {
        DVD newDVD = dvds.put(title, dvd);
        writeLibrary();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs() 
    throws DVDLibraryPersistenceException {
        loadLibrary();
        return new ArrayList<DVD>(dvds.values());
        
    }

    @Override
    public DVD getDVD(String title) 
    throws DVDLibraryPersistenceException {
        loadLibrary();
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) 
    throws DVDLibraryPersistenceException {
        DVD removedDVD = dvds.remove(title);
        writeLibrary();
        return removedDVD;
    }
        
    public List<DVD> searchLibrary(String search)
    throws DVDLibraryPersistenceException {
        loadLibrary();
        ArrayList<DVD> allDVDs = new ArrayList<DVD>(dvds.values());
        ArrayList<DVD> results = new ArrayList<DVD>();
        for (DVD i : allDVDs) {
            if (i.getTitle().toLowerCase().contains(search.toLowerCase())) {
                results.add(i);
            }
        }
        return results;
    }
    
    private Map<String, DVD> dvds = new HashMap<>();
    
    private void loadLibrary() throws DVDLibraryPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
            new BufferedReader(
            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryPersistenceException("-_- Could not load library data into memory", e);
        }
        String currentLine;
        String[] currentTokens;
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            DVD currentDVD = new DVD(currentTokens[0]);
            currentDVD.setReleaseDate(currentTokens[1]);
            currentDVD.setRating(currentTokens[2]);
            currentDVD.setDirectorName(currentTokens[3]);
            currentDVD.setStudio(currentTokens[4]);
            currentDVD.setNotes(currentTokens[5]);
            
            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }
    
    private void writeLibrary() throws DVDLibraryPersistenceException {
        PrintWriter out;
        
        try {
           out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryPersistenceException ("Could not save library data", e);
        }
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            out.println(currentDVD.getTitle() + DELIMITER + currentDVD.getReleaseDate() + 
                    DELIMITER + currentDVD.getRating() + DELIMITER + currentDVD.getDirectorName() + 
                    DELIMITER + currentDVD.getStudio() + DELIMITER + currentDVD.getNotes());
            out.flush();
        }
        out.close();
    }
    
}
