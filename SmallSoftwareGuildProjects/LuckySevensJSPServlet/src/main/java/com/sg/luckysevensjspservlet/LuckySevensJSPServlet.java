/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensjspservlet;

import java.io.IOException;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author austinmann
 */
@WebServlet(name = "LuckySevensJSPServlet", urlPatterns = {"/LuckySevensJSPServlet"})
public class LuckySevensJSPServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

        request.setAttribute("input", input);
        request.setAttribute("rollMax", rollMax);
        request.setAttribute("rollCounter", rollCounter);
        request.setAttribute("max", max);
        // Get the Request Dispatcher for result.jsp and forward the 
        // request to result.jsp
        RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
        rd.forward(request, response);
    }

    static int roll() {
        Random dieRoller = new Random();
        int die1 = dieRoller.nextInt(6) + 1;
        int die2 = dieRoller.nextInt(6) + 1;
        return die1 + die2;

    }




    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
