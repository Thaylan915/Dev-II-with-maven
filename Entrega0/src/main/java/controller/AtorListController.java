 package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.application.ApCadastrarAtor;
import model.application.ApCadastrarAtor;
import model.domain.Ator;

// A anotação @WebServlet mapeia este Servlet para a URL /atores
@WebServlet("/atores")
public class AtorListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Chama a camada de aplicação para obter a lista de atores
        List<Ator> atores = ApCadastrarAtor.consultarAtores();
        
        // 2. Coloca a lista no objeto de requisição para ser acessada pelo JSP
        request.setAttribute("atores", atores);
        
        // 3. Encaminha a requisição para a página JSP que vai exibir os dados
        String GOTO_PAGE = "/listaAtores.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(GOTO_PAGE);
        dispatcher.forward(request, response);
    }
}