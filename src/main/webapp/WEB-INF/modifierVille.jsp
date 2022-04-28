<%--
  Created by IntelliJ IDEA.
  User: terri
  Date: 27/04/2022
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modification de ville</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div style="height: 10%; background-color: darkseagreen" class="flex items-center justify-center text-6xl font-serif font-bold">
    <h1 style="color: darkgreen">APvIlles</h1>
</div>

<div class="mt-10 w-full max-w-xs justify-items-center" style="margin-left: 800px">
    <form class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4" method="post" action="modifier">
        <div>
            <label for="nomCommune" class="block text-gray-700 text-sm font-bold mb-2">Nom de la commune</label>
            <input type="text" name="nomCommune" id="nomCommune" value="${ville.nomCommune}" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
        </div>
        <div>
            <label for="codePostal" class="block text-gray-700 text-sm font-bold mb-2">Code Postal</label>
            <input type="text" name="codePostal" id="codePostal" value="${ville.codePostal}" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
        </div>
        <div>
            <label for="libelleAcheminement" class="block text-gray-700 text-sm font-bold mb-2">Libelle d'acheminement</label>
            <input type="text" name="libelleAcheminement" id="libelleAcheminement" value="${ville.libelleAcheminement}" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
        </div>
        <div>
            <label for="ligne5" class="block text-gray-700 text-sm font-bold mb-2">Ligne 5</label>
            <input type="text" name="ligne5" id="ligne5" value="${ville.ligne5}" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
        </div>
        <div>
            <label for="latitude" class="block text-gray-700 text-sm font-bold mb-2">Latitude</label>
            <input type="text" name="latitude" id="latitude" value="${ville.latitude}" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
        </div>
        <div>
            <label for="longitude" class="block text-gray-700 text-sm font-bold mb-2">Longitude</label>
            <input type="text" name="longitude" id="longitude" value="${ville.longitude}" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
        </div>
        <input type="hidden" name="codeINSEE" value="${ville.codeINSEE}">
        <div>
            <input type="submit" value="Modifier la ville" class="mt-6 font-bold py-2 px-4 rounded text-white bg-[darkseagreen] hover:bg-[#638863] hover:cursor-pointer">
        </div>
    </form>
</div>

</body>
</html>
