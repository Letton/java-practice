package ru.letton.practice_16.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.letton.practice_16.services.SchedulerService;

@Controller
@RequiredArgsConstructor
public class HelloController {

    @GetMapping("/hello")
    public String studentInfo() {
        return "student_info";
    }
}
