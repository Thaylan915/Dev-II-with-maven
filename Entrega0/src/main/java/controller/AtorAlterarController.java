package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.application.ApCadastrarAtor;

@WebServlet("/atores/update")
public class AtorAlterarController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Pega o ID e o novo nome do ator
        Long id = Long.valueOf(request.getParameter("id"));
        String novoNome = request.getParameter("nome");
        
        // 2. Chama a camada de aplicação para alterar o ator
        ApCadastrarAtor.alterarAtor(id, novoNome);
        
        // 3. Redireciona de volta para a página de listagem
        response.sendRedirect(request.getContextPath() + "/atores");
    }
}