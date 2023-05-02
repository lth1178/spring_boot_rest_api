package com.taehui.restapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"}) // 추가 
@Controller 
public class ViewController {
	@GetMapping("/")
    public String home() throws Exception {
        final Map<String, Object> resultMap = new HashMap<>();
        return "/index.html";
    }
}
