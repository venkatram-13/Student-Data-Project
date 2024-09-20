<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Portal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            max-width: 500px;
            padding: 20px;
            text-align: center;
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
            font-size: 2em;
        }
        button {
            background-color: #007bff;
            border: none;
            color: #fff;
            padding: 15px 25px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            margin: 10px;
            transition: background-color 0.3s, transform 0.3s;
        }
        button:hover {
            background-color: #0056b3;
            transform: translateY(-2px);
        }
        button:active {
            transform: translateY(1px);
        }
        .button-container {
            display: flex;
            justify-content: center;
            flex-direction: column;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Student Portal</h1>
        <div class="button-container">
        	<form action = "ServletController" method="get">
        		<input type="hidden" name="display" value="yes">
        		<button type="submit">Student Details</button>
        	</form>
            <form action="form.jsp" method="get">
                <button type="submit">Add New Student Details</button>
            </form>
        </div>
    </div>
</body>
</html>