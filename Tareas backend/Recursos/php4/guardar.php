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

if (empty($_REQUEST["usuario"])) {
	header("location: nuevo.php");
	exit();
}

if (empty($_REQUEST["contrasena"])) {
	header("location: nuevo.php");
	exit();
}

if (empty($_REQUEST["nombre"])) {
	header("location: nuevo.php");
	exit();
}

//Evitar inyección SQL - sustituir caraceres para que no se interprete
$usuarioF = mysqli_real_escape_string($conexion, $_REQUEST["usuario"]);
$contrasenaF = mysqli_real_escape_string($conexion, $_REQUEST["contrasena"]);
$nombreF = mysqli_real_escape_string($conexion, $_REQUEST["nombre"]);

//Evitar cross scripting - sustituir caraceres por equivalentes en HTML
$usuarioF = htmlentities($usuarioF, ENT_QUOTES);
$contrasenaF = htmlentities($contrasenaF, ENT_QUOTES);
$nombreF = htmlentities($nombreF, ENT_QUOTES);

//Evitar cross scripting - eliminar etiquetas HTML
$usuarioF = strip_tags($usuarioF);
$contrasenaF = strip_tags($contrasenaF);
$nombreF = strip_tags($nombreF);
 
$sentenciaSQL = "INSERT INTO usuarios (usuario, contrasena, nombre) VALUES ('" . $usuarioF . "', '" . $contrasenaF . "', '" . $nombreF . "')";

//Guardar el nombre de usuario, contraseña y nombre en la tabla de usuarios
EjecutarSQL ($servidor, $usuario, $contrasena, $basedatos, $sentenciaSQL);

header("location: menu.php");

?>