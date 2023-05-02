package com.taehui.restapi.dto;

public class BoardDTO extends SearchDTO{
	private String stationType;
	private String  stationId;
	private String  stationName;
	private String  stationDesc;
	private String  lineId;
	private String  stationNum;
	
	public String getStationType() {
		return stationType;
	}
	public void setStationType(String stationType) {
		this.stationType = stationType;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getStationDesc() {
		return stationDesc;
	}
	public void setStationDesc(String stationDesc) {
		this.stationDesc = stationDesc;
	}
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public String getStationNum() {
		return stationNum;
	}
	public void setStationNum(String stationNum) {
		this.stationNum = stationNum;
	}
	
}
