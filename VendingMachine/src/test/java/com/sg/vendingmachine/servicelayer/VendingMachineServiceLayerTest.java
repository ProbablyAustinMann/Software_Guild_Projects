/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.servicelayer;

import com.sg.vendingmachine.dto.Item;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author austinmann
 */
public class VendingMachineServiceLayerTest {
    
    private VendingMachineServiceLayer service;
    
    public VendingMachineServiceLayerTest() {
        //VendingMachineDao dao = new VendingMachineDaoStubImpl();
        //VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
        
       //service = new VendingMachineServiceLayerImpl(dao, auditDao);
           ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    service = 
        ctx.getBean("serviceLayer", VendingMachineServiceLayer.class);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of stockMachine method, of class VendingMachineServiceLayer.
     */
   /* @Test
    public void testStockMachine() throws Exception {
        Item item = new Item("A9");
        item.setName("Sprite");
        item.setPrice("1.40");
        item.setNumberInInventory("5");
        dao.stockMachine(Item, item);
    }
*/
    /**
     * Test of menuView method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testMenuView() throws Exception {
    }

    /**
     * Test of promptItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testPromptItem() throws Exception {
    }

}
