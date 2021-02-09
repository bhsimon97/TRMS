var loggedInUser = null;



function isUserLoggedIn(){
    if(loggedInUser != null){
        document.getElementById("signupHeader").innerHTML = "Log Out";
        document.getElementById("signupHeader").href = "/logout.html";

        document.getElementById("loginHeader").innerHTML = "My Account";
        document.getElementById("loginHeader").href = "/account.html";
    }
}
