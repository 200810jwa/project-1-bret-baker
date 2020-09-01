// manager dashboard - view all reimbursements
document.getElementById("view-all-reimb-btn").addEventListener("click", (e) => {
	e.preventDefault();
	document.getElementById("man-header").innerHTML = "Reimbursements";
	document.getElementById("man-header").classList.remove("mb-4");
	document.getElementById("man-header").classList.add("mb-0");
	document.getElementById("view-all-reimb-btn").style.display = "none";
	document.getElementById("reimb-table-m").style.display = "table";
});

