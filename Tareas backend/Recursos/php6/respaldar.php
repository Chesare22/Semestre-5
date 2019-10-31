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

$sentenciaSQL = "SELECT * FROM usuarios";

$registros = ConsultarSQL ($servidor, $usuario, $contrasena, $basedatos, $sentenciaSQL);
$contador = count($registros);

$carpeta = './respaldos/';
if (!file_exists($carpeta)) mkdir($carpeta, 0777, true);
	
$archivo = "./respaldos/respaldo" . date("YmdHis") . ".txt";
file_put_contents($archivo, "id_usuario,usuario,contrasena,nombre\r\n", FILE_APPEND | LOCK_EX);
for($i = 0; $i < $contador; $i++) {
	
	// Usar \r\n para que pueda ser visualizado correctamente en bloc de notas (Windows)
	$cadena = implode(",", $registros[$i]) . "\r\n";
	file_put_contents($archivo, $cadena, FILE_APPEND | LOCK_EX);
}

?>
<html>
<head>
	<title>Respaldar</title>
	<script>
		alert("Respaldo concretado.");
		window.location.href = "menu.php";
	</script>
</head>
</html>