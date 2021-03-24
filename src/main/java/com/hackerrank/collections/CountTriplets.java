package com.hackerrank.collections;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountTriplets {
    public static class Solution {

        // Complete the countTriplets function below.
        static int countTriplets(List<Long> arr, long r) {
            Map<Long, Integer> map = IntStream.range(0, arr.size())
                    .boxed()
                    .collect(Collectors.toMap(arr::get, i -> i));
            int count = 0;

            for (int i = 0; i < arr.size(); i++) {
                if (map.containsKey(arr.get(i) * r) && map.get(arr.get(i) * r) > i &&
                        map.containsKey(arr.get(i) * r * r) && map.get(arr.get(i) * r * r) > map.get(arr.get(i) * r))
                    count++;
            }

            return count;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(nr[0]);

            long r = Long.parseLong(nr[1]);

            List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Long::parseLong)
                    .collect(toList());

            long ans = countTriplets(arr, r);

            bufferedWriter.write(String.valueOf(ans));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
