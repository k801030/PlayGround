package my.play.ground;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class EqualsApp {
    public static void main(String[] args) {
        String a = "123", b = "123";
        b = "12" + "3";

        StringBuilder sb = new StringBuilder();
        sb.append("123");


        log.info("a.equals(b): {}", a.equals(b));
        log.info("a.equals(\"123\") {}", a.equals("123"));

        log.info("a == valueOf(123): {}", a == String.valueOf(123));
        log.info("a == b: {}", a == b);
        log.info("a == \"123\": {}", a == "123");

        log.info("a.equals(sb.toString()): {}", a.equals(sb.toString()));
        log.info("a == sb.toString(): {}", a == sb.toString());

        Team teamA = new Team("taipei", "marketing");
        Team teamB = new Team("taipei", "marketing");
        log.info("teamA == teamB: {}", teamA == teamB);
        log.info("teamA.equals(teamB): {}", teamA.equals(teamB));

        Map<Team, Integer> map = new HashMap<>();
        map.put(teamA, 1);
        log.info("containsKey teamA: {}", map.containsKey(teamA));
        log.info("containsKey teamB: {}", map.containsKey(teamB));
    }
}

class Team {

    String city;
    String department;

    public Team(String city, String department) {
        this.city = city;
        this.department = department;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return true;

        Team t = (Team) o;
        boolean cityEquals = this.city  == t.city;
        boolean departmentEquals = this.department == t.department;
        return  cityEquals && departmentEquals;
    }
}