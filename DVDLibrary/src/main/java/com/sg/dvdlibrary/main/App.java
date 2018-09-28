/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.main;

import com.sg.dvdlibrary.controller.DVDLibraryController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author austinmann
 */
public class App {
    
    public static void main(String[] args) {
        
        /*
        UserIO myIO = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIO);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        controller.run();
        */
        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        DVDLibraryController controller = 
           ctx.getBean("controller", DVDLibraryController.class);
        controller.run();
    }
    
}
