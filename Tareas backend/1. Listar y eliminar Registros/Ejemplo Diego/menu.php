<?php 
	include('funciones.php');

	function generarTabla(){
		$sql = "SELECT id, usuario, nombre FROM usuarios ORDER BY usuario ASC";
		$result = ConsultaSQL($sql);//Arreglo de usuarios
		echo "<table>\n";
		echo "<tr><th></th><th>Usuario</th><th>Nombre</th></tr>\n";
		foreach($result as $row)
			echo "<tr>\n<td><input type=\"checkbox\" name=\"usuario\" value=\"" . $row["id"] . "\"></td>\n" . 
				"<td>" . $row["usuario"] . "</td>\n" . 
				"<td>" . $row["nombre"] . "</td>\n</tr>\n";
		echo "</table>";
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
	
</head>
<body>
<h1>Iniciar sesión</h1>
<ul>
	<li><a href="nuevo.php">Registrar usuarios</a></li>
</ul>
<form name="Formulario">
	<?php generarTabla();?>
	<input type="submit" value="Delete" name="Delete">
</form>
<script>
/* global Formulario */

function getIdSelected () {
  const checkArray = document.getElementsByName('usuario')
  const ids = new Array()
  checkArray.forEach(({ checked, value }) => {
    if (checked) {
      ids.push(parseInt(value))
    }
  })
  return ids
}

function handleResponse (response) {
  this.document.location = response
}

function ajax (idArray) {
  const xmlhttp = new XMLHttpRequest()
  xmlhttp.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
      handleResponse(this.responseText)
    }
  }
  const stringBuilder = `usuario=${idArray}`
  xmlhttp.open('get', `deleteUsers.php?${stringBuilder}`, true)
  xmlhttp.send()
}

Formulario.onsubmit = function () {
  event.preventDefault()
  const choice = confirm('¿Desea borrar los registros seleccionados?')
  if (choice) {
    const ids = getIdSelected()
    console.log(ids)
    if (ids.length > 0) {
      ajax(ids)
    }
  }
}

</script>
<?php include("pie.php"); ?>
</body>
</html>