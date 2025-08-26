<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Atores</title>
    
    <style>
        :root {
            --primary-color: #007bff;
            --danger-color: #dc3545;
            --light-gray: #f8f9fa;
            --dark-gray: #343a40;
            --border-color: #dee2e6;
        }

        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
            margin: 0;
            background-color: var(--light-gray);
            color: var(--dark-gray);
            display: flex;
            justify-content: center;
            padding: 20px;
        }

        .container {
            width: 100%;
            max-width: 800px;
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        h1, h2 {
            color: var(--primary-color);
            border-bottom: 2px solid var(--border-color);
            padding-bottom: 10px;
            margin-top: 0;
        }
        
        /* (O resto do CSS continua o mesmo que na resposta anterior) */

        .btn {
            padding: 10px 15px; border: none; border-radius: 4px;
            color: white; font-size: 14px; cursor: pointer; transition: opacity 0.2s;
        }
        .btn:hover { opacity: 0.85; }
        .btn-primary { background-color: var(--primary-color); }
        .btn-danger { background-color: var(--danger-color); }
        .btn-update { background-color: #28a745; }

        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; border-bottom: 1px solid var(--border-color); text-align: left; }
        th { background-color: var(--light-gray); }
        input[type="text"] { flex-grow: 1; padding: 10px; border: 1px solid var(--border-color); border-radius: 4px; font-size: 16px; }
        .actions { display: flex; gap: 5px; }
    </style>
</head>
<body>

    <div class="container">
        <h1>Gestão de Atores</h1>

        <c:if test="${not empty mensagem}">
            <p style="color: green; font-weight: bold;">${mensagem}</p>
        </c:if>

        <section>
            <h2>Incluir Novo Ator</h2>
            <form action="${pageContext.request.contextPath}/atores/create" method="post">
                <div style="display: flex; gap: 10px;">
                    <input type="text" name="nome" placeholder="Digite o nome do ator" required>
                    <button type="submit" class="btn btn-primary">Salvar</button>
                </div>
            </form>
        </section>

        <section>
            <h2>Atores Cadastrados</h2>
            <table>
                <thead>
                    <tr>
                        <th style="width: 10%;">ID</th>
                        <th>Nome</th>
                        <th style="width: 25%;">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ator" items="${atores}">
                        <tr>
                             <form action="${pageContext.request.contextPath}/atores/update" method="post">
                                <td>
                                    ${ator.id}
                                    <input type="hidden" name="id" value="${ator.id}">
                                </td>
                                <td>
                                    <input type="text" name="nome" value="${ator.nome}" required>
                                </td>
                                <td class="actions">
                                    <button type="submit" class="btn btn-update">Alterar</button>
                                </form>
                                    
                                <form action="${pageContext.request.contextPath}/atores/delete" method="post">
                                    <input type="hidden" name="id" value="${ator.id}">
                                    <button type="submit" class="btn btn-danger">Excluir</button>
                                </form>
                                </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </div>

</body>
</html>