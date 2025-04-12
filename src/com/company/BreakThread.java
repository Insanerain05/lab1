package com.company;

import java.util.Arrays;
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
        ThreadDelay[] threadDelays = new ThreadDelay[threadIds.length];
        for (int i = 0; i < threadIds.length; i++) {
            threadDelays[i] = new ThreadDelay(threadIds[i], delays[i]);
        }

        Arrays.sort(threadDelays);

        for (ThreadDelay threadDelay : threadDelays) {
            int threadId = threadDelay.id;
            try {
                Thread.sleep(threadDelay.delay);
                canBreakMap.put(threadId, true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isCanBreak(int id) {
        return canBreakMap.getOrDefault(id, false);
    }

    private static class ThreadDelay implements Comparable<ThreadDelay> {
        private final int id;
        private final int delay;

        public ThreadDelay(int id, int delay) {
            this.id = id;
            this.delay = delay;
        }

        @Override
        public int compareTo(ThreadDelay o) {
            return Integer.compare(this.delay, o.delay);
        }
    }
}
