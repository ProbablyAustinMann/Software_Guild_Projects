/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.State;
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
public class FlooringMasteryStateDaoFileImpl implements FlooringMasteryStateDao {
    
    private FlooringMasteryOrderDao orderDao;
    
    private List<State> states = new ArrayList();
    
    public static final String STATE_FILE = "Taxes.txt";
    public static final String DELIMITER = ",";

    //loads state file
    @Override       
    public void loadStates() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
            new BufferedReader(
            new FileReader(STATE_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException("-_- Could not load data into memory", e);
        }
        String firstLine;
        String currentLine;
        
        String[] currentTokens;
        
//        if (scanner.nextLine() != null) {
        firstLine = scanner.nextLine();
//        }
        
        while (scanner.hasNextLine()) {
            
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            State currentState = new State(currentTokens[0]);
            currentState.setTaxRate(new BigDecimal(currentTokens[1]));

            states.add(currentState);
        }
        scanner.close();
    }

    //used to get tax information from the proveded text file
    @Override
    public BigDecimal getTax(String nameOfState) throws 
        FlooringMasteryPersistenceException {
        loadStates();
        BigDecimal tax = null;
       for (State s : states) {
           if (nameOfState.equals(s.getStateName())) {
               tax = s.getTaxRate();
           }
       }
       return tax;
    }
    
}    
    

