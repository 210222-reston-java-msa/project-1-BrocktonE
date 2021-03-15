 let welcome = document.getElementById('welcome');
 
 var userString = sessionStorage.getItem('currentUser');
 
 if (userString === null) {
	 window.location = "http://localhost:8080/EmployeeServlets/";
 } else {
	 var currentUser = JSON.parse(userString);
	 console.log(currentUser);
	 
	 if (currentUser != null) {
		 welcome.innerHTML = currentUser.firstName + ", click below to view all Employee Info and a list of there requests";
	 }
 }

function findallemployees() {

		var table = document.getElementById("myTable");

	
  let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
    if (this.readyState === 4 && this.status===200) {
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
		td.innerHTML = obj.firstName;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.lastName;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.eMail;
		
		let button = document.createElement("button");
		button.setType = "submit"
		button.innerHTML = "Get Requests"
		button.setAttribute("onclick", `viewR(${obj.id})`)
		tr.appendChild(button);
		
		
		});

	  
		}
		
	}
	 xhr.open("GET", "http://localhost:8080/MoneyBack/viewallemployees")
	       xhr.send();
	
	}
	
	
	
	function viewR(id) {
	
	console.log(id);

	
document.getElementBy
	let nid = {
		aid: id,
		
	}

	console.log(nid);
	console.log("hello Resolved");
	
	var table = document.getElementById("myTable1");
	
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function () {
		if (this.readyState === 4 && this.status === 200) {
			console.log("success");

			let myObj = JSON.parse(xhr.responseText)
			console.log(myObj);

document.getElementById("myTable1").innerHTML = "";
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
	xhr.open("POST", "http://localhost:8080/MoneyBack/viewallrequests")
	xhr.send(JSON.stringify(nid));
	

}
	
	