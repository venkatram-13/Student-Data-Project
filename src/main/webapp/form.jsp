<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background-color: #2a68af;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 350px;
        }

        .registration-form {
            display: flex;
            flex-direction: column;
        }

        .registration-form h2 {
            text-align: center;
            color: #ffffff;
            margin-bottom: 20px;
        }

        .registration-form label {
            color: #ffffff;
            margin-bottom: 5px;
            font-size: 14px;
        }

        .registration-form input, 
        .registration-form select {
            padding: 8px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ddd;
            font-size: 14px;
        }

        .registration-form input:focus, 
        .registration-form select:focus {
            outline: none;
            border-color: #007bff;
        }

        .form-buttons {
            display: flex;
            justify-content: space-between;
        }

        .form-buttons button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
        }

        .form-buttons button[type="submit"] {
            background-color: #28a745;
            color: #fff;
        }

        .form-buttons button[type="reset"] {
            background-color: #17a2b8;
            color: #fff;
        }
    </style>
</head>
<body>
    <div class="container">
        <form class="registration-form" action = "StudentDetailsServlet" method="post">
            <h2>Student Registration</h2>
            <label for="registered-no">Registered No:</label>
            <input type="text" id="registered-no" name="regno" required>

            <label for="student-name">Student Name:</label>
            <input type="text" id="student-name" name="name" required>

            <label for="dob">DOB:</label>
            <input type="date" id="dob" name="dob" required>

            <label for="gender">Gender:</label>
            <select id="gender" name="gender" required>
                <option value="">Select your gender</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select>

            <label for="branch">Branch:</label>
            <input type="text" id="branch" name="branch" required>

            <label for="year">Year:</label>
            <select id="year" name="year" required>
                <option value="">Select year</option>
                <option value="1">1st Year</option>
                <option value="2">2nd Year</option>
                <option value="3">3rd Year</option>
                <option value="4">4th Year</option>
            </select>

            <label for="semester">Semester:</label>
            <select id="semester" name="semester" required>
                <option value="">Select semester</option>
                <option value="1">1st Semester</option>
                <option value="2">2nd Semester</option>
                <option value="3">3rd Semester</option>
                <option value="4">4th Semester</option>
                <option value="5">5th Semester</option>
                <option value="6">6th Semester</option>
                <option value="7">7th Semester</option>
                <option value="8">8th Semester</option>
            </select>

            <label for="college-name">College Name:</label>
            <input type="text" id="college-name" name="collegeName" required>

            <div class="form-buttons">
                <button type="submit">Submit</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </div>
</body>
</html>
