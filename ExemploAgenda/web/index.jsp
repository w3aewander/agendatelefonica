<%-- 
    Document   : listar
    Created on : 03/10/2018, 12:31:20
    Author     : wanderlei
--%>

<%@page import="br.senac.agenda.model.Mensagem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.senac.agenda.model.ContatoDao" />
<jsp:useBean id="mensagem" class="br.senac.agenda.model.Mensagem" />


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contatos</title>
        <link type="text/css" rel="stylesheet" href="app.css" />
        
    </head>
    <body>


        <main>
            <section id="pagina">    

            <%
                String retorno = Mensagem.mensagem;
            %>


            <c:if test="${not empty mensagem}"> 
                <div class="mensagem">    
                    ${Mensagem.mensagem}
                </div>
            </c:if>

                <header>
                    <hgroup>
                        <h1>Agenda Telefonônica</h1>
                        <p class="a-novo-contato">                            
                            <a  href="NovoContato.jsp" ><span class="icon-novo-contato"></span> Novo Contato</a>                    
                        </p>  
                    </hgroup>
                </header>

                <article>

                    <c:choose>

                        <c:when test="${empty dao.listar()}">
                            <p>
                            <h2>Lista vazia</h2>
                            </p>            
                        </c:when>
                        <c:otherwise>
                            <table width="80%" cellppading="2" border="1" align="center">

                                </thead>
                                <th width="40">ID</th>
                                <th>Nome</th>
                                <th>Telefone</th>
                                <th>Email</th>
                                <th width="60">Opções</th>
                                </tr>
                                </thead>
                                <tbody>

                                    <c:forEach var="contato" items="${dao.listar()}">
                                        <tr>
                                            <td>${contato.id}</td>
                                            <td>${contato.nome}</td>
                                            <td>${contato.telefone}</td>
                                            <td>${contato.email}</td>
                                            <td align="center">
                                                <a href="EditarContato.jsp?contatoId=${contato.id}" title="Editar"><span class="icon-editar"></span></a>
                                                <a href="ExcluirContatoServlet?contatoId=${contato.id}"  title="Excluir"><span class="icon-excluir"></span></a>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    <c:if test="${dao.listar().size() < 10 }">
                                        <c:forEach var="i" begin="1" end="${10 - dao.listar().size()}">
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        </c:forEach>
                                    </c:if>

                                </tbody>
                                <tfoot>
                                    <tr><th align="left" colspan="5">${dao.listar().size()} registros cadastrados.</th></tr>
                                </tfoot>
                            </table> 
                        </c:otherwise>
                    </c:choose> 

                </article>
            <footer>
                
            </footer>
            </section>
        </main>

    </body>
</html>
