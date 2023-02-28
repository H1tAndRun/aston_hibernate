package ru.aston.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.aston.configuration.HibernateConfig;
import ru.aston.dto.project_worker.ProjectWorkerDtoRq;
import ru.aston.entity.Project;

import java.util.List;

@Repository
public class ProjectDao {

    private final SessionFactory sessionFactory = HibernateConfig.createSessionFactory();

    public List<Project> getAllProject() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Project> projects = session.createQuery("FROM Project ").getResultList();
        session.getTransaction().commit();
        return projects;
    }

    public void saveOrUpdateProject(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(project);
        session.getTransaction().commit();
    }

    public Project getProjectById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Project project = session.get(Project.class, id);
        session.getTransaction().commit();
        return project;
    }

    public void deleteProjectById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Project WHERE id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public List<Project> getProjectWorkers() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Project> projects = session.createQuery("SELECT DISTINCT p FROM " +
                "Project p JOIN FETCH p.workers").getResultList();
        session.getTransaction().commit();
        return projects;
    }

    public void deleteProjectWorker(Integer worker_id, Integer project_id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createNativeQuery(
                    "DELETE FROM projects_workers WHERE worker_id = ? AND project_id = ?");
            query.setParameter(1, worker_id);
            query.setParameter(2, project_id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void saveProjectWorkers(ProjectWorkerDtoRq projectWorkerDtoRq) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session
                .createNativeQuery("INSERT INTO projects_workers (worker_id, project_id) values (?,?)");
        query.setParameter(1, projectWorkerDtoRq.getWorkerId());
        query.setParameter(2, projectWorkerDtoRq.getProjectId());
        query.executeUpdate();
        session.getTransaction().commit();
    }
}
