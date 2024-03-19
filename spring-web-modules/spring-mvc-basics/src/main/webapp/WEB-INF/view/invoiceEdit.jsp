<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    </Style>

</head>
<body>
	<h3>Edita la Factura</h3>

    <a href="/spring-mvc-basics/invoiceList">Lista de Facturas</a>

	<form:form cssclass=""
	           method="POST"
	           action="/spring-mvc-basics/invoiceResultUpdate"
	           modelAttribute="invoice">

	    <form:hidden path="id"/>
		<table>
			<tr>
				<td><form:label path="concept">Concepto</form:label></td>
				<td><form:input path="concept" value="${(update)? concept : ''}" /></td>
				<td><form:errors path="concept" class="error"/></td>
			</tr>
			<tr>
				<td><form:label path="value">Importe</form:label></td>
				<td><form:input path="value" value="${(update)? value : ''}" /></td>
				<td><form:errors path="value" class="error"/></td>
			</tr>
			<tr>
				<td><form:label path="percent">IVA</form:label></td>
				<td><form:input path="percent" value="${(update)? percent : ''}"/></td>
				<td><form:errors path="percent" class="error"/></td>
			</tr>
            <tr>
                <td><form:label path="dateInvoice">Fecha</form:label></td>
                <td><form:input type="date" path="dateInvoice"/></td>
				<td><form:errors path="dateInvoice" class="error"/></td>
            </tr>

				<td><input type="submit" value="enviar" /></td>
			</tr>
		</table>
	</form:form>

</body>

</html>