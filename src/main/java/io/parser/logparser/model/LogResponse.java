package io.parser.logparser.model;

import java.io.Serializable;
import java.util.List;

public class LogResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6910388893157687050L;
	
	private List<LineInfo> result;
	

	public List<LineInfo> getResult() {
		return result;
	}

	public void setResult(List<LineInfo> result) {
		this.result = result;
	}

}
