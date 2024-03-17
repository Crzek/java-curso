<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html >
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <title>Invoice Result</title>
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
<h1>Resultado Factura</h1>
<p><strong>Concepto:</strong> ${concept}</p>
<p><strong>Fecha:</strong> ${dateInvoice}</p>
<p><strong>importe:</strong> ${value}</p>
<p><strong>IVA:</strong> ${percent}</p>
<p><strong>importe - IVA:</strong> ${result}</p>

<a href="/spring-mvc-basics/invoice">Insertar Otra factura</a>
<br/>
<a href="/spring-mvc-basics/invoiceList">Lista de Facturas</a>

</body>
</html>