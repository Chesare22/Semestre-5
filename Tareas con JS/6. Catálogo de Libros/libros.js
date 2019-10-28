const libros = window.localStorage.books ? JSON.parse(window.localStorage.books) : []

function Libro (titulo, autor, editorial) {
  this.titulo = titulo
  this.autor = autor
  this.editorial = editorial

  this.escribirLibro = () => {
    alert(`El libro ${this.titulo} de ${this.autor} trata sobre ${this.tema}`)
  }

  this.urlParams = function urlParams () {
    return `titulo=${this.titulo}
      &autor=${this.autor}
      &editorial=${this.editorial}`
  }
}

window.onload = () => {
  const forma = document.getElementById('forma')
  forma.agregar.addEventListener('click', () => {
    const { titulo, autor, editorial } = forma
  
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
  
    libros.push(new Libro(titulo.value, autor.value, editorial.value))
  
    titulo.value = ''
    autor.value = ''
    editorial.value = ''
  
    window.localStorage.setItem('books', JSON.stringify(libros))
    // window.open('catalog_table.html', 'catalog_table')
  })
}
