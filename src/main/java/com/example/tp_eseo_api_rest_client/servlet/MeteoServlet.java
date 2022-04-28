package com.example.tp_eseo_api_rest_client.servlet;

import com.example.tp_eseo_api_rest_client.controller.VilleController;
import com.example.tp_eseo_api_rest_client.model.Ville;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MeteoServlet", value = "/meteoVille")
public class MeteoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VilleController villeController = new VilleController();

        List<Ville> listVilles = villeController.getAllVilles();

        request.setAttribute("listVilles", listVilles);

        this.getServletContext().getRequestDispatcher("/WEB-INF/meteoVille.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VilleController villeController = new VilleController();

        Ville ville = villeController.getVilleByCodeINSEE(request.getParameter("codeINSEEVille"));

        String weather = villeController.getWeather(ville.getLatitude(), ville.getLongitude());

        List<Ville>  listVilles = villeController.getAllVilles();

        request.setAttribute("listVilles", listVilles);
        request.setAttribute("weather", weather);

        this.getServletContext().getRequestDispatcher("/WEB-INF/meteoVille.jsp").forward(request, response);
    }
}
