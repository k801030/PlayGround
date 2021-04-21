package my.play.ground;

public class Solution {
    private static final int HOURS = 12;
    private static final int MINUTES = 60;
    private static final int FULL_ANGLE = 360;
    private static final int HALE_ANGLE = 180;

    public int ClockAngle(int hour, int minute) {
        if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60) return -1;

        int minuteAngle = FULL_ANGLE / MINUTES * minute;
        int hourAngle = hour * FULL_ANGLE / HOURS + minute * FULL_ANGLE / (HOURS * MINUTES);

        int angle = Math.abs(minuteAngle - hourAngle);
        return angle > HALE_ANGLE ? FULL_ANGLE - angle : angle;
    }
}

/*
test cases:
 - [12,0] -> 0
 - [6,0] -> 180
 - [9,0] -> 90
 - [12,5] -> | 360*5/(12*60) - 360/60*5 |
 - [12,10] -> | 360*5/(12*60) - 360/60*5 |
 - [12,30] -> 180-15
 - [-1,0] -> -1
 - [1, 60] -> -1
 */
