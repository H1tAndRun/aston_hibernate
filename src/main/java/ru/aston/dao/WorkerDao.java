package ru.aston.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.aston.configuration.HibernateConfig;
import ru.aston.entity.Worker;

import java.util.List;

@Repository
public class WorkerDao {

    private final SessionFactory sessionFactory = HibernateConfig.createSessionFactory();

    public List<Worker> getAllWorker() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Worker> workers = session.createQuery("from Worker ").getResultList();
        session.getTransaction().commit();
        return workers;
    }

    public Worker getWorkerById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Worker worker = session.get(Worker.class, id);
        session.getTransaction().commit();
        return worker;
    }

    public void saveOrUpdateWorker(Worker worker) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(worker);
        session.getTransaction().commit();
    }

    public void deleteWorker(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from Worker where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}
