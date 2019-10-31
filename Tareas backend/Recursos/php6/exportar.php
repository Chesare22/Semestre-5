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

$sentenciaSQL = "SELECT * FROM usuarios";

$registros = ConsultarSQL ($servidor, $usuario, $contrasena, $basedatos, $sentenciaSQL);
$contador = count($registros);

$archivo = "respaldo" . date("YmdHis") . ".xls";
$tabla = "<html><body>";
$tabla .= "<table>";
$tabla .= "<tr><th>id_usuario</th><th>usuario</th><th>contrasena</th><th>nombre</th></tr>\r\n";
for($i = 0; $i < $contador; $i++) {
	$tabla .= "<tr>";
	$tabla .= "<td>" . $registros[$i]["id_usuario"] . "</td>\r\n";
	$tabla .= "<td>" . $registros[$i]["usuario"] . "</td>\r\n";
	$tabla .= "<td>" . $registros[$i]["contrasena"] . "</td>\r\n";
	$tabla .= "<td>" . $registros[$i]["nombre"] . "</td>\r\n";
	$tabla .= "<tr>\r\n";
}
$tabla .="</table>";
$tabla .="</body></html>";

header("Content-Type: application/force-download");
header("Content-Disposition: attachment; filename=\"{$archivo}\"");
header("Content-Transfer-Encoding: binary");
header("Pragma: no-cache");
header("Expires: 0");

print $tabla;

?>