<?php
include 'funciones.php';

$userIdArray = explode(",", $_GET["usuario"]);
$contador = count ($userIdArray);
for ($i = 0; $i <$contador; $i++) {

	$sentenciaSQL = "DELETE FROM usuarios WHERE id = " . $userIdArray[$i];
	EjecutarSQL ($sentenciaSQL);

}
echo 'menu.php';
?>