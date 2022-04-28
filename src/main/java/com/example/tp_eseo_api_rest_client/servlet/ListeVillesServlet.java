package com.example.tp_eseo_api_rest_client.servlet;

import com.example.tp_eseo_api_rest_client.controller.VilleController;
import com.example.tp_eseo_api_rest_client.model.Ville;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListeVillesServlet", value = "/listeVilles")
public class ListeVillesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VilleController villeController = new VilleController();

        List<Ville> listVilles = villeController.getAllVilles();

        request.setAttribute("listVilles", listVilles);

        this.getServletContext().getRequestDispatcher("/WEB-INF/listeVilles.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VilleController villeController = new VilleController();

        Ville ville = new Ville();
        ville.setCodeINSEE(request.getParameter("codeINSEE"));
        ville.setNomCommune(request.getParameter("nomCommune"));
        ville.setCodePostal(request.getParameter("codePostal"));
        ville.setLibelleAcheminement(request.getParameter("libelleAcheminement"));
        ville.setLigne5(request.getParameter("ligne5"));
        ville.setLatitude(request.getParameter("latitude"));
        ville.setLongitude(request.getParameter("longitude"));

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(ville);
        villeController.updateVille(ville.getCodeINSEE(), json);

        List<Ville> listVilles = villeController.getAllVilles();
        request.setAttribute("listVilles", listVilles);

        this.getServletContext().getRequestDispatcher("/WEB-INF/listeVilles.jsp").forward(request, response);
    }
}
