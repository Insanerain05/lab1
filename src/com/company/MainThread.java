package com.company;

public class MainThread extends Thread {
    private final int id;
    private final int step;
    private final BreakThread breakThread;

    public MainThread(int id, int step, BreakThread breakThread) {
        this.id = id;
        this.step = step;
        this.breakThread = breakThread;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        long sum = 0;
        int count = 0;
        int value = 0;

        while (!breakThread.isCanBreak(id)) {
            sum += value;
            value += step;
            count++;

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Потік " + id + ": Сума = " + sum + ", Доданків = " + count + ", Час = " + duration + " мс");
    }
}
