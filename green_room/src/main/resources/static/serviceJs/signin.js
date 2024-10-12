document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Ngăn form tự động submit

    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    let requestData = {
        "email": email,
        "password": password
    };


    fetch("http://localhost:8080/login/signin", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(requestData),
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        if (data.success === true) {
            localStorage.setItem("token", data.data);
            console.log("login success");
            window.location = "../templates/home.html";
           
        } else {
            console.log("login failed");
        }
    })
    .catch(error => console.error("Error:", error));
});
