package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.model.Item;
import com.sg.vendingmachinespringmvc.service.VendingMachineServiceLayer;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VendingMachineController {

    BigDecimal total = new BigDecimal("0");
    public static final BigDecimal QUARTER = new BigDecimal(".25");
    public static final BigDecimal DIME = new BigDecimal(".10");
    public static final BigDecimal NICKEL = new BigDecimal(".05");
    public static final String THANK_YOU = "Thank You!";
    public static final String NOT_ENOUGH = "Not Enough Money!";
    public static final String NO_INVENTORY = "No Inventory!";
    public static final String EMPTY_BOX = "";
    public static final String SELECTION = "Please make a selection";

    VendingMachineServiceLayer service;
    
    //reference to the service layer
    @Inject
    public VendingMachineController(VendingMachineServiceLayer service) {
        this.service = service;
    }

    //allows user to input money
    @RequestMapping(value = "/moneyInput", method = RequestMethod.GET)
    public String moneyInput(HttpServletRequest request, Model model) {
        String money = request.getParameter("moneyButton");
        total = total.add(new BigDecimal(money));
        List<Item> itemList = service.getItems();
        model.addAttribute("total", total);
        model.addAttribute("itemList", itemList);
        return "items";
    }

    //displays buttons
    @RequestMapping(value = {"/createButtons", "/"}, method = RequestMethod.GET)
    public String createItemList(HttpServletRequest request, Model model) {
        List<Item> itemList = service.getItems();
        model.addAttribute("itemList", itemList);
        return "items";
    }

    //adds item number to the item choice box
    @RequestMapping(value = "/chooseItem", method = RequestMethod.GET)
    public String chooseItem(HttpServletRequest request, Model model) {
        try {
            String input = request.getParameter("itemButton");
            int inputInt = parseInt(input);
            List<Item> itemList = service.getItems();
            model.addAttribute("itemList", itemList);
            model.addAttribute("inputInt", inputInt);
        } catch (NumberFormatException e) {
            model.addAttribute("message", SELECTION);
            List<Item> itemList = service.getItems();
            model.addAttribute("itemList", itemList);
        }
        return "items";
    }

    //allows user to manualy return change
    @RequestMapping(value = "/giveChange", method = RequestMethod.GET)
    public String giveChange(HttpServletRequest request, Model model) {
        List<Item> itemList = service.getItems();

        BigDecimal remainingQuarter[] = total.divideAndRemainder(QUARTER);
        String quarterString = remainingQuarter[0].toString();
        BigDecimal remainingDime[] = remainingQuarter[1].divideAndRemainder(DIME);
        String dimeString = remainingDime[0].toString();
        BigDecimal remainingNickel[] = remainingDime[1].divideAndRemainder(NICKEL);
        String nickelString = remainingNickel[0].toString();
        model.addAttribute("quarterString", quarterString);
        model.addAttribute("dimeString", dimeString);
        model.addAttribute("nickelString", nickelString);
        model.addAttribute("itemList", itemList);
        total = new BigDecimal("0");

        return "items";
    }

    //vends item and returns change
    @RequestMapping(value = "/vendItem", method = RequestMethod.GET)
    public String vendItem(HttpServletRequest request, Model model) {
        try {
            String input = request.getParameter("itemBox");
            int inputInt = parseInt(input);
            List<Item> itemList = service.getItems();
            Item item = service.getId(inputInt);
            BigDecimal itemPrice = item.getPrice();
            int itemStock = item.getNumberInInventory();

            //if there is no item in stock, displays 'no inventory' message
            if (itemStock < 1) {
                model.addAttribute("message", NO_INVENTORY);
                
            //if the user's money is greater than the price, the item is vended and change is returned...
            } else if (itemPrice.compareTo(total) <= 0) {
                model.addAttribute("message", THANK_YOU);
                total = (total.subtract(item.getPrice()));
                BigDecimal remainingQuarter[] = total.divideAndRemainder(QUARTER);
                String quarterString = remainingQuarter[0].toString();
                BigDecimal remainingDime[] = remainingQuarter[1].divideAndRemainder(DIME);
                String dimeString = remainingDime[0].toString();
                BigDecimal remainingNickel[] = remainingDime[1].divideAndRemainder(NICKEL);
                String nickelString = remainingNickel[0].toString();
                total = new BigDecimal("0");
                model.addAttribute("quarterString", quarterString);
                model.addAttribute("dimeString", dimeString);
                model.addAttribute("nickelString", nickelString);
                model.addAttribute("moneyBox", EMPTY_BOX);
                itemStock--;
                item.setNumberInInventory(itemStock);
            //...or if the user doesn't have enough money, the 'not enough money' message is displayed
            } else {
                model.addAttribute("message", NOT_ENOUGH);
            }

            model.addAttribute("itemList", itemList);
        } catch (NumberFormatException e) {
            model.addAttribute("message", SELECTION);
            List<Item> itemList = service.getItems();
            model.addAttribute("itemList", itemList);
        }

        return "items";
    }

}
