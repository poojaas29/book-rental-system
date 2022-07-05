package net.javaguides.brs.enums;

public enum OrderStatus {

	IN_PROCESS("IN_PROCESS"),

	COMPLETE("COMPLETE");

	private String status;

	OrderStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
