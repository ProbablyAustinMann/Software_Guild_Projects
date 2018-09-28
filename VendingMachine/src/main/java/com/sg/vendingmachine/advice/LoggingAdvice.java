/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.advice;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import org.aspectj.lang.JoinPoint;
import com.sg.vendingmachine.dto.Item;
/**
 *
 * @author austinmann
 */
public class LoggingAdvice {
    
    VendingMachineAuditDao auditDao;
    
    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }
 
    public void createAuditEntry(JoinPoint jp, Throwable e) {
        Object[] args = jp.getArgs();
        String auditEntry = e.getClass().getName().toString();
        
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachinePersistenceException ex) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
   }
}
    

