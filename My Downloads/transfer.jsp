<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Deposit Amount</title>
    <style>
    	body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

header {
    background-color: #4CAF50;
    color: white;
    text-align: center;
    padding: 1em;
}

section {
    max-width: 400px;
    margin: 20px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 8px;
}

form {
    display: flex;
    flex-direction: column;
}

label {
    margin-bottom: 8px;
}

input {
    padding: 8px;
    margin-bottom: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #45a049;
}

footer {
    text-align: center;
    margin-top: 20px;
}

    	
    </style>
</head>
<body>

    <header>
        <h1>Transfer Amount</h1>
    </header>

    <section>
        <form action="admin?action=transfer" method="post">
            <label for="senderAccountNo">Sender Account Number:</label>
            <input type="text" id="senderAccountNo" name="senderAccountNo" required><br>

            <label for="receiverAccountNo">Receiver AccountNumber:</label>
            <input type="text" id="receiverAccountNo" name="receiverAccountNo" required><br>
            
            <label for="transferAmount">Transfer Amount:</label>
            <input type="number" id="transferAmount" name="transferAmount" required><br>

            <button type="submit">Submit</button>
        </form>
    </section>

    <footer>
        <button onclick="redirectForm()">Back</button>
    </footer>

	<script>
	function redirectForm(){
		window.location.href = "admin-dashboard.jsp";
	}
</script>
</body>
</html>