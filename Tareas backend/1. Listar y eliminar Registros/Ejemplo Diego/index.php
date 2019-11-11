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
<form action="validar.php" name="formulario">
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
		<td colspan="2" align="right"><input type="submit" name="boton" value="Iniciar"></td>
	</tr>
	
</table>
</form>
<script>
	formulario.onsubmit = function(){
		event.preventDefault();//Evita que se haga el envio del formulario
		let stringBuilder = formulario.usuario.name+"="+formulario.usuario.value +
							"&"+ formulario.contrasena.name+"="+formulario.contrasena.value;
		let xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				handleResponse(this.responseText);
			}
		}
		xmlhttp.open("get", "validar.php?" + stringBuilder, true);
		xmlhttp.send();
	}

	function handleResponse(jsonResponse){
		let response = JSON.parse(jsonResponse);
		if(response.ok){//Se da acceso a la pagina menu.php
			this.document.location = response.mensaje;
		}else{//Se crea el mensaje
			let messageContainer = document.createElement('div');
			messageContainer.innerHTML = response.mensaje;
			formulario.appendChild(messageContainer);
			setTimeout(function(){messageContainer.remove();}, 3000);
		}
	}
</script>
</body>
</html>
