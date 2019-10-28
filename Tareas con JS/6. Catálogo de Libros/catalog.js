window.onload = () => {
  const tabla = document.getElementById('tabla')
  const fila = document.createElement('tr')
  fila.innerHTML = '<td>probando </td><td>el</td><td>texto</td>'
  tabla.appendChild(fila)
}