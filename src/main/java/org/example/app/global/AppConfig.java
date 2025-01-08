package org.example.app.global;

public class AppConfig {

    private static String mode;
    private static String dbMode;

    static {
        setDevMode(); // mode를 디폴트 값으로 지정
        setFileDbMode();
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

    public static void setFileDbMode() {
        dbMode = "file";
    }
    public static void setMemDbMode() {
        dbMode = "mem";
    }
    public static boolean isFileDb() {
        return dbMode.equals("file");
    }
    public static boolean isMemDb() {
        return dbMode.equals("mem");
    }

    public static String getDbPath() {
        return "db/" + mode;
    }
}
