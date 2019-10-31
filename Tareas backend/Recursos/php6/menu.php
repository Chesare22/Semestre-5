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

// Si llaman a la página con la variable accion=cerrarSesion ... cerramos la sesión
$accion = (isset($_REQUEST["accion"]) && is_string($_REQUEST["accion"])) ? $_REQUEST["accion"] : "";
if ($accion == "cerrarSesion") {
	session_start();
	$_SESSION = array();
	session_destroy();
	header("location: index.php?estado=5");
}
	
function generarTabla() {

	global $servidor, $usuario, $contrasena, $basedatos;
	
	$sentenciaSQL = "SELECT id_usuario, usuario,nombre FROM usuarios ORDER BY usuario ASC";
	$registros = ConsultarSQL ($servidor, $usuario, $contrasena, $basedatos, $sentenciaSQL);
	$contador = count($registros);
	
	echo "<table>\n";
	echo "<tr><th></th><th>Usuario</th><th>Nombre</th></tr>\n";
	for($i = 0; $i < $contador; $i++)
		echo "<tr>\n<td><input type=\"checkbox\" name=\"usuario[]\" value=\"" . $registros[$i]["id_usuario"] . "\"></td>\n" . 
			"<td><a href=\"nuevo.php?accion=editar&id_usuario=" . $registros[$i]["id_usuario"] . "\">" . $registros[$i]["usuario"] . "</a></td>\n" . 
			"<td>" . $registros[$i]["nombre"] . "</td>\n</tr>\n";
	echo "</table>\n";

/* otra variante usando foreach
	echo "<table>\n";
	echo "<tr><th></th><th>Usuario</th><th>Nombre</th></tr>\n";
	foreach($registros as $registro)
		echo "<tr>\n<td><input type=\"checkbox\" name=\"usuario[]\" value=\"" . $registro["id_usuario"] . "\"></td>\n" . 
			"<td><a href=\"nuevo.php?accion=editar&id_usuario=" . $registro["id_usuario"] . "\">" . $registro["usuario"] . "</a></td>\n" . 
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
			margin-bottom: 4px;
		}
	</style>

	<script>
	
	window.onload = function() {
	
		document.forma.onsubmit = function () {
			return confirm("¿Desea borrar los registros seleccionados?");
		}

		document.subir.onsubmit = function () {
			
			if (document.subir.archivo.value == "") {
				document.subir.archivo.focus();
				alert("Debe seleccionar un archivo txt.");
				return false;
			}
			
			if (document.subir.archivo.value.substr(document.subir.archivo.value.length - 3) != "txt"){
				document.subir.archivo.value = "";
				document.subir.archivo.focus();
				alert("Debe seleccionar un archivo txt.");
				return false;
			}
		}
		
		document.forma.exportar.onclick = function () {
			window.location.href = "exportar.php";
		}
		
		document.forma.respaldar.onclick = function () {
			window.location.href = "respaldar.php";
		}

		document.forma.imprimir.onclick = function () {
			window.print();
		}
	
	} 
	
	</script>

	
</head>
<body>
<h1>Bienvenido <?php echo $_SESSION["nombre"]; ?></h1>
<ul>
	<li><a href="nuevo.php">Registrar usuarios</a></li>
	<li><a href="menu.php?accion=cerrarSesion">Cerrar la sesi&oacute;n</a></li>
</ul>
<form name="forma" action="eliminar.php" method="get">
<?php generarTabla(); ?>
<input type="submit" name="borrar" value="Borrar"><input type="button" name="imprimir" value="imprimir"><input type="button" name="exportar" value="Exportar tabla"><input type="button" name="respaldar" value="Respaldar tabla en servidor">
</form>
<form action="subir.php" method="post" enctype="multipart/form-data" name="subir">
	<input type="hidden" name="MAX_FILE_SIZE" value="30000" />
    <label for="archivo">Archivo:</label>
    <input type="file" name="archivo"/>
    <input type="submit" name="boton" value="Subir archivo" />
</form>
<?php include("pie.php"); ?>
</body>
</html>