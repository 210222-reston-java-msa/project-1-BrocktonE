 let welcome = document.getElementById('welcome');
 
 var userString = sessionStorage.getItem('currentUser');
 
 if (userString === null) {
	 window.location = "http://localhost:8080/EmployeeServlets/";
 } else {
	 var currentUser = JSON.parse(userString);
	 console.log(currentUser);
	 
	 if (currentUser != null) {
		 welcome.innerHTML = "Welcome " + currentUser.firstName + " " + currentUser.lastName + " , to the Employee Home Page";
	 }
 }
 function logout() {
	 
	 let xhr = new XMLHttpRequest();
	 xhr.open("POST", "http://localhost:8080/MoneyBack/logout");
	 xhr.send();
	 
	 sessionStorage.removeItem('currentUser');
	 window.location = "http://localhost:8080/MoneyBack/";
	 
 }
 
 
 
 function request() {
 
 window.location= "http://localhost:8080/MoneyBack/request.html";
 }


 function viewrequests() {
 
 window.location= "http://localhost:8080/MoneyBack/viewinfo.html";
 }
 
 function updateemployeeinfo() {
 window.location= "http://localhost:8080/MoneyBack/employeeinfo.html";
 }
 
 function viewallinfo() {
  window.location= "http://localhost:8080/MoneyBack/seeuserinfo.html";
 }
 
 
 
 
 
 