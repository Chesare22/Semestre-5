<?php

function EjecutarSQL ($sentenciaSQL){
    
    $conexion = getDBConnection();
    if (!$conexion) {
        die("Fallo: " . mysqli_connect_error());//Die es igual al exit
    }

    $resultado = mysqli_query($conexion, $sentenciaSQL);
    mysqli_close($conexion);
};

function ConsultaSQL ($sentenciaSQL){
    
    $conexion = getDBConnection();
	if (!$conexion) {
    	die("Fallo: " . mysqli_connect_error());
	}

    $resultado = mysqli_query($conexion, $sentenciaSQL);
    
	for ($registros = array (); $fila = mysqli_fetch_assoc($resultado); $registros[] = $fila);
	mysqli_close($conexion);
	return $registros;
};

function getDBConnection(){
    $jsonStr = file_get_contents("config.json");
    $config = json_decode($jsonStr);
    $connection = mysqli_connect(
        $config->database->host, 
        $config->database->user, 
        $config->database->password,
        $config->database->dbname
        );
    return $connection;
}


?>