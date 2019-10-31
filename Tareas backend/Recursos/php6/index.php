<?php

// Validación clásica
$estado = (isset($_REQUEST["estado"]) && is_numeric($_REQUEST["estado"])) ? $_REQUEST["estado"] : 0;
$usuario = (isset($_REQUEST["usuario"]) && is_string($_REQUEST["usuario"])) ? $_REQUEST["usuario"] : "";

// Validación con filtro
//$estado = filter_input(INPUT_GET, "estado", FILTER_SANITIZE_URL);
//$usuario = filter_input(INPUT_GET, "usuario", FILTER_SANITIZE_STRING);

switch ($estado) {
    case 1:
        $cadena = "Debe proporcionar tu nombre de usuario.";
        break;
    case 2:
        $cadena = "Debe proporcionar su contrase&ntilde;a.";
        break;
    case 3:
        $cadena = "El nombre de usuario o la contrase&ntilde;a son incorrectos.";
        break;
    case 4:
        $cadena = "Debes iniciar sesi&oacute;n para utilizar el sistema.";
        break;
    default:
    	$cadena = "";
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
		
		#estado {
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
	
	<?php echo "var estado = '" . $cadena . "';"; ?>
	
	function ocultarPanelEstado(panelEstado) {
		document.getElementById("estado").style.visibility = "hidden";
	}
		
	window.onload = function () {

		document.forma.onsubmit = function () {
				
			// Validación individual
			if (document.forma.usuario.value == "") {
				alert("Debe proporcionar el nombre de usuario.");
				document.forma.usuario.focus();
				return false;
			}
		}
	
		document.forma.usuario.value = "<?php echo $usuario; ?>";
	
		if (estado != "") {
			panelEstado = document.getElementById("estado");
			panelEstado.innerHTML = estado;
			panelEstado.style.visibility = "visible";
			setTimeout(ocultarPanelEstado, 3000);
		}
	
	}
	
	</script>
	
</head>
<body>
<h1>Iniciar sesión</h1>
<div id="estado">Mensaje</div>
<form action="validar.php" method="get" name="forma">
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
</body>
</html>
