package ru.geekbrains.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.persist.Student;
import ru.geekbrains.service.StudentService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public String listAll(Model model) {
        model.addAttribute("students", service.findAll());

        return "students";
    }

    @GetMapping("/delete_{id}")
    public String deleteStudent(@PathVariable("id") Long id, Model model) {
        service.delete(id);

        return "redirect:/student";
    }

    @PostMapping
    public String save(Student student, BindingResult result) {
        if (result.hasErrors())
            return "product_form";

        service.save(student);

        return "redirect:/student";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Optional<Student> student = service.findById(id);
        if (student.isEmpty()) {
            return "redirect:/student";
        }
        model.addAttribute("student", student.get());

        return "student_form";
    }

    @GetMapping("/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());

        return "student_form";
    }
}
