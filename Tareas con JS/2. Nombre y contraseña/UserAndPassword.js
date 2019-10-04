function closeInvalidInputMessage () {
  const errorMessage = document.getElementById('invalid-input-message')
  errorMessage.style.visibility = 'hidden'
}

function validateForm (form) {
  if (!form.name.value) {
    showInvalidInputMessage('El nombre no puede ser vacío')
    return false
  }
  if (!isPasswordCorrect(form)) {
    showInvalidInputMessage('La contraseñas no coinciden o son inválidas')
    return false
  }
  return true
}

function showInvalidInputMessage (message) {
  const errorMessage = document.getElementById('invalid-input-message')
  errorMessage.style.visibility = 'visible'

  errorMessage.children[0].innerText = message
}

function isPasswordCorrect ({password, confirmation}) {
  return (password.value === confirmation.value) && password.value
}