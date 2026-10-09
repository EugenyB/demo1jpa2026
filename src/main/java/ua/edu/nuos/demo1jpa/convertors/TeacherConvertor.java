package ua.edu.nuos.demo1jpa.convertors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import ua.edu.nuos.demo1jpa.data.Teacher;
import ua.edu.nuos.demo1jpa.data.TeacherDto;

@Named
@ApplicationScoped
public class TeacherConvertor {
    public Teacher convert(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherDto.getId());
        teacher.setName(teacherDto.getName());
        teacher.setExperience(teacherDto.getExperience());
        return teacher;
    }

    public TeacherDto convert(Teacher teacher) {
        var t = new TeacherDto();
        t.setId(teacher.getId());
        t.setName(teacher.getName());
        t.setExperience(teacher.getExperience());
        return t;
    }
}
