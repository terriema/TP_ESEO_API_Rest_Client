package com.example.tp_eseo_api_rest_client.servlet;

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
        AccueilDao accueilDao = new AccueilDao();

        try {
            String villesJSON = accueilDao.getAllVilles().body();
            JSONArray jsonArray = new JSONArray(villesJSON);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String json = jsonObject.toString();

            // ObjectMapper instantiation
            ObjectMapper objectMapper = new ObjectMapper();

            Ville ville = objectMapper.readValue(json, Ville.class);

            List<Ville> villeList = objectMapper.readValue(villesJSON, new TypeReference<List<Ville>>(){});

            for(Ville v : villeList){
                System.out.println(v.getNomCommune());
            }
            request.setAttribute("villes", villeList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }

    public void destroy() {
    }
}