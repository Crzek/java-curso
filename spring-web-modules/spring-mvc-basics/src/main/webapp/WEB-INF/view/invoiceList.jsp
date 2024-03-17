<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Form Example - Register an Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/static/css/styles.css">
    <Style>
        body {
            margin:1em
        }
        .error {
            color: red;
        }
        table * {
            border: 1px solid black;
            color: black;
        }
    </Style>

</head>
<body>
	<h3>Lista de Facturas</h3>
	<a href="/spring-mvc-basics/invoice">Registrar Factura</a>

    	<table>
            <tr>
                <!--Primera celda de la fila -->
                    <th>
                        Concepto
                    </th>
                    <th>
                        importe
                    </th>
                    <th>
                        Fecha
                    </th>
                </tr>


                <tr>
                    <c:forEach var="invoice" items="${invoices}">
                        <tr>
                            <td>${invoice.value.concept}</td>
                            <td>${invoice.value.value}</td>
                            <td>${invoice.value.dateInvoice}</td>
                        </tr>
                    </c:forEach>
                </tr>
        </table>

</body>

</html>
