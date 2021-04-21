package my.play.ground.testset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Generator {
    public static void main(String[] args) {
        String s = matrix(200, 200);
        System.out.println(s);
    }

    public static String matrix(int rol, int col) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < rol; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < col; j++) {
                int n = rand.nextInt(200) + 1;
                matrix.get(i).add(n);
            }
        }
        List<String> a = new ArrayList<>();
        a.stream().collect(Collectors.joining());

        String s1 = matrix.stream()
                .map(list -> {
                    String s2 = list.stream()
                            .map(n -> String.valueOf(n))
                            .collect(Collectors.joining(","));
                    return "[" + s2 + "]";
                })
                .collect(Collectors.joining(","));
        s1 = "[" + s1 + "]";
        return s1;
    }
}
