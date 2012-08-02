<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrão</title>
</head>
<body>
	<h1>Cadastrão</h1>
	<form action="adicionar.spring">
		<label for="form:nome">Nome:</label>
		<input name="nome" id="form:nome"/>
		<label for="form:telefone">Telefone:</label>
		<input name="telefone" id="form:telefone"/>
		<input type="submit" value="Salvar"/>
	</form>
	
	<table>
	<tr>
		<th>Id</th>
		<th>Nome</th>
		<th>Telefone</th>
		<th>Remover</th>
	</tr>
	<c:forEach items="${contatos}" var="c">
	<tr>
		<td>${c.id}</td>
		<td>${c.nome}</td>
		<td>${c.telefone}</td>
		<td><a href="remover.spring?id=${c.id}">remover</a></td>
	</tr>				
	</c:forEach>
	</table>
</body>
</html>