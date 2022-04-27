package com.example.tp_eseo_api_rest_client.controller;

import com.example.tp_eseo_api_rest_client.dao.AccueilDao;
import com.example.tp_eseo_api_rest_client.model.Ville;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class VilleController {

    private AccueilDao accueilDao = new AccueilDao();

    public List<Ville> getAllVilles() {
        try {
            String villesJSON = accueilDao.getAllVilles().body();
            JSONArray jsonArray = new JSONArray(villesJSON);

            ObjectMapper objectMapper = new ObjectMapper();

            List<Ville> listVilles = objectMapper.readValue(villesJSON, new TypeReference<List<Ville>>(){});

            return listVilles;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Ville getVilleByCodePostal(String codePostal) {
        try {
            String villeJSON = accueilDao.getVilleByCodePostal(codePostal).body();
            System.out.println(villeJSON);
            System.out.println(codePostal);
            JSONArray jsonArray = new JSONArray(villeJSON);
            System.out.println(jsonArray);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String jsonString = jsonObject.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            Ville ville = objectMapper.readValue(jsonString, Ville.class);
            return ville;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public float getDistance(float lat1, float lon1, float lat2, float lon2) {

        float radlat1 = (float) (Math.PI * lat1/180);
        float radlat2 = (float) (Math.PI * lat2/180);
        float theta = lon1-lon2;
        float radtheta = (float) (Math.PI * theta/180);
        float dist = (float) (Math.sin(radlat1) * Math.sin(radlat2) + Math.cos(radlat1) * Math.cos(radlat2) * Math.cos(radtheta));
        if (dist > 1) {
            dist = 1;
        }
        dist = (float) Math.acos(dist);
        dist = (float) (dist * 180/Math.PI);
        dist = (float) (dist * 60 * 1.1515);
        dist = (float) (dist * 1.609344);

        return dist;

        /*float deltaY = (lat2 - lat1);
        float deltaX = (float) ((lon2-lon1)*Math.cos((lat1+lat2)/2));
        return (float) Math.sqrt(deltaY*deltaY + deltaX*deltaX);*/
    }
}
