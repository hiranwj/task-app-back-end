package lk.hiranwj.app.dao.util;

import lk.hiranwj.app.entity.Project;
import lk.hiranwj.app.entity.Task;
import lk.hiranwj.app.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
//                .configure( "org/hibernate/example/hibernate.cfg.xml" )
                .loadProperties("/application.properties")

                .build();

        Metadata metadata = new MetadataSources( standardRegistry )

                /*.addAnnotatedClass( MyEntity.class )
                .addAnnotatedClassName( "org.hibernate.example.Customer" )
                .addResource( "org/hibernate/example/Order.hbm.xml" )
                .addResource( "org/hibernate/example/Product.orm.xml" )*/
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Project.class)
                .addAnnotatedClass(Task.class)

                .getMetadataBuilder()
                .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
                .build();

        return metadata.getSessionFactoryBuilder()
//                .applyBeanManager( getBeanManager() )
                .build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
