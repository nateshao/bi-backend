package com.bi.common;

import com.bi.utils.EJBIUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;


public abstract class BaseEntity {
	
	public abstract void validate();

	@JsonIgnore
	private String dbName = EJBIUtils.getConstant("dbName");

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
}
