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

function generarTabla() {

	global $servidor, $usuario, $contrasena, $basedatos;
	
	$sentenciaSQL = "SELECT id_usuario, usuario,nombre FROM usuarios ORDER BY usuario ASC";
	$registros = ConsultarSQL ($servidor, $usuario, $contrasena, $basedatos, $sentenciaSQL);
	$contador = count($registros);
	
	echo "<table>\n";
	echo "<tr><th></th><th>Usuario</th><th>Nombre</th></tr>\n";
	for($i = 0; $i < $contador; $i++)
		echo "<tr>\n<td><input type=\"checkbox\" name=\"usuario[]\" value=\"" . $registros[$i]["id_usuario"] . "\"></td>\n" . 
			"<td>" . $registros[$i]["usuario"] . "</td>\n" . 
			"<td>" . $registros[$i]["nombre"] . "</td>\n</tr>\n";
	echo "</table>\n";

/* otra variante usando foreach
	echo "<table>\n";
	echo "<tr><th></th><th>Usuario</th><th>Nombre</th></tr>\n";
	foreach($registros as $registro)
		echo "<tr>\n<td><input type=\"checkbox\" name=\"usuario[]\" value=\"" . $registro["id_usuario"] . "\"></td>\n" . 
			"<td>" . $registro["usuario"] . "</td>\n" . 
			"<td>" . $registro["nombre"] . "</td>\n</tr>\n";
	echo "</table>";
*/

}

?>

<html>
<head>
	<title>Aplicación</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	
	<style>
		table {
			border: solid 1px;
		}
	</style>

	<script>
	
	window.onload = function() {
	
		document.forma.onsubmit = function () {
			return confirm("¿Desea borrar los registros seleccionados?");
		}
	
	} 
	
	</script>

	
</head>
<body>
<h1>Iniciar sesión</h1>
<ul>
	<li><a href="nuevo.php">Registrar usuarios</a></li>
</ul>
<form name="forma" action="eliminar.php" method="get">
<?php generarTabla(); ?>
<input type="submit" name="Borrar" value="Borrar">
</form>
<?php include("pie.php"); ?>
</body>
</html>