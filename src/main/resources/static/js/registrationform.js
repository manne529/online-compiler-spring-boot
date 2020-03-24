function regFormSubmission() {
	let regForm = document.forms['regform'];
	let elements = regForm.elements;

	elements['fullname'].value = elements['fullname'].value.toLowerCase();
	elements['username'].value = elements['username'].value.toLowerCase();

	regForm.submit();
}