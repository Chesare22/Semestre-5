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

function ajax (params) {
  const xmlhttp = new XMLHttpRequest()
  xmlhttp.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
      document.location = 'menu.php'
    }
  }
  xmlhttp.open('get', `saveUser.php?${params}`, true)
  xmlhttp.send()
}

formulario.onsubmit = () => {
  event.preventDefault()
  const {
    usuario: {
      value: user
    },
    nombre: {
      value: name
    },
    rol: {
      value: role
    },
  } = formulario
  const id = new URL(window.location).searchParams.get('id')
  const params = `user=${user}&name=${name}&role=${role}&id=${id}`
  ajax(params)
}
</script>