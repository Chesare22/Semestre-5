<?php
include 'funciones.php';

//Respuesta
$ok = true; //Se asume que es correcto el inicio de sesion
$mensaje = "";

$conexion = getDBConnection();
if (!$conexion) {
    die("Fallo: " . mysqli_connect_error());//Die es igual al exit
}

//Completar la sentencia SQL
$sql = "SELECT usuario, contrasena FROM usuarios WHERE usuario = '{$_GET['usuario']}' AND contrasena = '{$_GET['contrasena']}' ";

$resultado = mysqli_query($conexion, $sql);
mysqli_close($conexion);

if (mysqli_num_rows($resultado) > 0) {
	//Si hay registro reenviar a la página menu.php
	$mensaje = "menu.php"; 
} else {
	$ok = false;
	$mensaje = "Usuario o contraseña incorrecta"; 
}

//Se envia la respuesta
echo json_encode(
	array(
		'ok' => $ok,
		'mensaje' => $mensaje
	)
);

?>