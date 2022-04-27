package com.example.tp_eseo_api_rest_client.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ModifierVilleServlet", value = "/modifier")
public class ModifierVilleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codeINSEE = request.getParameter("ville");

        System.out.println("codeINSEE : " + codeINSEE);

        this.getServletContext().getRequestDispatcher("/WEB-INF/modifierVille.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
