 let welcome = document.getElementById('welcome');
 
 var userString = sessionStorage.getItem('currentUser');
 
 if (userString === null) {
	 window.location = "http://localhost:8080/EmployeeServlets/";
 } else {
	 var currentUser = JSON.parse(userString);
	 console.log(currentUser);
	 
	 if (currentUser != null) {
		 welcome.innerHTML = currentUser.firstName + ", please complete the form below to update your information";
	 }
 }
 
  function updateInfo() {
 


 	let username = document.getElementById('uName').value;
 	let password = document.getElementById('pWord').value;
 	let firstName = document.getElementById('fName').value;
 	let lastName = document.getElementById('lName').value;
 	let email = document.getElementById('eId').value;
 	
 
 
   let update = {
 	username : username,
	password : password,
	firstName : firstName,
 	lastName : lastName,  
 	email : email,
 	id  : currentUser.id
 	
	}
	
	console.log(update)
 
 let xhr = new XMLHttpRequest();
 xhr.onreadystatechange = function() {
    if (this.readyState === 4 && this.status===200) {
        console.log("success");

        window.location= "http://localhost:8080/MoneyBack/employeeinfo.html";

    }
    if (this.readyState === 4 && this.status === 204) { //204 means no content found but connection made
            console.log("failed to find user")
    }

    let childDiv = document.getElementById(`warningText`);
    childDiv.textContent = "Failed to login! Username of Password is incorrect"


}

//3. xhr.open("POST, "wherever out login servlet is located, http:/localhost:8080/EmployeeDBServlets/url for the loginServlet")

xhr.open("POST", "http://localhost:8080/MoneyBack/updateinfo")

//4. xhr.send();
 xhr.send(JSON.stringify(update))
 
 
 
 }
 
 
 
 