<html>
<body>
<?php

echo "<pre>";
print_r ($_REQUEST);
echo "</pre>";

// sanitizar.php?codigo=<img src="http://www.matematicas.uady.mx/static/images/avisos/2017/talleres/Aviso-workshop-technology-internship-2017.jpg">

echo $_REQUEST["codigo"];
echo "<p>";


//Evitar cross scripting - sustituir caraceres por equivalentes en HTML
echo htmlentities($_REQUEST["codigo"], ENT_QUOTES);
echo "<p>";

//Evitar cross scripting - eliminar etiquetas HTML
echo strip_tags($_REQUEST["codigo"]);
echo "<p>";

// sanitizar.php?id_usuario=1;select * from usuarios
 
$sentenciaSQL = "SELECT * FROM usuarios WHERE id_usuario = " . $_REQUEST["id_usuario"] ;

echo "<pre>" . $SQL . "</pre>";

echo "<pre>" . addslashes($SQL) . "</pre>";

?>
</body>
</html>