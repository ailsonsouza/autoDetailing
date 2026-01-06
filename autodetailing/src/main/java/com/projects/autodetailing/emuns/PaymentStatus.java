package com.projects.autodetailing.emuns;

import java.util.Arrays;

public enum PaymentStatus {
	
	MONEY(1),
	CREDIT_CARD(2),
	DEBIT_CARD(3),
	PIX(4),
	BANK_TRANSFER(5),
	BOLETO(6),
	VOUCHER(7);
	
	private int code;
	
	private PaymentStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static PaymentStatus valueOf(int code) {
		return Arrays.stream(PaymentStatus.values())
				.filter(status -> status.getCode() == code)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Invalid OrderStatus code"));
		
	}
}
