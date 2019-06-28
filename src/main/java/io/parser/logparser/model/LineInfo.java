package io.parser.logparser.model;

import java.io.Serializable;

public class LineInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2681162752310603615L;
	
	private String operation;
	private String filename;
	private Integer line_number;
	private String name;
	
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Integer getLine_number() {
		return line_number;
	}
	public void setLine_number(Integer line_number) {
		this.line_number = line_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
