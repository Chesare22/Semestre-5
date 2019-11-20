<?php
include 'funciones.php';

$sentenciaSQL = "UPDATE `usuarios` SET `usuario`='{$_GET['user']}', `nombre`='{$_GET['name']}', `rol`={$_GET['role']} WHERE id={$_GET['id']}";

EjecutarSQL($sentenciaSQL);

echo $sentenciaSQL;
?>