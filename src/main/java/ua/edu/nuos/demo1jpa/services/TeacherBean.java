package ua.edu.nuos.demo1jpa.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ua.edu.nuos.demo1jpa.convertors.TeacherConvertor;
import ua.edu.nuos.demo1jpa.dao.TeacherDao;
import ua.edu.nuos.demo1jpa.data.Teacher;
import ua.edu.nuos.demo1jpa.data.TeacherDto;

import java.util.List;

@Named
@RequestScoped
public class TeacherBean {

    @Inject
    private TeacherDao teacherDao;

    @Inject
    private TeacherConvertor convertor;

    @Getter
    @Setter
    private TeacherDto teacherDto = new TeacherDto();

    public List<TeacherDto> getTeachers() {
        return teacherDao.findAll()
                .stream()
                .map(convertor::convert)
                .toList();
    }

    public void addTeacher() {
        if (teacherDto.getName() == null || teacherDto.getName().isEmpty())
            return;
        if (teacherDto.getExperience() < 0)
            return;

        teacherDao.save(convertor.convert(teacherDto));
        teacherDto = new TeacherDto();
    }
}
