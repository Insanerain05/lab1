package com.company;

public class MainThread extends Thread {
    private final int id;
    private final BreakThread breakThread;
    private final int step;

    public MainThread(int id, BreakThread breakThread, int step) {
        this.id = id;
        this.breakThread = breakThread;
        this.step = step;
    }

    @Override
    public void run() {
        long sum = 0;
        int count = 0;
        int value = 0;

        while (!breakThread.isCanBreak(id)) {
            sum += value;
            value += step;
            count++;
        }

        System.out.println("Потік " + id + ": Сума = " + sum + ", Доданків = " + count);
    }
}
