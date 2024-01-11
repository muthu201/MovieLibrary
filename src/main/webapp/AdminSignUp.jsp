<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Information Form</title>
    <style>
    body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    padding: 20px;
}

h2 {
    text-align: center;
}

.form-group {
    margin-bottom: 15px;
}

label {
    font-weight: bold;
}

input[type="text"],
input[type="email"],
input[type="password"] {
    width: 100%;
    padding: 10px;
    margin: 5px 0;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 15px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #45a049;
}
    </style>
</head>
<body>
    <h2>Admin Information Form</h2>
    <form action="saveAdminInfo" method="post">
        <div class="form-group">
            <label for="adminId">Admin ID:</label>
            <input type="text" id="adminId" name="adminId" required>
        </div>
        <div class="form-group">
            <label for="adminName">Admin Name:</label>
            <input type="text" id="adminName" name="adminName" required>
        </div>
        <div class="form-group">
            <label for="adminContact">Admin Contact:</label>
            <input type="text" id="adminContact" name="adminContact" required>
        </div>
        <div class="form-group">
            <label for="adminEmail">Admin Email:</label>
            <input type="email" id="adminEmail" name="adminEmail" required>
        </div>
        <div class="form-group">
            <label for="adminPassword">Admin Password:</label>
            <input type="password" id="adminPassword" name="adminPassword" required>
        </div>
        <div class="form-group">
            <input type="submit" value="Submit">
        </div>
    </form>
</body>
</html>