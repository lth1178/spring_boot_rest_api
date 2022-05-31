package com.taehui.restapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.bytecode.SignatureAttribute.ClassType;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taehui.restapi.dto.BaordDTO;
import com.taehui.restapi.dto.SearchDTO;
import com.taehui.restapi.service.RestApiService;

//cors정책 허용을 위해 추가
@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"}) // 추가 
@RestController 
public class AgGridController {
	
	@Autowired
	private RestApiService restApiService;
	
	@GetMapping("/api/ag-grid")
	public Map<String, Object> agGrid() {
		Map<String, Object> a = new HashMap<>();
		return new HashMap<>();
	}
	@GetMapping("/api/ag-grid-response")
	public String agGridResponse() {
		return "agGridResponse 입니다.";
	}
	
	@PostMapping("/api/station")
	public List<Map<String, Object>> selectStation(@RequestBody HashMap<String, Object> map) {
		
		return restApiService.restApiList(map);
	}
	
	@GetMapping("/api/test")
	public Map<String, Object> test() {
		Map<String, Object> map = new HashMap<>();
		
		Map<String, Object> resultMap = new HashMap<>();
		List<Map<String, Object>> list = restApiService.restApiList(map);
		int totalRowDataCount = restApiService.restApiListCount(map);
		resultMap.put("rowData", list);
		resultMap.put("totalRowDataCount", totalRowDataCount);
		return resultMap;
	}
	//axios 데이터 가지고 오기
	@PostMapping("/api/test/post")
	public Map<String, Object> post(@RequestBody Map<String, Object> request) {
		Map<String, Object> resultMap = new HashMap<>();
		List<Map<String, Object>> list = restApiService.restApiList(request);
		int totalRowDataCount = restApiService.restApiListCount(request);
		resultMap.put("rowData", list);
		resultMap.put("totalRowDataCount", totalRowDataCount);
		return resultMap;
	}
	@GetMapping("/api/test/count")
	public Map<String, Object> count() {
		Map<String, Object> map = new HashMap<>();
		int totalRowDataCount = restApiService.restApiListCount(map);
		map.put("totalRowDataCount", totalRowDataCount);
		return map;
	}
	
	
	@GetMapping("/api/station")
	public List<Map<String, Object>> getSelectStation() {
		List<Map<String, Object>> list = new ArrayList<>();
		
		
		for(int i=0; i<124; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("TITLE", "제목_" + i) ;
			map.put("CONTECTS", "내용_" + i);
			map.put("WRITER", "글쓴이_" + i);
			list.add(map);
		}
		return list;
	}
	
	
}
