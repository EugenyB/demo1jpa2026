package ua.edu.nuos.demo1jpa.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ua.edu.nuos.demo1jpa.data.Teacher;

@Stateless
public class TeacherService {
    @PersistenceContext
    private EntityManager em;

    public void addTeacher(Teacher teacher) {
        em.persist(teacher);
    }

    public Teacher getTeacherById(Long id) {
        return em.find(Teacher.class, id);
    }

    public void updateTeacher(Teacher teacher) {
        em.merge(teacher);
    }
}
