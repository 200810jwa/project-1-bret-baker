// employee dashboard - view past tickets
document.getElementById("view-past-tickets-btn").addEventListener("click", (e) => {
	e.preventDefault();
	document.getElementById("emp-header").innerHTML = "Past Tickets";
	document.getElementById("emp-header").classList.remove("mb-4");
	document.getElementById("emp-header").classList.add("mb-0");
	document.getElementById("view-past-tickets-btn").style.display = "none";
	document.getElementById("add-reimb-request-btn").style.display = "none";
	document.getElementById("reimb-table-e").style.display = "table";
});

// employee dashboard - add reimbursement request
document.getElementById("add-reimb-request-btn").addEventListener("click", (e) => {
	e.preventDefault();
	document.getElementById("emp-header").innerHTML = "Add Reimbursement Request";
	// document.getElementById("emp-header").classList.remove("mb-4");
	// document.getElementById("emp-header").classList.add("mb-0");
	document.getElementById("view-past-tickets-btn").style.display = "none";
	document.getElementById("add-reimb-request-btn").style.display = "none";
	document.getElementById("add-reimb-request-form").style.display = "block";
});