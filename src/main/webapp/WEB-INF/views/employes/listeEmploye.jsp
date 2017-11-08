<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Remplacer la ligne du dessus par celle-ci pour désativer le zoom -->
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"> -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Permet d'afficher un icône dans la barre d'adresse -->
    <!-- <link rel="shortcut icon" href="image/favicon.png"> -->
    <title>Liste des employés</title>

    <!-- css Bootstrap -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" rel="stylesheet">

    <!-- HTML5 Shim et Respond.js permet à IE8 de supporter les éléments du HTML5 -->
    <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-left: 12%;">
        <a class="navbar-brand" href="creer">Employé</a>
        <a class="navbar-brand" href="lister">Bulletin</a>
    </nav>



    <div class="container">
        <!-- <a href="index.html"><i class="icon icon-arrow-left" aria-hidden="true" style="font-size:100px;color:black;"></i></a> -->
        <div class="text-center">
            <h1>Liste des employés</h1>
        </div>

        <a href="creer" class="btn btn-info" role="button" style="margin-bottom:2%;margin-left:87%;">Ajouter un employe</a>

        <table class="table table-hover table-bordered">
            <thead>
                <tr>
                    <th width="40%;">Date / Heure de création</th>
                    <th>Matricule</th>
                    <th>Grade</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:forEach var="remunerationEmploye" items="${remunerationEmployes}">
                    	<td>${remunerationEmploye.creationDate}</td>
                    	<td>${remunerationEmploye.matricule}</td>
                    	<td>${remunerationEmploye.grade.code }</td>
                    </c:forEach>
                </tr>
            </tbody>
        </table>
    </div>
</body>

</html>