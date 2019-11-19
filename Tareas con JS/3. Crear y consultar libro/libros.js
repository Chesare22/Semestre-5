/* exported agregarLibro imprimirLibros */

const libros = []

function Libro (titulo, autor, editorial, tema) {
  this.titulo = titulo.toUpperCase()
  this.autor = autor
  this.editorial = editorial
  this.tema = tema.toLowerCase()

  this.escribirLibro = function escribirLibro () {
    alert(`El libro ${this.titulo} de ${this.autor} trata sobre ${this.tema}`)
  }

  this.urlParams = function urlParams () {
    return `titulo=${this.titulo}
      &autor=${this.autor}
      &editorial=${this.editorial}
      &tema=${this.tema}`
  }
}

function agregarLibro ({ titulo, autor, editorial, tema }) {
  if (!titulo.value) {
    alert('Debes escribir el título')
    titulo.focus()
    return false
  }
  if (!autor.value) {
    alert('Debes escribir el autor')
    autor.focus()
    return false
  }
  if (!editorial.value) {
    alert('Debes escribir la editorial')
    editorial.focus()
    return false
  }
  if (!tema.value) {
    alert('Debes escribir el tema')
    tema.focus()
    return false
  }

  libros.push(new Libro(titulo.value, autor.value, editorial.value, tema.value))

  titulo.value = ''
  autor.value = ''
  editorial.value = ''
  tema.value = ''

  return true
}

function imprimirLibros () {
  let offset = 5
  libros.forEach(libro => {
    offset += 15
    window.open(`new-window.html?${libro.urlParams()}`,
      '',
      `width=270,height=240,left=${offset},top=${offset}`)
  })
}
