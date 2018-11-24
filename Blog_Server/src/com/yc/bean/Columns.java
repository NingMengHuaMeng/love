package com.yc.bean;

import java.security.Timestamp;

public class Columns {
	private Long id;
	private String columnName;
	private String aliasName;
	private int parentId;
	private String keyWords;
	private String description;
	private String createBy;
	private Timestamp createDate;
	private int sort;
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Columns [id=" + id + ", columnName=" + columnName + ", aliasName=" + aliasName + ", parentId="
				+ parentId + ", keyWords=" + keyWords + ", description=" + description + ", createBy=" + createBy
				+ ", createDate=" + createDate + ", sort=" + sort + ", status=" + status + "]";
	}
	public Columns() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
