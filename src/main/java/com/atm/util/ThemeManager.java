package com.atm.util;

public class ThemeManager {

    private static boolean darkMode = false;

    public static boolean isDarkMode() {
        return darkMode;
    }

    public static void toggleDarkMode() {
        darkMode = !darkMode;
    }
}