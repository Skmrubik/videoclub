package com.videoclub.dto;

public class ValueLabel {
	Integer value;
	String label;
	
	public ValueLabel(Integer value, String label) {
		this.value = value;
		this.label = label;
	}

	public ValueLabel() {
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
