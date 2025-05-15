package com.devattom.SpringHibernateJpa.DAO;

import com.devattom.SpringHibernateJpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query =  entityManager.createQuery(
                "SELECT s FROM Student s ORDER BY firstName"
                , Student.class
        );
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query =  entityManager.createQuery(
                "SELECT s FROM Student s WHERE s.lastName = :lastName",
                Student.class
        );
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }
}
