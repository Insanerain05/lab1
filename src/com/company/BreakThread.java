package com.company;

import java.util.concurrent.ConcurrentHashMap;

public class BreakThread implements Runnable {
    private final ConcurrentHashMap<Integer, Boolean> canBreakMap = new ConcurrentHashMap<>();
    private final int[] threadIds;
    private final int[] delays;

    public BreakThread(int[] threadIds, int[] delays) {
        this.threadIds = threadIds;
        this.delays = delays;
    }

    @Override
    public void run() {
        for (int i = 0; i < threadIds.length; i++) {
            int threadId = threadIds[i];
            int delay = delays[i];
            try {
                Thread.sleep(delay);
                canBreakMap.put(threadId, true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isCanBreak(int id) {
        return canBreakMap.getOrDefault(id, false);
    }
}
