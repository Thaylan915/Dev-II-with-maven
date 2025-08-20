package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.application.ApCadastrarAtor;

@WebServlet("/atores/create")
public class AtorCreateController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Pega o nome do ator enviado pelo formulário
        String nome = request.getParameter("nome");
        
        // 2. Chama a camada de aplicação para incluir o ator
        ApCadastrarAtor.incluirAtor(nome);
        
        // 3. Redireciona o usuário de volta para a página de listagem
        // O redirect evita que o formulário seja reenviado se o usuário recarregar a página
        response.sendRedirect(request.getContextPath() + "/atores");
    }
}