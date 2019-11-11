<?php

include "funciones.php";

//Respuesta
$ok = true; //Se asume que es correcto el inicio de sesion
$mensaje = "";

$conexion = getDBConnection();
if (!$conexion) {
    die("Fallo: " . mysqli_connect_error());//Die es igual al exit
}
$sql = "SELECT usuario FROM usuarios WHERE usuario = '{$_POST['usuario']}'";

$resultado = mysqli_query($conexion, $sql);
if (mysqli_num_rows($resultado) === 0) {
    if($_POST['contrasena'] === $_POST['contrasenaRepetir']){
        $mensaje = "index.php";
        $sql = "INSERT INTO usuarios (usuario,contrasena,nombre) VALUES ('{$_POST['usuario']}', '{$_POST['contrasena']}', '{$_POST['nombre']}')";
        EjecutarSQL($sql);
    }else{
        $ok = false;
	    $mensaje = "Los campos de contraseñas deben coincidr";
    } 
} else {
	$ok = false;
	$mensaje = "Usuario ya existente"; 
}

mysqli_close($conexion);

//Se envia la respuesta
echo json_encode(
	array(
		'ok' => $ok,
		'mensaje' => $mensaje
	)
);
?>