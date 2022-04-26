package com.example.tp_eseo_api_rest_client.servlet;

import com.example.tp_eseo_api_rest_client.controller.AccueilController;
import com.example.tp_eseo_api_rest_client.dao.AccueilDao;
import com.example.tp_eseo_api_rest_client.model.Ville;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccueilServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccueilController accueilController = new AccueilController();

        List<Ville> listVilles = accueilController.getAllVilles();

        request.setAttribute("listVilles", listVilles);

        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccueilController accueilController = new AccueilController();

        String codePostalVille1 = request.getParameter("codePostalVille1");
        String codePostalVille2 = request.getParameter("codePostalVille2");

        System.out.println("codePostalVille1 : " + codePostalVille1);

        Ville ville1 = accueilController.getVilleByCodePostal(codePostalVille1);
        Ville ville2 = accueilController.getVilleByCodePostal(codePostalVille2);

        String distance = accueilController.getDistance(Float.parseFloat(ville1.getLatitude()), Float.parseFloat(ville1.getLongitude()), Float.parseFloat(ville2.getLatitude()), Float.parseFloat(ville2.getLongitude())) + "";
        request.setAttribute("distance", distance);

        List<Ville> listVilles = accueilController.getAllVilles();
        request.setAttribute("listVilles", listVilles);

        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }


}