/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.State;
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
public class FlooringMasteryOrderDaoTest {
    
    private FlooringMasteryOrderDao orderDao = new FlooringMasteryOrderDaoFileImpl();
    private FlooringMasteryStateDao stateDao = new FlooringMasteryStateDaoFileImpl();
    private FlooringMasteryProductDao productDao = new FlooringMasteryProductDaoFileImpl();
    
    public FlooringMasteryOrderDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List <Order> orderList = orderDao.displayAllOrders();
        for (Order order : orderList) {
            orderDao.removeOrder(order, order.getOrderNumber());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of displayOrder method, of class FlooringMasteryOrderDao.
     */
    @Test
    public void testDisplayOrder() throws Exception {
    }

    /**
     * Test of addOrder method, of class FlooringMasteryOrderDao.
     */
    @Test
    public void testAddOrder() throws Exception {
        Order order = new Order();
        order.setOrderNumber("000001");
        State state = new State("OH");
        Product product = new Product("Tile");
        order.setState(state);
        order.setProduct(product);
        order.setDate("1/1/1111");
        order.setCustomerName("Jim");
        order.setArea(111);
        
        orderDao.addOrder(order.getOrderNumber(), order);
        
        
    }

    /**
     * Test of editOrder method, of class FlooringMasteryOrderDao.
     */
    @Test
    public void testEditOrder() throws Exception {
    }

    /**
     * Test of removeOrder method, of class FlooringMasteryOrderDao.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        
        Order order1 = new Order();
        order1.setOrderNumber("000001");
        State state1 = new State("OH");
        Product product1 = new Product("Tile");
        order1.setState(state1);
        order1.setProduct(product1);
        order1.setDate("1/1/1111");
        order1.setCustomerName("Jim");
        order1.setArea(111);
        
        orderDao.addOrder(order1.getOrderNumber(), order1);
   
        Order order2 = new Order();
        order2.setOrderNumber("000002");
        State state2 = new State("PA");
        Product product2 = new Product("Wood");
        order2.setState(state2);
        order2.setProduct(product2);
        order2.setDate("1/1/1111");
        order2.setCustomerName("Tom");
        order2.setArea(111);
        
        orderDao.addOrder(order2.getOrderNumber(), order2);
        
        orderDao.removeOrder(order1, order1.getDate());
        
        assertEquals(1, orderDao.displayAllOrders().size());
        
        //assertNull(orderDao.displayOrder(order1.getOrderNumber()));
    }

    /**
     * Test of displayAllOrders method, of class FlooringMasteryOrderDao.
     */
    @Test
    public void testDisplayAllOrders() throws Exception {
        Order order1 = new Order();
        order1.setOrderNumber("000001");
        State state1 = new State("OH");
        Product product1 = new Product("Tile");
        order1.setState(state1);
        order1.setProduct(product1);
        order1.setDate("1/1/1111");
        order1.setCustomerName("Jim");
        order1.setArea(111);
        
        orderDao.addOrder(order1.getOrderNumber(), order1);
   
        Order order2 = new Order();
        order2.setOrderNumber("000002");
        State state2 = new State("PA");
        Product product2 = new Product("Wood");
        order2.setState(state2);
        order2.setProduct(product2);
        order2.setDate("1/1/1111");
        order2.setCustomerName("Tom");
        order2.setArea(111);
        
        orderDao.addOrder(order2.getOrderNumber(), order2);
        
        assertEquals(2, orderDao.displayAllOrders().size());
    }

    
}
