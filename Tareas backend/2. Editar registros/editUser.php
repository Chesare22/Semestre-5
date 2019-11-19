<?php
include 'funciones.php';

function printTable(){
  $sql = "SELECT usuario, nombre, rol FROM usuarios WHERE id = {$_GET['id']}";
  $user = consultaSQL($sql)[0]; // Usuario a editar
  echo "<table class=\"collapsed\">\n" .
      "<tr><th>Usuario</th><th>Nombre</th><th>Rol</th></tr>\n" .
      "<tr>" .
        "<td><input name=\"usuario\" type=\"text\" value=\"{$user['usuario']}\"></td>" .
        "<td><input name=\"nombre\" type=\"text\" value=\"{$user['nombre']}\"></td>" .
        "<td><input name=\"rol\" type=\"number\" value=\"{$user['rol']}\"></td>" .
      "</tr></table>";
}
?>
<style>
  table.collapsed {
    border-collapse: collapse;
  }
  table.collapsed, th, td {
    border: 1px solid black;
  }
</style>

<form name="formulario">
	<?php printTable();?>
	<input type="submit" value="Guardar cambios" name="save">
</form>

<script>
/* global formulario */
formulario.onsubmit = () => {
  event.preventDefault()
  const { usuario, nombre, rol } = formulario
  console.log(`${usuario}  ${nombre}  ${rol}`)
}
</script>