package com.company;

public class Main {
    public static void main(String[] args) {
        int[] threadIds = {1, 2, 3, 4};
        int[] delays = {8000, 2000, 5000, 1000};
        int[] steps = {1, 2, 5, 7};

        BreakThread breakThread = new BreakThread(threadIds, delays);

        for (int i = 0; i < threadIds.length; i++) {
            new MainThread(threadIds[i], steps[i], breakThread).start();
        }

        new Thread(breakThread).start();
    }
}
