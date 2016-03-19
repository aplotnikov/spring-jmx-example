package org.home.spring.jmx.common.thread;

import org.home.spring.jmx.common.beans.Stoppable;

public class MyThread implements Runnable {
    private final Stoppable stoppableBean;

    public MyThread(Stoppable stoppableBean) {
        this.stoppableBean = stoppableBean;

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("My Thread was launched!");

        while (!stoppableBean.isStopped()) {
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

        System.out.println("My Thread was stopped!");
    }
}
