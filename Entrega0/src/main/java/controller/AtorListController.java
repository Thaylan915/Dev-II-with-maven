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
import model.domain.Ator;

@WebServlet("/atores")
public class AtorListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. A consulta ao banco está funcionando (vimos no log)
        List<Ator> atores = ApCadastrarAtor.consultarAtores();
        
        // 2. Os dados são colocados na requisição
        request.setAttribute("atores", atores);
        
        // 3. PONTO CRÍTICO: Verifique se esta parte está correta no seu código
        String paginaDestino = "/views/atores.jsp";
        
        // 4. Encaminha para o JSP
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
        dispatcher.forward(request, response);
    }
}