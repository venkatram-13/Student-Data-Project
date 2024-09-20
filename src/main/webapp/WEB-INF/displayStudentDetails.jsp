<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
        }
        h1 {
            text-align: center;
        }
        table {
            width: 50%;
            margin: 0 auto;
            border-collapse: collapse;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        caption {
            font-size: 1.5em;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <h1>Student Details</h1>
    <table>
        <caption>Details of the Registered Student</caption>
        <tr>
            <th>Registered No</th>
            <td>${registeredNo}</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>${studentName}</td>
        </tr>
        <tr>
            <th>Date of Birth</th>
            <td>${DOB}</td>
        </tr>
        <tr>
            <th>Gender</th>
            <td>${gender}</td>
        </tr>
        <tr>
            <th>Branch</th>
            <td>${branch}</td>
        </tr>
        <tr>
            <th>Year</th>
            <td>${year}</td>
        </tr>
        <tr>
            <th>Semester</th>
            <td>${semester}</td>
        </tr>
        <tr>
            <th>College Name</th>
            <td>${collegeName}</td>
        </tr>
    </table>
</body>
</html>
