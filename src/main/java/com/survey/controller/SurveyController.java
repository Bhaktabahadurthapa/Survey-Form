package com.survey.controller;

import com.survey.model.Survey;
import com.survey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SurveyController {
    
    @Autowired
    private SurveyRepository surveyRepository;
    
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("survey", new Survey());
        return "survey";
    }
    
    @PostMapping("/submit")
    public String submitForm(Survey survey) {
        surveyRepository.save(survey);
        return "redirect:/?success";
    }
}
