<%@ page import="les12015.dominio.Cliente" %>
<% request.getSession();
    if(session.getAttribute("login") == null){
        Cliente cli = (Cliente) session.getAttribute("login");
%>
    <div class="topo">
        <div class="logo">
            <img src="imagens/logo.png" width="100%">
        </div>
        <div class="menu">
            <div id="menu">
                <ul>
                    <a href="ShowLivros?&operacao=EXIBIR"><li>Home</li></a>
                    <a href="quem_somos.jsp"><li>Quem Somos</li></a>
                    <a href="ShowLivros?&operacao=EXIBIR"><li>Livros</li></a>
                    <a href="login.jsp"><li>Login</li></a>
                    <a href="CRUDCompra?&operacao=GETITENS"><li>Carrinho</li></a>
                </ul>
            </div>
        </div>
    </div>
<%} else {%>
    <div class="topo">
        <div class="logo">
            <img src="imagens/logo.png" width="100%">
        </div>
        <div class="menu">
            <div id="menu">
                <ul>
                    <a href="ShowLivros?&operacao=EXIBIR"><li>Home</li></a>
                    <a href="quem_somos.jsp"><li>Quem Somos</li></a>
                    <a href="ShowLivros?&operacao=EXIBIR"><li>Livros</li></a>
                    <a href="CRUDCliente?&operacao=VISUALIZAR"><li>Meu Perfil</li></a>
                    <a href="CRUDCompra?&operacao=GETITENS"><li>Carrinho</li></a>
                </ul>
            </div>
        </div>
    </div>
<%}%>