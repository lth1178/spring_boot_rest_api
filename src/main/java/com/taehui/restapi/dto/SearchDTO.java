package com.taehui.restapi.dto;

public class SearchDTO {
	private String searchKind;
	private String searchWord;
	private int firstRowDatNum;
	private String colId;
	private String sort;
	private int pageSize;
	public String getSearchKind() { 
		return searchKind;
	}
	public void setSearchKind(String searchKind) {
		this.searchKind = searchKind;
	}
	public String getSearchWork() {
		return searchWord;
	}
	public void setSearchWork(String searchWork) {
		this.searchWord = searchWork;
	}
	public int getFirstRowDatNum() {
		return firstRowDatNum;
	}
	public void setFirstRowDatNum(int firstRowDatNum) {
		this.firstRowDatNum = firstRowDatNum;
	}
	public String getColId() {
		return colId;
	}
	public void setColId(String colId) {
		this.colId = colId;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
