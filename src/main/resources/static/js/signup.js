document.getElementById("signupForm").addEventListener("submit", async function(e) {
    e.preventDefault();

    const user = {
        username: document.getElementById("username").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    };

    try {
        const response = await fetch("/users/signup", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(user)
        });

        if (response.ok) {
            document.getElementById("message").innerText = "Signup successful! Redirecting...";
            setTimeout(() => window.location.href = "/signin", 1500);
        } else {
            document.getElementById("message").innerText = "Signup failed!";
        }
    } catch (err) {
        document.getElementById("message").innerText = "Error: " + err.message;
    }
});
