package com.rana.test;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormats {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double payment = scanner.nextDouble();
		scanner.close();

		String france = getCurrencyFormat(Locale.FRANCE).format(payment);
		String us = getCurrencyFormat(Locale.US).format(payment);
		String china = getCurrencyFormat(Locale.CHINA).format(payment);
		String india = getCurrencyFormat(new Locale("en","IN")).format(payment);
		System.out.println("US: " + us);
		System.out.println("India: " + india);
		System.out.println("China: " + china);
		System.out.println("France: " + france);}

	private static NumberFormat getCurrencyFormat(Locale locale) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		nf.setMaximumFractionDigits(2);
		return nf;
	}
}
