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
	Formulario.onsubmit = function(){
		event.preventDefault();
		let choice = confirm("¿Desea borrar los registros seleccionados?");
		if(choice){
			let ids = getIdSelected();
			console.log(ids);
			if(ids.length>0){
				ajax(ids);
			}
		}
	}

	function ajax(idArray){
		let xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				handleResponse(this.responseText);
			}
		}
		let stringBuilder = "usuario="+ idArray;
		xmlhttp.open("get", "deleteUsers.php?" + stringBuilder, true);
		xmlhttp.send();
	}

	function handleResponse(response){
		this.document.location = response;
	}

	function getIdSelected(){
		let checkArray = document.getElementsByName("usuario");
		let ids= new Array();
		checkArray.forEach(element => {
			if(element.checked){
				ids.push(parseInt(element.value));
			}
		});
		return ids;
	}
	
</script>
<?php include("pie.php"); ?>
</body>
</html>