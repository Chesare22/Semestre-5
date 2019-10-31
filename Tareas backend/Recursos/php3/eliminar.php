<?php

include("variables.php");

include("funciones.php");

// Imprimir el valor de una variable
// echo "<pre>";
// print_r ($_REQUEST);
// echo "</pre>";
// exit();

$contador = count ($_REQUEST["usuario"]);
for ($i = 0; $i < $contador; $i++) {

	$sentenciaSQL = "DELETE FROM usuarios WHERE id_usuario = " . $_REQUEST["usuario"][$i];
	EjecutarSQL ($servidor, $usuario, $contrasena, $basedatos, $sentenciaSQL);

}

header("location: menu.php");

?>