package utils;

public class UtilsDate {

    public static String formatTime(long miliseconds) {
        int total_seconds = (int) miliseconds / 1000;
        int sec = total_seconds % 60;
        int min = (total_seconds / 60) % 60;
        int hours = (total_seconds / 60) / 60;
        return hours + "h:" + min + "m:" + sec + "s";
    }

}
