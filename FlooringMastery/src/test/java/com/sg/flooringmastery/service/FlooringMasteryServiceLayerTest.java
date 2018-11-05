/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryOrderDao;
import com.sg.flooringmastery.dao.FlooringMasteryOrderDaoFileImpl;
import com.sg.flooringmastery.dao.FlooringMasteryProductDao;
import com.sg.flooringmastery.dao.FlooringMasteryProductDaoFileImpl;
import com.sg.flooringmastery.dao.FlooringMasteryStateDao;
import com.sg.flooringmastery.dao.FlooringMasteryStateDaoFileImpl;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.State;
import com.sg.flooringmastery.ui.FlooringMasteryView;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author austinmann
 */
public class FlooringMasteryServiceLayerTest {
    
    private FlooringMasteryServiceLayer service;

    
    public FlooringMasteryServiceLayerTest() {
        FlooringMasteryOrderDao orderDao = new FlooringMasteryOrderDaoFileImpl();
        FlooringMasteryStateDao stateDao = new FlooringMasteryStateDaoFileImpl();
        FlooringMasteryProductDao productDao = new FlooringMasteryProductDaoFileImpl();
        service = new FlooringMasteryServiceLayerImpl(orderDao, stateDao, productDao);
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
     * Test of displayOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testDisplayOrder() throws Exception {
    }

    /**
     * Test of addOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testAddOrder() throws Exception {
        Order order = new Order();
        order.setOrderNumber("000001");
        State state = new State("PA");
        Product product = new Product("Wood");
        order.setState(state);
        order.setProduct(product);
        order.setDate("1/1/1111");
        order.setCustomerName("Tom");
        order.setArea(111);
        service.addOrder(order);
    }
    
//    @Test
//    public void testInvalidDataException() throws Exception {
//        Order order = new Order();
//        order.setOrderNumber("one");
//        State state = new State("");
//        Product product = new Product("Wood");
//        order.setState(state);
//        order.setProduct(product);
//        order.setDate("1/1/1111");
//        order.setCustomerName("Tom");
//        order.setArea(111);
//        
//        try {
//            service.addOrder(order);
//            fail("Expected exception was not thrown");
//        } catch (FlooringMasteryInvalidDataException e) {
//            return;
//        }
//    }

    /**
     * Test of editOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testEditOrder() throws Exception {
    }

    /**
     * Test of removeOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testRemoveOrder() throws Exception {
    }

    /**
     * Test of checkForValidData method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testCheckForValidData() throws Exception {
    }

    /**
     * Test of writeFile method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testWriteFile() throws Exception {
    }

    /**
     * Test of convertModeChoice method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testConvertModeChoice() throws Exception {
    }

    /**
     * Test of calculateCost method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testCalculateCost() throws Exception {
    }

}
