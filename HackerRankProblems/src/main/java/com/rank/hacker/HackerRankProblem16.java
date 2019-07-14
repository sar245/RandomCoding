package com.rank.hacker;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HackerRankProblem16 {
	// Complete the birthday function below.
	static int birthday(List<Integer> s, int d, int m) {
		int count = 0;
		List<List<Integer>> lists =
				IntStream.rangeClosed(0, 1)
						.mapToObj(i -> s.subList(i, (i+m > s.size())?s.size():(i+m)))
						.collect(Collectors.toList());
		
		for (List<Integer> list : lists) {
			int sum = list.stream().reduce(0, (a, b) -> a + b);
			if (sum == d) count++;
		};
		
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int d = Integer.parseInt(dm[0]);

		int m = Integer.parseInt(dm[1]);

		int result = birthday(s, d, m);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
