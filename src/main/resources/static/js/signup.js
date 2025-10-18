document.getElementById('signupForm').addEventListener('submit', async function(e) {
    e.preventDefault(); // Prevent default form submission

    const formData = {
        username: document.getElementById('username').value,
        email: document.getElementById('email').value,
        password: document.getElementById('password').value
    };

    try {
        const response = await fetch('/signup', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        });

        const result = await response.json();

        if (response.ok) {
            document.getElementById('message').innerHTML =
                '<p style="color: green;">Sign up successful! <a href="/login">Login here</a></p>';
            document.getElementById('signupForm').reset();
        } else {
            document.getElementById('message').innerHTML =
                `<p style="color: red;">Error: ${result.message || 'Sign up failed'}</p>`;
        }
    } catch (error) {
        document.getElementById('message').innerHTML =
            '<p style="color: red;">Network error. Please try again.</p>';
    }
});