package ru.aston.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.aston.configuration.HibernateConfig;
import ru.aston.entity.Department;

import java.util.List;

@Repository
public class DepartmentDao {

    private final SessionFactory sessionFactory = HibernateConfig.createSessionFactory();

    public List<Department> getAllDepartment() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Department> departments = session.createQuery("from Department ").getResultList();
        session.getTransaction().commit();
        return departments;
    }

    public void saveOrUpdateDepartment(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(department);
        session.getTransaction().commit();
    }

    public Department findDepartmentById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Department department = session.get(Department.class, id);
        session.getTransaction().commit();
        return department;
    }

    public void deleteDepartmentById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from Department where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}
