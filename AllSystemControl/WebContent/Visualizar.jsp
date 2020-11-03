<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.Maquina" %>
<%@page import="model.Informacoes" %>
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
	<%Maquina maquina = (Maquina) request.getAttribute("maquina"); %>
	
	Id Maquina <%=maquina.getIdMaquinas() %><br>
	Hostname: <%=maquina.getHostname() %><br>
	Sistema operacional: <%=maquina.getSO() %><br>
	Descricao: <%=maquina.getDescricao() %><br>
	
	<%Informacoes informacoes = (Informacoes) request.getAttribute("informacoes"); %>
	
	Id Informações: <%=informacoes.getIdInformacoes() %><br>
	Id Maquina: <%=informacoes.getIdMaquina() %><br>
	CPU: <%=informacoes.getCPU() %><br>
	HD Total: <%=informacoes.getHDTotal() %><br>
	HD Disponivel: <%=informacoes.getHDDisponivel() %><br>
	HD Utilizado:  <%=informacoes.getHDUtilizado() %><br>
	Ram Total: <%=informacoes.getRamTotal() %><br>
	Ram Utilizado: <%=informacoes.getRamUtilizada() %><br>
	Ram Disponivel: <%=informacoes.getRamDisponivel() %><br>
	Data: <%=informacoes.getData() %><br>
	
	

</body>

</html>