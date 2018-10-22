/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author austinmann
 */
public class VendingMachineServiceLayerFileImpl implements VendingMachineServiceLayer {
    
    VendingMachineDao dao;

    @Inject
    public VendingMachineServiceLayerFileImpl(VendingMachineDao dao) {
        this.dao = dao;
        
    }

    @Override
    public List<Item> getItems() {
        return dao.getItems();
    }

    @Override
    public Item getId(int input) {
        return dao.getId(input);
    }
    
    
    
}
