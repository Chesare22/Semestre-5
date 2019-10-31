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

// Imprimir el valor de una variable
// echo "<pre>";
// print_r ($_REQUEST);
// echo "</pre>";
// exit();

$contador = count ($_REQUEST["usuario"]);
for ($i = 0; $i < $contador; $i++) {

	$id_usuarioF = (isset($_REQUEST["usuario"][$i]) && is_numeric($_REQUEST["usuario"][$i])) ? $_REQUEST["usuario"][$i] : 0;
	$sentenciaSQL = "DELETE FROM usuarios WHERE id_usuario = " . ;
	EjecutarSQL ($servidor, $usuario, $contrasena, $basedatos, $sentenciaSQL);

}

header("location: menu.php");

?>