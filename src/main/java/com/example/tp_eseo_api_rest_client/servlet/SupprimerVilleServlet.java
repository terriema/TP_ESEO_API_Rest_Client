package com.example.tp_eseo_api_rest_client.servlet;

import com.example.tp_eseo_api_rest_client.controller.VilleController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SupprimerVilleServlet", value = "/supprimer")
public class SupprimerVilleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VilleController villeController = new VilleController();

        String codeINSEE = request.getParameter("ville");

        villeController.deleteVilleByCodeINSEE(codeINSEE);

        response.sendRedirect("listeVilles");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
