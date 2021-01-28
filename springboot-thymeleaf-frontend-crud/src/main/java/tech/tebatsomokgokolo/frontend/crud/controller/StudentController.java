package tech.tebatsomokgokolo.frontend.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.tebatsomokgokolo.frontend.crud.dto.request.Student;
import tech.tebatsomokgokolo.frontend.crud.enums.CommonEnum;
import tech.tebatsomokgokolo.frontend.crud.enums.PageNameEnum;
import tech.tebatsomokgokolo.frontend.crud.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/students/")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("signup")
    public String showSignUpForm(Student student) {
        return PageNameEnum.ADD_STUDENT.getValue();
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        List<Student> allStudents = service.getAll();
        model.addAttribute(CommonEnum.ATTRIBUTE_STUDENTS.getValue(), allStudents);
        return PageNameEnum.INDEX.getValue();
    }

    @PostMapping("add")
    public String addStudent(@Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return PageNameEnum.ADD_STUDENT.getValue();
        }
        service.addStudent(student);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Student student = service.getStudentById(id);
        model.addAttribute(CommonEnum.ATTRIBUTE_STUDENT.getValue(), student);
        return PageNameEnum.UPDATE_STUDENT.getValue();
    }

    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return PageNameEnum.UPDATE_STUDENT.getValue();
        }
        service.updateStudent(id, student);
        model.addAttribute(CommonEnum.ATTRIBUTE_STUDENTS.getValue(), service.getAll());
        return PageNameEnum.INDEX.getValue();
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        service.deleteStudent(id);
        model.addAttribute(CommonEnum.ATTRIBUTE_STUDENTS.getValue(), service.getAll());
        return PageNameEnum.INDEX.getValue();
    }
}
