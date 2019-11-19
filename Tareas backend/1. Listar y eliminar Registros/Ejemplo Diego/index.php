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
/* global formulario */

function handleResponse (jsonResponse) {
  const { ok, mensaje } = JSON.parse(jsonResponse)
  if (ok) {
    this.document.location = mensaje
  } else {
    const messageContainer = document.createElement('div')
    messageContainer.innerHTML = mensaje
    formulario.appendChild(messageContainer)
    setTimeout(function () {
      messageContainer.remove()
    }, 3000)
  }
}

formulario.onsubmit = function () {
  event.preventDefault()// Evita que se haga el envio del formulario
  const xmlhttp = new XMLHttpRequest()
  xmlhttp.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
      console.log(this.responseText)
      handleResponse(this.responseText)
    }
  }

  const { usuario: user, contrasena: password } = formulario
  const queryParams = `${user.name}=${user.value}&${password.name}=${password.value}`
  xmlhttp.open('get', `validar.php?${queryParams}`, true)
  xmlhttp.send()
}

</script>
</body>
</html>
