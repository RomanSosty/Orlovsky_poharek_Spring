var form = document.getElementById("loginForm");

form.addEventListener("submit", function (event) {
    event.preventDefault();
    validateLoginForm();
});

function validateLoginForm(){
    const login = document.getElementById("login").value;
    const rawPassword = document.getElementById("password").value;
    let password = hashPassword(rawPassword)

    const user = {
        login: login,
        password: password
    };

    localStorage.setItem("Password: ", password);
    fetch('/JAT_war_exploded/loginPage', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user),
        })
            .then(response => response.json())
            .then(data => console.log(data))
            .catch(error => console.log(error));
}

function hashPassword(password) {
    return sha256(password);
}