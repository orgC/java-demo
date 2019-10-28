package com.banzaicloud;

import java.util.Vector;

public class mm {

    private static float CAP = 0.8f;  // 80%
    private static int ONE_MB = 1024 * 1024;

    private static Vector cache = new Vector();

    public static void main(String[] args) throws InterruptedException {
        Runtime rt = Runtime.getRuntime();

        long maxMemBytes = rt.maxMemory();
        long usedMemBytes = rt.totalMemory() - rt.freeMemory();
        long freeMemBytes = rt.maxMemory() - usedMemBytes;

        int allocBytes = Math.round(freeMemBytes * CAP);

        System.out.println("Initial free memory: " + freeMemBytes/ONE_MB + "MB");
        System.out.println("Max memory: " + maxMemBytes/ONE_MB + "MB");

        System.out.println("Reserve: " + allocBytes/ONE_MB + "MB");

        for (int i = 0; i < allocBytes / ONE_MB; i++){
            cache.add(new byte[ONE_MB]);
        }

        usedMemBytes = rt.totalMemory() - rt.freeMemory();
        freeMemBytes = rt.maxMemory() - usedMemBytes;

        while (true){
            Thread.sleep(1000);
            System.out.println("Max memory: " + maxMemBytes/ONE_MB + "MB" +
                    " , Free memory: " + freeMemBytes/ONE_MB + "MB");

        }


    }
}