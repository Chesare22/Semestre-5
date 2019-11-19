<?php 
	include('funciones.php');

	function generarTabla(){
		$sql = "SELECT id, usuario, nombre, rol FROM usuarios ORDER BY usuario ASC";
		$result = ConsultaSQL($sql);//Arreglo de usuarios
		echo "<table class=\"collapsed\">\n";
		echo "<tr><th>Eliminar</th><th>Usuario</th><th>Nombre</th><th>Rol</th></tr>\n";
		foreach($result as $row)
			echo "<tr>\n<td><input type=\"checkbox\" name=\"usuario\" value=\"" . $row["id"] . "\"></td>\n" . 
				"<td><button class=\"invisible\" name=\"edit\" value=\"" . $row["id"] . "\">" . $row["usuario"] . "</button></td>\n" . 
				"<td><button class=\"invisible\" name=\"edit\" value=\"" . $row["id"] . "\">" . $row["nombre"] . "</button></td>\n" .
				"<td><button class=\"invisible\" name=\"edit\" value=\"" . $row["id"] . "\">" . $row["rol"] . "</button></td>\n</tr>\n";
		echo "</table>";
	}

?>
<html>
<head>
	<title>Aplicación</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<style>
		table.collapsed {
      border-collapse: collapse;
		}
    table.collapsed, th, td {
      border: 1px solid black;
    }

    button.invisible {
      border: none;
      background-color: transparent;
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

window.onload = () => {
  // Add 'onclick' to each button
  if (Formulario.edit) {
    Formulario.edit.forEach(button => {
      button.addEventListener('click', () => {
        event.preventDefault()// Evita que se haga el envio del formulario
        this.document.location = `editUser.php?id=${button.value}`
      })
    })
  }
}

function getIdSelected () {
  const checkArray = document.getElementsByName('usuario')
  const ids = []
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
  const params = `ids=${idArray}`
  xmlhttp.open('get', `deleteUsers.php?${params}`, true)
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