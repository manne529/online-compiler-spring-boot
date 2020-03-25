let testcaseDiv = document.getElementById("testcasediv");
testcaseDiv.style.display = "none";

function testcaseDivToggle() {
	if (document.getElementById("testcasespresent").checked) {
		testcaseDiv.style.display = "block";
	} else {
		testcaseDiv.style.display = "none";
	}
}