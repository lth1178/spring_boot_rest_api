package com.taehui.restapi.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@Mapper
@Repository 
public interface RestApiMapper { 
	/* rest */
	public List<Map<String, Object>> selectStation(Map<String, Object> map); //
	public int selectStationCount(Map<String, Object> map); //
}
