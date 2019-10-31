<?php

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

$sentenciaSQL = "INSERT INTO usuarios (usuario, contrasena, nombre) VALUES ('" . $_REQUEST["usuario"] . "', '" . $_REQUEST["contrasena"] . "', '" . $_REQUEST["nombre"] . "')";

//Guardar el nombre de usuario, contraseña y nombre en la tabla de usuarios
EjecutarSQL ($servidor, $usuario, $contrasena, $basedatos, $sentenciaSQL);

header("location: menu.php");

?>