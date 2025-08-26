package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.application.ApCadastrarAtor;

@WebServlet("/atores/delete")
public class AtorDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Pega o ID do ator a ser excluído
        Long id = Long.valueOf(request.getParameter("id"));
        
        // 2. Chama a camada de aplicação para excluir o ator
        ApCadastrarAtor.excluirAtor(id);
        
        // 3. Redireciona de volta para a página de listagem
        response.sendRedirect(request.getContextPath() + "/atores");
    }
}