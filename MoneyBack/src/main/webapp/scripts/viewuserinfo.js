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
		 welcome.innerHTML = currentUser.firstName + ", press the button to view your information";
	 }
 }



function buildTable() {
		document.getElementBy
		let nid = {
		aid: currentUser.id,
		
		}
		
		console.log(nid);


		var table = document.getElementById("myTable");

	
  let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
    if (this.readyState === 4 && this.status===200) {
        console.log("success");

	   let myObj = JSON.parse(xhr.responseText)
	   console.log(myObj);
	   
	   
	
	
	let tr = document.createElement("tr");
	table.appendChild(tr);
	
		let td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = myObj.id;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = myObj.username;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = myObj.password;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = myObj.firstName;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = myObj.lastName;
		
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = myObj.eMail;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = myObj.userRole;
		
		
		

	  
		}
		
	}
	 xhr.open("POST", "http://localhost:8080/MoneyBack/viewemployeeinfo")
	       xhr.send(JSON.stringify(nid));
	
	}
	