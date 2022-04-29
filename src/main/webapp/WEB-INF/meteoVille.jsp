<%--
  Created by IntelliJ IDEA.
  User: terri
  Date: 28/04/2022
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meteo des villes</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div style="height: 10%; background-color: darkseagreen" class="flex items-center justify-center text-6xl font-serif font-bold">
    <a href="accueil">
        <h1 style="color: darkgreen">APvIlles</h1>
    </a>
</div>
<div class="text-center pt-20 pb-12">
    <form id="villeForm" method="post" action="meteoVille">
        <label for="ville">Choisir une ville : </label>
        <select id="ville" form="villeForm" name="codeINSEEVille" style="border: 2px solid darkgreen; border-radius: 3px">
            <c:forEach items="${listVilles}" var="ville">
                <option value="${ville.codeINSEE}">${ville.nomCommune}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Afficher la météo" class="ml-4 mt-6 font-bold py-2 px-4 rounded text-white bg-[darkseagreen] hover:bg-[#638863] hover:cursor-pointer">
    </form>
</div>
<c:if test="${weather != null}">
    <div class="flex justify-center">
        ${weather}
    </div>
</c:if>
</body>
</html>
