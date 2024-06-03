package com.rafi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationsOfIntegersWithSumAs10 {

	static int streamCount = 0;

	public static void main(String[] args) {

		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		Map<Integer, List<Integer>> combinationsWithSum10 = new HashMap<>();
		Map<Integer, List<Integer>> combinationsWithSum10WithStreams = new HashMap<>();

		int count = 0;
		for (int i : numbers) {
			for (int j : numbers) {

				if (i + j == 10) {
					count++;
					combinationsWithSum10.put(count, List.of(i, j));
				}

			}
		}

		System.out.println("combinations with for loop => "+combinationsWithSum10);

		numbers.stream().forEach(num -> {
			streamCount++;
			numbers.stream().forEach(innerNum -> {
				if (num + innerNum == 10) {
					setStreamCount();
					combinationsWithSum10WithStreams.put(getStreamCount(), List.of(num, innerNum));
				}
			});
		});

		System.out.println("combinations with stream => "+combinationsWithSum10);
	}

	public static int getStreamCount() {

		return streamCount;
	}

	public static void setStreamCount() {
		streamCount+=1;
	}

}
