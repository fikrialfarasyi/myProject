package com.axia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private Long fieldName;
	
	public ResourceNotFoundException(Long fieldName) {
		super("Id "+fieldName+" tidak ditemukan");
		this.fieldName = fieldName;
	}

	public Long getFieldName() {
		return fieldName;
	}

	public void setFieldName(Long fieldName) {
		this.fieldName = fieldName;
	}

}
