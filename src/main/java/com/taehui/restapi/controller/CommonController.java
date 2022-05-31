package com.taehui.restapi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"}) // 추가 
@RestController 
public class CommonController {
	//list를 json으로 변환
	public static JSONArray convertListToJson(List<Map<String, Object>> list) {
		JSONArray jsonArray = new JSONArray();
		for(Map<String, Object> map : list) {
			jsonArray.add(convertMapToJson(map));
		}
		return jsonArray;
	}
	//map을 json으로 변환
	public static JSONObject convertMapToJson(Map<String, Object> map) {
		JSONObject json = new JSONObject();
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			String key =entry.getKey();
			Object value = entry.getValue();
			json.put(key, value);
		}
		return json;
	}
	
	//파일 다운로드
	@RequestMapping(value="fileDownload.do")
	public void fileDownload(HttpServletResponse response) throws IOException {
	    File file = new File("C:/Users/lth11/Desktop/이태희2021.06.28~/KALIS/fileTest/test1.txt");
	    fileDownload(response, file);
	}
		//zip 변환 후 파일 다운로드
	@RequestMapping(value="zipFileDownload.do")
	public void zipFileDownload(HttpServletResponse response) throws IOException {
		//다운로드 하는 게시물의 고유 코드를 가지고 해당 코드를 가지지고 있는 모든 파일을 파일 리스트에 추가 후 저장
	    List<File> fileList = new LinkedList();
	    
	    fileList.add(new File("C:/Users/lth11/Desktop/이태희2021.06.28~/KALIS/fileTest/test1.txt"));
	    fileList.add(new File("C:/Users/lth11/Desktop/이태희2021.06.28~/KALIS/fileTest/test2.txt"));
	    fileList.add(new File("C:/Users/lth11/Desktop/이태희2021.06.28~/KALIS/fileTest/apple.jpg"));
	    
	    zipFileDownload(response, fileList, "zipFile");

	}
	
	//파일 다운로드
	public void fileDownload(HttpServletResponse response, File file) throws IOException {
	    FileInputStream fis = null;
	    
		response.setStatus(HttpServletResponse.SC_OK);
	    response.setContentType("application/file");
	    response.addHeader("Content-Disposition", "attachment; filename=" + file.getName());
	    
	    fis = new FileInputStream(file);
	    StreamUtils.copy(fis, response.getOutputStream());
	    fis.close();

	}
	
	//zip 변환 후 파일 다운로드
	public void zipFileDownload(HttpServletResponse response, List<File> fileList, String zipName) throws IOException {
		response.setStatus(HttpServletResponse.SC_OK);
	    response.setContentType("application/zip");
	    response.addHeader("Content-Disposition", "attachment; filename=\"" + zipName + ".zip\"");
	    
	    ZipOutputStream zipOut = null;
	    FileInputStream fis = null;
	    zipOut = new ZipOutputStream(response.getOutputStream());

	    // 루프를 돌며 ZipOutputStream에 파일들을 계속 주입해준다.
        for(File file : fileList) {
            zipOut.putNextEntry(new ZipEntry(file.getName()));
            fis = new FileInputStream(file);
            StreamUtils.copy(fis, zipOut);
            fis.close();
            zipOut.closeEntry();
        }
        zipOut.close();
	}
}
