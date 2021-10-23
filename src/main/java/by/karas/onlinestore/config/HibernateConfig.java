//package by.karas.onlinestore.config;
//
//import by.karas.onlinestore.domain.Product;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Environment;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class HibernateConfig {
//    private static StandardServiceRegistry registry;
//    private static SessionFactory sessionFactory;
//
//    public static SessionFactory getSessionFactory() {
//        //реализация синглтона. Если объекта нет - создаем, если есть просто возвращаем
//        if (sessionFactory == null) {
//            try {
//                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
//
//                //стандартные настройки для хибернат
//                //для тех, кто использует другую базу данных нужно заметить поле DRIVER, DIALECT и кусок URL легко гуглятся под любую базу
//                Map<String, String> settings = new HashMap<>();
//                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
//                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/online_store_db");
//                settings.put(Environment.USER, "root");
//                settings.put(Environment.PASS, "User@Password8");
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
//
//                registryBuilder.applySettings(settings);
//
//                registry = registryBuilder.build();
//
//                MetadataSources sources = new MetadataSources(registry);
//                sources.addAnnotatedClass(Product.class);
//                Metadata metadata = sources.getMetadataBuilder().build();
//
//                sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                if (registry != null) {
//                    StandardServiceRegistryBuilder.destroy(registry);
//                }
//            }
//        }
//        return sessionFactory;
//    }
//
//    public static void close() {
//        if (registry != null) {
//            StandardServiceRegistryBuilder.destroy(registry);
//        }
//    }
//}
