package com.question.QuestionService.controller;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
        @Autowired
        private QuestionService questionService;

        @PostMapping
        private Question create(@RequestBody Question question) {
                return questionService.create(question);
        }

        @GetMapping
        public List<Question> getAll() {
                return questionService.get();
        }

        @GetMapping("/{questionId}")
        public Question getAll(@PathVariable Long questionId) {
                return questionService.getOne(questionId);
        }

        @GetMapping("/quiz/{quizId}")
        public List<Question> getQuestionOfQuiz(@PathVariable Long quizId) {
                return questionService.getQuestionOfQuiz(quizId);

        }
}

