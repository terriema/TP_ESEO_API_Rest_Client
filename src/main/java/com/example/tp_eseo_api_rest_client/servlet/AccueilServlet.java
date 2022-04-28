package com.example.tp_eseo_api_rest_client.servlet;

import com.example.tp_eseo_api_rest_client.controller.VilleController;
import com.example.tp_eseo_api_rest_client.model.Ville;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AccueilServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        VilleController villeController = new VilleController();

        List<Ville> listVilles = villeController.getAllVilles();

        request.setAttribute("listVilles", listVilles);

        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        VilleController villeController = new VilleController();

        String codeINSEEVille1 = request.getParameter("codeINSEEVille1");
        String codeINSEEVille2 = request.getParameter("codeINSEEVille2");

        Ville ville1 = villeController.getVilleByCodeINSEE(codeINSEEVille1);
        Ville ville2 = villeController.getVilleByCodeINSEE(codeINSEEVille2);

        String distance = villeController.getDistance(Float.parseFloat(ville1.getLatitude()), Float.parseFloat(ville1.getLongitude()), Float.parseFloat(ville2.getLatitude()), Float.parseFloat(ville2.getLongitude())) + "";
        request.setAttribute("distance", distance);

        List<Ville> listVilles = villeController.getAllVilles();
        request.setAttribute("listVilles", listVilles);

        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }


}