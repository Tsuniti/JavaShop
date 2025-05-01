function validatePasswords() {
	const pw1 = document.getElementById('password').value
	const pw2 = document.getElementById('passwordRepeat').value
	const error = document.getElementById('error-message')

	if (pw1 !== pw2) {
		error.style.display = 'block'
		return false
	} else {
		error.style.display = 'none'
		return true
	}
}
