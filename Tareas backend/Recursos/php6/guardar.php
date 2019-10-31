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
//$conexion = mysqli_connect($servidor, $usuario, $contrasena, $basedatos);
//if (!$conexion) die("Fallo: " . mysqli_connect_error());
//$usuarioF = mysqli_real_escape_string($conexion, $_REQUEST["usuario"]);
//$contrasenaF = mysqli_real_escape_string($conexion, $_REQUEST["contrasena"]);
//$nombreF = mysqli_real_escape_string($conexion, $_REQUEST["nombre"]);
//mysqli_close($conexion);

//Evitar cross scripting - sustituir caraceres por equivalentes en HTML
$usuarioF = htmlentities($_REQUEST["usuario"], ENT_QUOTES);
$contrasenaF = htmlentities($_REQUEST["contrasena"], ENT_QUOTES);
$nombreF = htmlentities($_REQUEST["nombre"], ENT_QUOTES);

//Evitar cross scripting - eliminar etiquetas HTML
$usuarioF = strip_tags($usuarioF);
$contrasenaF = strip_tags($contrasenaF);
$nombreF = strip_tags($nombreF);

if (empty($_REQUEST["id_usuario"]))
	$sentenciaSQL = "INSERT INTO usuarios (usuario, contrasena, nombre) VALUES ('" . $usuarioF . "', '" . $contrasenaF . "', '" . $nombreF . "')";
else
	$sentenciaSQL = "UPDATE usuarios SET usuario = '{$usuarioF}', contrasena = '{$contrasenaF}' , nombre = '{$nombreF}' WHERE id_usuario = {$_REQUEST["id_usuario"]}";

//Guardar el nombre de usuario, contraseña y nombre en la tabla de usuarios
EjecutarSQL ($servidor, $usuario, $contrasena, $basedatos, $sentenciaSQL);

header("location: menu.php");

?>