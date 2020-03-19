package com.ac.curso.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long timestamp;
	private Integer status;
	private String msm;
	private String error;
	private String path;
	
	public StandardError() {}

	public StandardError(Long timestamp, Integer status, String msm, String error, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.msm = msm;
		this.error = error;
		this.path = path;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsm() {
		return msm;
	}

	public void setMsm(String msm) {
		this.msm = msm;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
