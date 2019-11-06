<?php

function ejecutarSQL($servidor, $usuario, $contrasena, $basedatos, $sentenciaSQL){
  $conexion = mysqli_connect($servidor, $usuario, $contrasena, $basedatos);
  if (!$conexion) {
    die("Fallo: " . mysqli_connect_error());
  }

  $resultado = mysqli_query($conexion, $sql);
  mysqli_close($conexion);

  if (mysqli_num_rows($resultado) > 0) {
    //Si hay registro reenviar a la página menu.php
    header("location: menu.php");
  } else {
    //Sino redirigir a la página index.html 
    header("location: index.php");
  }
}

?>