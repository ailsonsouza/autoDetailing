package com.projects.autodetailing.emuns;

import java.util.Arrays;

public enum PaymentMethod {
	
	PENDING(1),
	PAID(2),
	OVERDUE(3),
	CANCELED(4);
	
	private int code;
	
	private PaymentMethod(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static PaymentMethod valueOf(int code) {
		return Arrays.stream(PaymentMethod.values())
				.filter(status -> status.getCode() == code)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Invalid OrderStatus code"));
		
	}
}
