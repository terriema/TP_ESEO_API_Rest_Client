<%--
  Created by IntelliJ IDEA.
  User: terri
  Date: 27/04/2022
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Villes</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.tailwindcss.com"></script>
    <!-- Plugin styles -->
    <link rel="stylesheet" media="all" href="https://s3.amazonaws.com/dynatable-docs-assets/css/jquery.dynatable.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-beta1/jquery.js"></script>
    <script type='text/javascript' src='https://s3.amazonaws.com/dynatable-docs-assets/js/jquery.dynatable.js'></script>
</head>
<body>
<div style="height: 10%; background-color: darkseagreen" class="flex items-center justify-center text-6xl font-serif font-bold">
    <a href="accueil">
        <h1 style="color: darkgreen">APvIlles</h1>
    </a>
</div>

<div class = "container pt-8 pb-8">
    <table id="tableVilles" class="table table-striped table-bordered">
        <thead>
            <tr style="background-color: darkseagreen; color: white">
                <th>Code INSEE</th>
                <th>Code Postal</th>
                <th>Nom de la Commune</th>
                <th>Libellé acheminement</th>
                <th>Ligne 5</th>
                <th>Latitude</th>
                <th>Longitude</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listVilles}" var="ville">
                <tr>
                    <td><c:out value="${ville.codeINSEE}"/></td>
                    <td><c:out value="${ville.codePostal}"/></td>
                    <td><c:out value="${ville.nomCommune}"/></td>
                    <td><c:out value="${ville.libelleAcheminement}"/></td>
                    <td><c:out value="${ville.ligne5}"/></td>
                    <td><c:out value="${ville.latitude}"/></td>
                    <td><c:out value="${ville.longitude}"/></td>
                    <td>
                        <a href="modifier?ville=${ville.codeINSEE}">
                            <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded bg-[darkseagreen] hover:bg-[#638863]">
                                Modifier
                            </button>
                        </a>
                        <a href="supprimer?ville=${ville.codeINSEE}">
                            <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded bg-[darkseagreen] hover:bg-[#638863]">
                                Supprimer
                            </button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <script>
        $(document).ready(function() {
            $('#tableVilles').dynatable({
                features: {
                    paginate: true,
                    sort: true,
                    pushState: true,
                    search: true,
                    recordCount: true,
                    perPageSelect: true
                },
                dataset: {
                    perPageDefault: 50,
                    perPageOptions: [5, 10, 20, 50, 100]
                },
                inputs: {
                    paginationNext: "Suivant",
                    paginationPrev: "Précédent",
                    pageText: "Page",
                    recordCountText: "Communes",
                    searchText: "Rechercher : ",
                    perPageText: "Montrer : ",
                    recordCountPageBoundTemplate: "{pageLowerBound} à {pageUpperBound} sur"
                },
                params:{
                    records: "communes"
                }
            });
            var styleSearch = "border: 2px solid darkgreen; border-radius: 3px;";

            document.getElementById('dynatable-query-search-tableVilles').setAttribute('style', styleSearch);


        });
    </script>
</div>
</body>
</html>
