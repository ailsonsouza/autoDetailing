package com.projects.autodetailing.emuns;

import java.util.Arrays;

public enum OrderStatus {
	
	WAITING_OPENING(1),
	IN_PROGRESS(2),
	COMPLETED(3);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		return Arrays.stream(OrderStatus.values())
				.filter(status -> status.getCode() == code)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Invalid OrderStatus code"));
		
	}
}
