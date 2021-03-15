

let welcome = document.getElementById('welcome');

var userString = sessionStorage.getItem('currentUser');
console.log("test");
console.log(userString);

if (userString === null) {
	window.location = "http://localhost:8080/EmployeeServlets/";
} else {
	var currentUser = JSON.parse(userString);
	console.log(currentUser);

	if (currentUser != null) {
		welcome.innerHTML = "Welcome " + currentUser.firstName + " " + currentUser.lastName + " , please make a selection to view a history of your Requests";
	}
}

function populateTable() {
document.getElementBy
	let nid = {
		aid: currentUser.id,
		
	}

	console.log(nid);


	var table = document.getElementById("myTable");
	


	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function () {
		if (this.readyState === 4 && this.status === 200) {
			console.log("success");

			let myObj = JSON.parse(xhr.responseText)
			console.log(myObj);

document.getElementById("myTable").innerHTML = "";
			myObj.forEach((obj) => {
				
				let tr = document.createElement("tr");
				table.appendChild(tr);

				let td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.id;

				td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.amount;
				
				 td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.submitted;
		
				 td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.resolved;

				td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.description;

				td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.author;

				td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.resolver;


				td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.status;

				td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.type;


			});


		}

	}
	xhr.open("POST", "http://localhost:8080/MoneyBack/viewinfo")
	xhr.send(JSON.stringify(nid));
	

}


function populateTableResolved() {
document.getElementBy
	let nid = {
		aid: currentUser.id,
		
	}

	console.log(nid);
	console.log("hello Resolved");


	var table = document.getElementById("myTable");
	


	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function () {
		if (this.readyState === 4 && this.status === 200) {
			console.log("success");

			let myObj = JSON.parse(xhr.responseText)
			console.log(myObj);

document.getElementById("myTable").innerHTML = "";
			myObj.forEach((obj) => {
				
				let tr = document.createElement("tr");
				table.appendChild(tr);

				let td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.id;

				td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.amount;
				
				td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.submitted;
		
				 td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.resolved;

				td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.description;

				td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.author;

				td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.resolver;


				td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.status;

				td = document.createElement("td");
				tr.appendChild(td);
				td.innerHTML = obj.type;


			});


		}

	}
	xhr.open("POST", "http://localhost:8080/MoneyBack/viewinforesolved")
	xhr.send(JSON.stringify(nid));
	

}
