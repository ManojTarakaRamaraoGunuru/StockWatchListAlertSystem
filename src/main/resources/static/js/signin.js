document.getElementById("signinForm").addEventListener("submit", async function(e) {
    e.preventDefault();

    const user = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    };

    try {
        const response = await fetch("/users/signin", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(user)
        });

        if (response.ok) {
            const data = await response.json();
            document.getElementById("message").innerText = "Welcome, " + data.username + "!";
            setTimeout(() => window.location.href = "/homepage", 1500);
        } else {
            document.getElementById("message").innerText = "Invalid credentials!";
        }
    } catch (err) {
        document.getElementById("message").innerText = "Error: " + err.message;
    }
});
