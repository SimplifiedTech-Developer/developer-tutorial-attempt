package tech.tebatsomokgokolo.formvalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tech.tebatsomokgokolo.formvalidation.dto.request.RegistrationRequest;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @GetMapping("/")
    public String showForm(RegistrationRequest request) {
        return "register";
    }

    @PostMapping("/")
    public String register(@Valid RegistrationRequest request, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "register";
        } else {
            model.addAttribute("message", "Registration successfully...");
            return "register";
        }
    }
}
