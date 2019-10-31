<?php

// * * * * 
session_start();
if ($_SESSION["valido"] != true) {
	 header("location: index.php?estado=4");
	 exit();
}	
// * * * * 

include("variables.php");

include("funciones.php");

$carpeta = './subidas/';
if (!file_exists($carpeta)) mkdir($carpeta, 0777, true);

$archivo = $carpeta . date("YmdHis") . basename($_FILES['archivo']['name']);

move_uploaded_file($_FILES['archivo']['tmp_name'], $archivo);

?>

?>
<html>
<head>
	<title>Subir</title>
	<script>
		alert("Subida concretada.");
		//window.location.href = "menu.php";
	</script>
</head>
</html>