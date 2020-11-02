<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.Maquina" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Visualizar Maquina</title>

</head>

<body>
    <h3>O seu cliente acaba de ser cadastrado</h3>
	<%Maquina maquina = (Maquina)request.getAttribute("Maquina"); %>
	Id Maquina: <%=maquina.getIdMaquinas() %><br>
	Hostname: <%=maquina.getHostname() %><br>
	SO: <%=maquina.getSO() %><br>
	Descrição: <%=maquina.getDescricao() %><br>
</body>

</html>