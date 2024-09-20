<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Student Details</title>
</head>
<body>
    <h2>Student Details</h2>
    <table border="1">
        <tr>
            <th>Registered No</th>
            <th>Student Name</th>
            <th>DOB</th>
            <th>Gender</th>
            <th>Branch</th>
            <th>Year</th>
            <th>Semester</th>
            <th>College Name</th>
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
            </tr>
        </c:forEach>
    </table>
</body>
</html>
