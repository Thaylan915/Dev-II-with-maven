package model.application;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import model.domain.Ator;
import util.PersistenceUtil;

public class ApCadastrarAtor {

    // Cada método abre e fecha sua própria sessão, garantindo a estabilidade.
    
    public static int incluirAtor(String nome) {
        if (nome == null || nome.trim().isEmpty()) return 1;

        Transaction transaction = null;
        try (Session session = PersistenceUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Ator ator = new Ator();
            ator.setNome(nome);
            session.save(ator);
            transaction.commit();
            return 0; // Sucesso
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return 2;
        }
    }

    public static int alterarAtor(Long id, String novoNome) {
        if (id == null || novoNome == null || novoNome.trim().isEmpty()) return 1;

        Transaction transaction = null;
        try (Session session = PersistenceUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Ator ator = session.get(Ator.class, id);
            if (ator == null) return 3;
            ator.setNome(novoNome);
            transaction.commit();
            return 0; // Sucesso
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return 2;
        }
    }

    public static int excluirAtor(Long id) {
        if (id == null) return 1;

        Transaction transaction = null;
        try (Session session = PersistenceUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Ator ator = session.get(Ator.class, id);
            if (ator == null) return 3;
            session.delete(ator);
            transaction.commit();
            return 0; // Sucesso
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return 2;
        }
    }

    public static List<Ator> consultarAtores() {
        try (Session session = PersistenceUtil.getSessionFactory().openSession()) {
            Query<Ator> query = session.createQuery("from Ator ORDER BY nome", Ator.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}