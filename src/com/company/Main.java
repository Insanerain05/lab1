package com.company;

public class Main {

    public static void main(String[] args) {
        int[] threadIds = {1, 2, 3, 4};
        int[] delays = {8000, 9000, 7000, 9000};
        int[] steps = {1, 2, 5, 7};

        BreakThread breakThread = new BreakThread(threadIds, delays);

        for (int i = 0; i < threadIds.length; i++) {
            new MainThread(threadIds[i], breakThread, steps[i]).start();
        }

        new Thread(breakThread).start();
    }
}
