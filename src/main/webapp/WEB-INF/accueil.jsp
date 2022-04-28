<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: terri
  Date: 26/04/2022
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>

<div style="height: 10%; background-color: darkseagreen" class="flex items-center justify-center text-6xl font-serif font-bold">
    <h1 style="color: darkgreen">APvIlles</h1>
</div>
<div style="height: 15%" class="grid grid-cols-2 divide-x">
    <div class="text-center pt-20 pb-12">
        <label for="ville1">Choisir une première ville : </label>
        <select id="ville1" form="villeForm" name="codeINSEEVille1">
            <c:forEach items="${listVilles}" var="ville">
                <option value="${ville.codeINSEE}">${ville.nomCommune}</option>
            </c:forEach>
        </select>
    </div>
    <div class="text-center pt-20 pb-12">
        <label for="ville2">Choisir une deuxième ville : </label>
        <select id="ville2" form="villeForm" name="codeINSEEVille2">
            <c:forEach items="${listVilles}" var="ville">
                <option value="${ville.codeINSEE}">${ville.nomCommune}</option>
            </c:forEach>
        </select>
    </div>
</div>
<form id="villeForm" class="text-center items-center" method="post" action="accueil">
    <input type="submit" value="Calculer la distance entre ces 2 villes" style="color: darkgreen; background-color: darkseagreen" class="mt-20 font-bold py-2 px-4 rounded">
</form>
<c:if test="${distance != null}">
    <div class="text-center">
        <p>La distance entre les 2 villes est de ${distance} km</p>
    </div>
</c:if>

<div>
    <a href="listeVilles">
        <button type="submit" class="mt-20 font-bold py-2 px-4 rounded">Liste des villes</button>
    </a>
</div>

</body>
</html>
