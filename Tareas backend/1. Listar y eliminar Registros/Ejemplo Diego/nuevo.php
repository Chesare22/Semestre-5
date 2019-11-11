<html>
<head>
	<title>Registrar usuario</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	
	<style></style>
	
	<script>
	window.onload = function () {
	
		document.forma.cancelar.onclick = function() {
			history.back();
		}

		forma.onsubmit = function(){
			event.preventDefault();//Evita que se haga el envio del formulario
			let stringBuilder = forma.usuario.name+"="+forma.usuario.value +
								"&"+ forma.contrasena.name+"="+forma.contrasena.value+
								"&"+ forma.contrasenaRepetir.name+"="+forma.contrasenaRepetir.value+
								"&"+ forma.nombre.name+"="+forma.nombre.value;
			let xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					console.log(this.responseText);
					handleResponse(this.responseText);
				}
			}
			xmlhttp.open("post", "guardar.php", true);
			xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			xmlhttp.send(stringBuilder);
		}
	
	}

	function handleResponse(jsonResponse){
		let response = JSON.parse(jsonResponse);
		if(response.ok){//Se da acceso a la pagina menu.php
			this.document.location = response.mensaje;
		}else{//Se crea el mensaje
			let messageContainer = document.createElement('div');
			messageContainer.innerHTML = response.mensaje;
			forma.appendChild(messageContainer);
			setTimeout(function(){messageContainer.remove();}, 3000);
		}
	}

	</script>
	
</head>
<body>
<h1>Registrar usuario</h1>
<form name="forma">
<table>
	<tr>
		<td>Usuario:</td>
		<td><input type="text" name="usuario" size="20" required></td>
	</tr>
	<tr>
		<td>Contraseña:</td>
		<td><input type="password" name="contrasena" size="20" required></td>
	</tr>
	<tr>
		<td>Confirmar contraseña:</td>
		<td><input type="password" name="contrasenaRepetir" size="20" required></td>
	</tr>
	<tr>
		<td>Nombre completo:</td>
		<td><input type="password" name="nombre" size="20" required></td>
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
