function swap (array, x, y) {
  const helper = array[x]
  array[x] = array[y]
  array[y] = helper
}

function sortArrayByProp (array, prop, descendent) {
  if (!array[0].hasOwnProperty(prop)) {
    return array
  }
  for (let i = 0; i < array.length; i++) {
    let minRow = array[i]
    let minIndex = i
    for (let j = i + 1; j < array.length; j++) {
      const element = array[j]
      if (element[prop].toLowerCase() < minRow[prop].toLowerCase()) {
        minRow = element
        minIndex = j
      }
    }
    swap(array, i, minIndex)
  }
  return descendent ? array.reverse() : array
}

const isDescendent = window.localStorage.descendent ? JSON.parse(window.localStorage.descendent) : false

function buttonPressed (sortingMethod) {
  if (window.localStorage.sortingMethod === sortingMethod) {
    window.localStorage.setItem('descendent', !isDescendent)
  }
  else {
    window.localStorage.setItem('descendent', false)
    window.localStorage.setItem('sortingMethod', sortingMethod)
  }
  window.location = 'catalog_table.html'
}

window.onload = () => {
  const tabla = document.getElementById('tabla')
  const libros = JSON.parse(window.localStorage.books)
  console.log('Sorting method: ', window.localStorage.sortingMethod)
  console.log('Is descendent: ', isDescendent)
  const sortedBooks = sortArrayByProp(libros, window.localStorage.sortingMethod, isDescendent)
  for ( let i = 0; i < sortedBooks.length; i++) {
    let { titulo, autor, editorial } = sortedBooks[i]
    const fila = document.createElement('tr')
    fila.innerHTML = `<td>${titulo}</td><td>${autor}</td><td>${editorial}</td>`
    tabla.appendChild(fila)
  }
  // Añadir event-listeners a cada celda de la primera fila
  tabla.rows[0].cells[0].addEventListener('click', () => { buttonPressed('titulo') })
  tabla.rows[0].cells[1].addEventListener('click', () => { buttonPressed('autor') })
  tabla.rows[0].cells[2].addEventListener('click', () => { buttonPressed('editorial') })
}