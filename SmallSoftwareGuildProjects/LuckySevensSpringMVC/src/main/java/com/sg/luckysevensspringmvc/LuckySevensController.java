/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensspringmvc;

import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author austinmann
 */
@Controller
public class LuckySevensController {
    @RequestMapping(value = "/loseMoney",
        method = RequestMethod.POST)
    public String loseMoney(HttpServletRequest request, 
            Map<String, Object> model) {
                String input = request.getParameter("moneyInput");
        int dollars = Integer.parseInt(input);
        int rollCounter = 0;
        int max = dollars;
        int rollMax = 0;

        while (dollars > 0) {
            roll();
            rollCounter++;

            if (roll() == 7) {
                dollars = dollars + 4;
            } else {
                dollars = dollars - 1;
            }
            if (dollars > max) {
                max = dollars;
                rollMax = rollCounter;
            }

        }

        model.put("input", input);
        model.put("rollMax", rollMax);
        model.put("rollCounter", rollCounter);
        model.put("max", max);
        // Get the Request Dispatcher for result.jsp and forward the 
        // request to result.jsp
        return "result";
    }

    static int roll() {
        Random dieRoller = new Random();
        int die1 = dieRoller.nextInt(6) + 1;
        int die2 = dieRoller.nextInt(6) + 1;
        return die1 + die2;

    }
 }

