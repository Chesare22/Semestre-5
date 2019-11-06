<?php

include("funciones.php");

$servidor = "localhost";
$usuario = "root";
$contrasena = "root";
$basedatos = "tienda";

$sentenciaSQL = "INSERT INTO usuarios (usuario, contrasena, nombre) VALUES ('" . $_REQUEST["usuario"] . "', '" . $_REQUEST["contrasena"] . "', '" . $_REQUEST["nombre"] . "')";

//Guardar el nombre de usuario, contraseña y nombre en la tabla de usuarios
EjecutarSQL ($servidor, $usuario, $contrasena, $basedatos, $sentenciaSQL);

header("location: menu.php");

?>