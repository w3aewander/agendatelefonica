<%-- 
    Document   : NovoContato
    Created on : 03/10/2018, 22:15:43
    Author     : wanderlei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="app.css" />
        
    </head>
    <body>
    <div class="form-contato">    
      <h1 class="form-titulo">Editar Contato</h1>
      <hr />
        
        
        <form action="AdicionarContatoServlet" method="POST">
            
            <label>Nome</label><Br />
            <input type="text" name="nome" /><br />
            
            <label>Telefone</label><Br />            
            <input type="tel" name="telefone"  /><br />
            
            <label>Email</label><Br />            
            <input type="email" name="email"  /><br />
            
            <input type="submit" value="Salvar" />
            <input type="reset" value="Limpar" />                      
        </form>
    </div>
    </body>
</html>
