package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PersistenceUtil {

   
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Cria o registro de serviço a partir do hibernate.cfg.xml
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            // Cria os metadados
            Metadata metadata = new MetadataSources(standardRegistry)
                    .getMetadataBuilder().build();

            // Cria a SessionFactory a partir dos metadados
            return metadata.getSessionFactoryBuilder().build();
            
        } catch (Throwable ex) {
            // Este log é crucial para diagnosticar erros de inicialização
            System.err.println("### Falha Crítica ao criar a SessionFactory do Hibernate. ###");
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retorna a SessionFactory global e única da aplicação.
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}