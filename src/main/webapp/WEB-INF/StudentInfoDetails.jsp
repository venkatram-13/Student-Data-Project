<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Student Details</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        .btn {
            padding: 5px 10px;
            text-decoration: none;
            color: white;
            background-color: #007bff; /* Default blue color for Update button */
            border-radius: 3px;
        }

        .btn-danger {
            background-color: #dc3545; /* Red color for Delete button */
        }

        .btn:hover {
            opacity: 0.8; /* Slight hover effect */
        }
    </style>
</head>
<body>
    <h2>Student Details</h2>
    <table>
        <tr>
            <th>Registered No</th>
            <th>Student Name</th>
            <th>DOB</th>
            <th>Gender</th>
            <th>Branch</th>
            <th>Year</th>
            <th>Semester</th>
            <th>College Name</th>
            <th>Action</th>
        </tr>
        
        <c:forEach var="student" items="${studentDetails}">
            <tr>
                <td>${student.registeredNo}</td>
                <td>${student.studentName}</td>
                <td>${student.DOB}</td>
                <td>${student.gender}</td>
                <td>${student.branch}</td>
                <td>${student.year}</td>
                <td>${student.semester}</td>
                <td>${student.collegeName}</td>
                <td>
                    <a href="ServletController?updateRegNo=${student.registeredNo}" class="btn">Update</a>
                    <a href="ServletController?deleteRegNo=${student.registeredNo}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
