package com.example.tp_eseo_api_rest_client.model;

import lombok.Data;

@Data
public class Ville {

    private String codeINSEE;
    private String codePostal;
    private String nomCommune;
    private String libelleAcheminement;
    private String ligne5;
    private String latitude;
    private String longitude;

}
