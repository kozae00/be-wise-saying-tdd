package org.example.app.global;

public class AppConfig {

    private static String mode;

    static {
        setDevMode(); // mode를 디폴트 값으로 지정
    }

    public static void setProdMode() {
        mode = "prod";
    }

    public static void setDevMode() {
        mode = "dev";
    }

    public static void setTestMode() {
        mode = "test";
    }

    public static boolean isProdMode() {
        return mode.equals("prod");
    }

    public static boolean isDevMode() {
        return mode.equals("dev");
    }

    public static boolean isTestMode() {
        return mode.equals("test");
    }

    public static String getDbPath() {
        return "db/" + mode;
    }
}
