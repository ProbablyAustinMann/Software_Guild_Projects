/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author austinmann
 */
public class VendingMachineDaoTest {
    
    private VendingMachineDao dao = new VendingMachineDaoFileImpl();
    
    public VendingMachineDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of stockMachine method, of class VendingMachineDao.
     */
//    @Test
//    public void testStockMachineAndPromptItem() throws Exception {
//        Item item = new Item("A6");
//        item.setName("Heath");
//        item.setPrice("1.25");
//        item.setNumberInInventory("3");
//        
//        dao.stockMachine(item.getMachineNumber(), item);
//        
//        Item fromDao = dao.promptItem(item.getMachineNumber());
//        
//        assertEquals(item, fromDao);
//    }

    /**
     * Test of menuView method, of class VendingMachineDao.
     */
    @Test
    public void testMenuView() throws Exception {
        Item item1 = new Item("A6");
        item1.setName("Heath");
        item1.setPrice("1.25");
        item1.setNumberInInventory("5");
        dao.stockMachine(item1.getMachineNumber(), item1);

        Item item2 = new Item("A7");
        item2.setName("Juicy Fruit");
        item2.setPrice("0.75");
        item2.setNumberInInventory("2");
        dao.stockMachine(item2.getMachineNumber(), item2);
        
        assertEquals(2, dao.menuView().size());
    }

    
}
