package ru.aston.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.aston.configuration.HibernateConfig;
import ru.aston.entity.Role;

import java.util.List;

@Repository
public class RoleDao {

    private final SessionFactory sessionFactory = HibernateConfig.createSessionFactory();

    public List<Role> getAllRole() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Role> roles = session.createQuery("from Role ").getResultList();
        session.getTransaction().commit();
        System.out.println(roles);
        return roles;
    }

    public Role findRoleById(Integer id){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Role role = session.get(Role.class, id);
        session.getTransaction().commit();
        return role;
    }

    public void saveOrUpdateRole(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(role);
        session.getTransaction().commit();
    }

    public Role getRoleById(Integer id){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Role role = session.get(Role.class, id);
        session.getTransaction().commit();
        return role;
    }

    public void deleteRoleById(Integer id){
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from Role where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}
