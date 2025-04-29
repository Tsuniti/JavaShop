console.log('user-update')

const forms = document.querySelectorAll('#form-container form')

forms.forEach(function (form) {
	form.addEventListener('submit', function (event) {
		event.preventDefault()
		userUpdate(form)
	})
})

function userUpdate(form) {
	let formData = new FormData(form)
	let json = JSON.stringify(Object.fromEntries(formData))
	console.log(json)
	//Отримання CSRF токену
	console.log('Отримання CSRF токену\n', formData.get('_csrf'))
	//
	fetch('/rest/user-update-form', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
			'X-CSRF-Token': formData.get('_csrf'),
		},
		body: json,
	})
		.then(data => {
			console.log(data)
			if (data.ok) alert('Saved!')
			else alert('Error')
		})
		.catch(error => {
			console.log(error)
		})
}
