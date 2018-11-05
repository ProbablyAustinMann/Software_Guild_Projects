/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

import java.math.BigDecimal;
import java.util.Objects;
import lombok.Data;

/**
 *
 * @author austinmann
 */
@Data
public class Order {
    
    private State state;
    private Product product;
    private String date;
    private String orderNumber;
    private String customerName;
    private double Area;
    private BigDecimal tax;
    private BigDecimal total;
    private BigDecimal totalMaterialCost;
    private BigDecimal totalLaborCost;
    private BigDecimal totalTaxes;

}
