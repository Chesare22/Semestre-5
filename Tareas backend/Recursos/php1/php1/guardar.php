<?php

//Guardar el nombre de usuario, contraseña y nombre en la tabla de usuarios usando la función EjecutarSQL()

//incluir un archivo de bibliotecas funciones.php que defina la función
// EjecutarSQL ($servidor, $usuario, $contrasena, $basedatos, $sentenciaSQL)

// function Suma ($a, $b) { return ($a + $b); };

include "funciones.php";
$sql = "SELECT usuario, contrasena FROM usuarios WHERE usuario ='" . $_REQUEST["usuario"] . "'";
ejecutarSQL("localhost", "root", "root", "inventarios", $sql)


header("location: menu.php");

?>