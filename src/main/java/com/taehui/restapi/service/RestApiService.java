package com.taehui.restapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taehui.restapi.dto.BoardDTO;
import com.taehui.restapi.mapper.RestApiMapper;

@Service
public class RestApiService{
	@Autowired
    RestApiMapper restApiMapper;
	
	public List<Map<String, Object>> restApiList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return restApiMapper.selectStation(map);
	}
	public int restApiListCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return restApiMapper.selectStationCount(map);
	 }
	
	public List<BoardDTO> restApiListBoardDto(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return restApiMapper.selectStationBoardDto(boardDto);
	}
	
}
