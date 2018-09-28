/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryAuditDao;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author austinmann
 */
public class DVDLibraryServiceLayerImpl implements DVDLibraryServiceLayer {
    
    private DVDLibraryDao dao;
    private DVDLibraryAuditDao auditDao;
    
    public DVDLibraryServiceLayerImpl(DVDLibraryDao dao, DVDLibraryAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void addDVD(DVD dvd) throws 
            DVDLibraryPersistenceException, 
            DVDLibraryDuplicateTitleException, 
            DVDLibraryDataValidationException {
        if (dao.getDVD(dvd.getTitle()) != null) {
            throw new DVDLibraryDuplicateTitleException("Error: Could not create DVD. Title " + dvd.getTitle() 
                                                        +  " already exists.");
        }
        validateData(dvd);
        
        dao.addDVD(dvd.getTitle(), dvd);
        
        //auditDao.writeAuditEntry("DVD " + dvd.getTitle() + " Created");
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryPersistenceException {
        return dao.getAllDVDs();
    }
 
    @Override
    public DVD getDVD(String title) throws DVDLibraryPersistenceException {
        return dao.getDVD(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryPersistenceException {
        DVD removedDVD = dao.removeDVD(title);
       // auditDao.writeAuditEntry("Student " + title + " Removed");
        return removedDVD;
    }

    @Override
    public List<DVD> searchLibrary(String search) throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void validateData(DVD dvd) throws DVDLibraryDataValidationException {
        if (dvd.getReleaseDate() == null || dvd.getReleaseDate().trim().length() == 0 || 
                dvd.getRating() == null || dvd.getRating().trim().length() == 0 ||
                dvd.getDirectorName() == null || dvd.getDirectorName().trim().length() == 0 || 
                dvd.getStudio() == null || dvd.getStudio().trim().length() == 0 || 
                dvd.getNotes() == null || dvd.getNotes().trim().length() == 0) {
            throw new DVDLibraryDataValidationException("Error: All Fields Are Required");
        }
    }
    
}
