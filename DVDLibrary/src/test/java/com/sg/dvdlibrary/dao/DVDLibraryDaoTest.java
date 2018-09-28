/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author austinmann
 */
public class DVDLibraryDaoTest {
    
    private DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
    
    public DVDLibraryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<DVD>dvdList = dao.getAllDVDs();
        for (DVD dvd : dvdList) {
            dao.removeDVD(dvd.getTitle());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testAddGetDVD() throws Exception {
        DVD dvd = new DVD("Sample");
        dvd.setReleaseDate("Sample");
        dvd.setRating("Sample");
        dvd.setDirectorName("Sample");
        dvd.setStudio("Sample");
        dvd.setNotes("Sample");
        
        dao.addDVD(dvd.getTitle(), dvd);
        
        DVD fromDao = dao.getDVD(dvd.getTitle());
        
        assertEquals(dvd, fromDao);
    }

    /**
     * Test of getAllDVDs method, of class DVDLibraryDao.
     */
    @Test
    public void testGetAllDVDs() throws Exception {
        DVD dvd1 = new DVD("Sample1");
        dvd1.setReleaseDate("Sample1");
        dvd1.setRating("Sample1");
        dvd1.setDirectorName("Sample1");
        dvd1.setStudio("Sample1");
        dvd1.setNotes("Sample1");
        
        dao.addDVD(dvd1.getTitle(), dvd1);
        
        DVD dvd2 = new DVD("Sample2");
        dvd2.setReleaseDate("Sample2");
        dvd2.setRating("Sample2");
        dvd2.setDirectorName("Sample2");
        dvd2.setStudio("Sample2");
        dvd2.setNotes("Sample2");
        
        dao.addDVD(dvd2.getTitle(), dvd2);
        
        assertEquals(2, dao.getAllDVDs().size());
    }

    /**
     * Test of removeDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testRemoveDVD() throws Exception {
        DVD dvd1 = new DVD("Sample1");
        dvd1.setReleaseDate("Sample1");
        dvd1.setRating("Sample1");
        dvd1.setDirectorName("Sample1");
        dvd1.setStudio("Sample1");
        dvd1.setNotes("Sample1");
        
        dao.addDVD(dvd1.getTitle(), dvd1);
        
        DVD dvd2 = new DVD("Sample2");
        dvd2.setReleaseDate("Sample2");
        dvd2.setRating("Sample2");
        dvd2.setDirectorName("Sample2");
        dvd2.setStudio("Sample2");
        dvd2.setNotes("Sample2");
        
        dao.addDVD(dvd2.getTitle(), dvd2);
        
        dao.removeDVD(dvd1.getTitle());       
        assertEquals(1, dao.getAllDVDs().size());
        assertNull(dao.getDVD(dvd1.getTitle()));
        
        dao.removeDVD(dvd2.getTitle());
        assertEquals(0, dao.getAllDVDs().size());
        assertNull(dao.getDVD(dvd2.getTitle()));
    }


}
