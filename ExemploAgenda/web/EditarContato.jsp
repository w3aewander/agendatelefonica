<%-- 
    Document   : EditarContato.jsp
    Created on : 03/10/2018, 21:33:14
    Author     : wanderlei
--%>

<%@page import="br.senac.agenda.model.Contato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="br.senac.agenda.model.ContatoDao" />
<jsp:useBean id="contato" class="br.senac.agenda.model.Contato" scope="request" />


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar contato</title>
        <link rel="stylesheet" type="text/css" href="app.css" />
    </head>
    <body>
        
        <div class="form-contato">
        <h1>Editar Contato</h1>
        <% 
            int contatoId = Integer.parseInt( request.getParameter("contatoId") );
            Contato pesquisa  = dao.pesquisar(contatoId);
            contato.setId(contatoId);
            contato.setNome(pesquisa.getNome());
            contato.setTelefone(pesquisa.getTelefone());
            contato.setEmail(pesquisa.getEmail());
        %>
        
        
        <form action="ModificarContatoServlet" method="POST">
            <label>ID</label><Br />
            <input type="text" name="contatoId" value="${contato.id}" readonly="readonly" /><br />
            
            <label>Nome</label><Br />
            <input type="text" name="nome" value="${contato.nome}" /><br />
            
            <label>Telefone</label><Br />
            <input type="tel" name="telefone" value="${contato.telefone}" /><br />
            
            <label>Email</label><Br />
            <input type="email" name="email" value="${contato.email}" /><br />
            
            <input type="submit" value="Salvar" /><input type="reset" value="Limpar" />          
        </form>
        
        </div>
    </body>
</html>
