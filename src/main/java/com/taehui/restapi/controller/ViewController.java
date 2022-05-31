package com.taehui.restapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"}) // 추가 
@RestController 
public class ViewController {
	@GetMapping("/")
    public ResponseEntity<Map<String, Object>> home(@RequestParam(name="boardName")String name) throws Exception {
        
        String type = "test".equals(name) ? "generic" : "card";
        String jsonStr = "{"
                + "	boardName: '"+name+"',"
                + "	boardType: '"+type+"'"
                + "}";
    
        JSONParser parser = new JSONParser(jsonStr);
        Object obj = parser.parse( );
        
        final Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", obj);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}
