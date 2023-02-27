package ru.aston.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.aston.entity.Department;
import ru.aston.entity.Project;
import ru.aston.entity.Role;
import ru.aston.entity.Worker;

public class HibernateConfig {

    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Worker.class);
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(Role.class);
        configuration.addAnnotatedClass(Project.class);
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
