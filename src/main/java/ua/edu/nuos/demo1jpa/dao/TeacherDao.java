package ua.edu.nuos.demo1jpa.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ua.edu.nuos.demo1jpa.data.Teacher;

import java.util.List;

@Stateless
public class TeacherDao {
    @PersistenceContext
    private EntityManager em;


    public Teacher findById(Long id) {
        return em.find(Teacher.class, id);
    }

    public List<Teacher> findAll() {
        return em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    public void delete(Teacher teacher) {
        em.remove(teacher);
    }

    public Teacher save(Teacher teacher) {
        if (teacher.getId() == null) {
            em.persist(teacher);
        } else {
            em.merge(teacher);
        }
        return teacher;
    }

    private Teacher addTeacher(Teacher teacher) {
        em.persist(teacher);
        return teacher;
    }

    private Teacher updateTeacher(Teacher teacher) {
        em.merge(teacher);
        return teacher;
    }
}
