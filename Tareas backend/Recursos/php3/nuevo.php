<html>
<head>
	<title>Registrar usuario</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	
	<style>
	
		#error {
			border: solid 1px #CCC;
			background-color: #EEE;
			color: blue;
			visibility: hidden;
 			margin-bottom: 4px;
 			padding: 4px;
    		width: 500px;
 		}

	
	</style>
	
	<script>
	window.onload = function () {
	
		document.forma.cancelar.onclick = function() {
			history.back();
		}
		
		document.forma.onsubmit = function () {
				
			// Validación individual
			if (document.forma.usuario.value == "") {
				alert("Debe proporcionar el nombre de usuario.");
				document.forma.usuario.focus();
				return false;
			}
			
			// Validación grupal
			var mensaje = "";
			if (document.forma.contrasena.value == "") {
				mensaje += "Debe proporcionar la clave de acceso. <a href=\"javascript:document.forma.contrasena.focus();\"><img src=\"imagenes/info-16.gif\"></a><br>";
			}
			if (document.forma.contrasena.value != document.forma.contrasena1.value) {
				mensaje += "las claves de acceso no coinciden.<br>";
				document.forma.contrasena.value = "";
				document.forma.contrasena1.value = "";
			}
			if (document.forma.nombre.value == "") {
				mensaje += "Debe proporcionar el nombre completo del usuario.";
			}
			
			if(mensaje != "") {
				document.getElementById("error").innerHTML = mensaje;
				document.getElementById("error").style.visibility = "visible";
				return false;
			} else
				return true;
		}
	
	}
	</script>
	
</head>
<body>
<h1>Registrar usuario</h1>
<div id="error"></div>
<form name="forma" action="guardar.php" method="post">
<table>
	<tr>
		<td>Usuario:</td>
		<td><input type="text" name="usuario" size="20"></td>
	</tr>
	<tr>
		<td>Contraseña:</td>
		<td><input type="password" name="contrasena" size="20"></td>
	</tr>
	<tr>
		<td>Confirmar contraseña:</td>
		<td><input type="password" name="contrasena1" size="20"></td>
	</tr>
	<tr>
		<td>Nombre completo:</td>
		<td><input type="text" name="nombre" size="20"></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="button" name="cancelar" value="Cancelar">
			<input type="submit" name="boton" value="Registrar">
		</td>
	</tr>
	
</table>
</form>
<?php include("pie.php"); ?>
</body>
</html>
