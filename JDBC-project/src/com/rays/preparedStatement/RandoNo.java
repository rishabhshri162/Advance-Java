package com.rays.Stream;

import java.util.ArrayList;
import java.util.List;

public class RandoNo {

	public static boolean prime(int num) {

		if (num == 0 || num == 1) {
			return false;

		} else if (num == 2 || num == 3) {
			return true;
		} else {
			for (int i = 2; i < num / 2; i++) {
				if (num % i == 0) {
					return false;
				}

			}
			return true;
		}

	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(23);
		list.add(58);
		list.add(17);
		list.add(15);

		list.stream().filter(e -> prime(e)).forEach(System.out::println);

	}

}
