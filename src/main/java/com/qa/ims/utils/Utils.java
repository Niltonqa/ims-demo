package com.qa.ims.utils;

import java.util.Scanner;

public class Utils {

	private Utils() {

	}

	public static String getInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static Double getDoubleFromInput() {
		return Double.valueOf(getInput());
	}

	public static Long getLongFromInput() {
		return Long.valueOf(getInput());
	}

	public static int getIntFromInput() {
		return Integer.valueOf(getInput());
	}

}
