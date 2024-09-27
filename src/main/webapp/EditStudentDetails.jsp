<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration Form</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f5f5f5; /* Light grey background for the webpage */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .card {
            background: linear-gradient(135deg, #4a90e2, #003d99); /* Gradient background for the card */
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.2);
            width: 500px;
            padding: 20px;
            box-sizing: border-box;
        }
        .card h2 {
            margin-top: 0;
            margin-bottom: 20px;
            color: white;
            text-align: center;
        }
        .form-group {
            display: flex;
            margin-bottom: 15px;
            align-items: center;
        }
        .form-group label {
            flex: 1;
            margin-right: 10px;
            color: white;
            text-align: left;
        }
        .form-group input,
        .form-group select {
            flex: 2;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-group input[type="submit"],
        .form-group input[type="reset"] {
            background: #009688;
            color: white;
            border: none;
            cursor: pointer;
            text-align: center;
            margin-right: 10px;
            width: 48%;
        }
        .form-group input[type="submit"]:hover,
        .form-group input[type="reset"]:hover {
            background: #00796b;
        }
        .form-group .reset-button {
            background: #f44336; /* Red background for reset button */
        }
        .form-group .reset-button:hover {
            background: #c62828; /* Darker red for hover effect */
        }
        .two-columns {
            display: flex;
            justify-content: space-between;
        }
        .two-columns > div {
            flex: 1;
            margin-right: 10px;
        }
        .two-columns > div:last-child {
            margin-right: 0;
        }
    </style>
</head>
<body>
    <div class="card">
        <h2>Student Registration</h2>
        <form action="ServletController" method="get">
            <div class="form-group">
                <label for="regNo">Registered No:</label>
                <input type="text" id="regNo" name="regNo"  value = "${Student.registeredNo}"required>
            </div>
            <div class="form-group">
                <label for="name">Student Name:</label>
                <input type="text" id="name" name="name" value="${Student.studentName}" required>
            </div>
            <div class="form-group">
                <label for="dob">DOB:</label>
                <input type="date" id="dob" name="dob" value="${Student.DOB}"required>
            </div>
            <div class="form-group">
                <label for="gender">Gender:</label>
                <select id="gender" name="gender" required>
                	<c:if test="${not empty Student.gender }">
                		<option value="${Student.gender}" >${Student.gender}</option>
                	</c:if>
                	<c:if test="${empty Student.gender }">
                    <option value="" disabled selected>Select your gender</option>
                    </c:if>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                    <option value="other">Other</option>
                </select>
            </div>
            <div class="form-group">
                <label for="branch">Branch:</label>
                <input type="text" id="branch" name="branch" value="${Student.branch}" required>
            </div>
            <div class="form-group two-columns">
                <div>
                    <label for="year">Year:</label>
                    <select id="year" name="year" required>
                    <c:if test="${not empty Student.year }">
                		<option value="${Student.year}" >${Student.year}</option>
                	</c:if>
                	<c:if test="${empty Student.year }">
                    <option value="" disabled selected>Select year</option>
                    </c:if>
                        
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                </div>
                <div>
                    <label for="semester">Semester:</label>
                    <select id="semester" name="semester" required>
                    	 <c:if test="${not empty Student.semester }">
                		<option value="${Student.semester}" >${Student.semester}</option>
                	</c:if>
                	<c:if test="${empty Student.semester }">
                    <option value="" disabled selected>Select semester</option>
                    </c:if>
                        
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
                </div>
            </div>
            <div class="form-group">
                <label for="collegeName">College Name:</label>
                <input type="text" id="collegeName" name="collegeName" value="${Student.collegeName}"required>
            </div>
            <div class="form-group">
                <input type="submit" value="Edit" name="edit">
                <input type="reset" value="Reset" class="reset-button">
            </div>
        </form>
    </div>
</body>
</html>
    