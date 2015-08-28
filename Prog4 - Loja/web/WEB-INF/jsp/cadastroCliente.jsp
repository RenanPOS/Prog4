<%-- 
    Document   : cadastroCliente
    Created on : 28/08/2015, 18:18:16
    Author     : renan.polli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Meu cadastro</h1>
        <form action="Cadastro" method="Post">
            <label for="PF" id="PF"></label>
                <input type="radio" name="Pessoa" value="PF"/>Pessoa Física
            <label for="PJ" id="PJ"></label>
                <input type="radio" name="Pessoa" value="PJ"/>Pessoa jurídica
            <label for="Nome"> Nome: </label> 
                <input type="text" name="Nome" id="Nome">
            <label for="CPF"> CPF: </label> 
                <input type="text" name="CPF" id="CPF">
            <label for="DataNasc"> Data Nascimento: </label>
                <input type="date" name="Data" id="DataNasc"/>
            <label for="Sexo"> Sexo: </label>
            <select name="Sexo" id="Sexo">
                <option value="Selecione">Selecione</option>
                <option value="Masculino">Masculino</option>
                <option value="Feminino">Feminino</option>
            </select>
            <label name="Comentario" id="Comentario"> Comentario:
                <textarea name="Comentario" id="Comentario"></textarea>
            </label>
            <input type="submit" value="Salvar"/>
        </fomr>
    </body>
</html>
