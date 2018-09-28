/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author austinmann
 */
public class FlooringMasteryProductDaoFileImpl implements FlooringMasteryProductDao {
    
    private List<Product> products = new ArrayList<>();
    
    public static final String PRODUCT_FILE = "Products.txt";
    public static final String DELIMITER = ",";

    //gets all product information from the provided text file
    @Override
    public void loadProducts() throws FlooringMasteryPersistenceException {
                Scanner scanner;
        
        try {
            scanner = new Scanner(
            new BufferedReader(
            new FileReader(PRODUCT_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException("-_- Could not load data into memory", e);
        }
        String firstLine;
        String currentLine;
        
        String[] currentTokens;
        
        if (scanner.nextLine() != null) {
            firstLine = scanner.nextLine();
        }
        
        while (scanner.hasNextLine()) {
            
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Product currentProduct = new Product(currentTokens[0]);
            currentProduct.setMaterialCost(new BigDecimal(currentTokens[1]));
            currentProduct.setLaborCost(new BigDecimal(currentTokens[2]));

            products.add(currentProduct);
        }
        scanner.close();
    }

    //gets labor cost from the text file
    @Override
    public BigDecimal laborCost(String nameOfProduct) throws 
            FlooringMasteryPersistenceException {
        loadProducts();
        BigDecimal labor = null;
       for (Product p : products) {
           if (nameOfProduct.equals(p.getMaterialName())) {
               labor = p.getLaborCost();
           }
       }
       return labor;
    }

    //gets material cost from the text file
    @Override
    public BigDecimal materialCost(String nameOfProduct) throws 
            FlooringMasteryPersistenceException {
        loadProducts();
        BigDecimal material = null;
       for (Product p : products) {
           if (nameOfProduct.equals(p.getMaterialName())) {
               material = p.getLaborCost();
           }
       }
       return material;
    }
    
    
}
    

