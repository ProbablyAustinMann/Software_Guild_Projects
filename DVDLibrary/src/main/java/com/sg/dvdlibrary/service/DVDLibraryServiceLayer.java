/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author austinmann
 */
public interface DVDLibraryServiceLayer {
    
    public void addDVD(DVD dvd) throws 
            DVDLibraryPersistenceException,
            DVDLibraryDuplicateTitleException,
            DVDLibraryDataValidationException;
    
    public List<DVD> getAllDVDs() throws 
            DVDLibraryPersistenceException;
        
    public DVD getDVD(String title) throws
            DVDLibraryPersistenceException;
    
    public DVD removeDVD(String title) throws 
            DVDLibraryPersistenceException;
    
    public List<DVD> searchLibrary(String search) throws
            DVDLibraryPersistenceException;
}
