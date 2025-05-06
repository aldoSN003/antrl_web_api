package org.example.antlr_api.api.controller;
import org.example.antlr_api.api.model.ExpressionRequest;
import org.example.antlr_api.service.ExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class ExpressionController {

    @Autowired
    private ExpressionService expressionService;

    @PostMapping("/parse")
    public String parseExpression(@RequestBody ExpressionRequest request) {
        return expressionService.parseExpression(request.getExpression());
    }
}