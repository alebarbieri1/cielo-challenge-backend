package br.com.cielo.challenge.exception.handler;

import java.util.Date;

public class Error {
	private String description;
	private Date time;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
