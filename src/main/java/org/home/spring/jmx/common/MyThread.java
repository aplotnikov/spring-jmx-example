package org.home.spring.jmx.common;

import org.home.spring.jmx.common.beans.JmxBean;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class MyThread implements Runnable {
    private final JmxBean jmxBean;

    @Inject
    public MyThread(JmxBean jmxBean) {
        this.jmxBean = jmxBean;

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("My Thread was launched!");

        while (!jmxBean.isStopped()) {
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

        System.out.println("My Thread was stopped!");
    }
}
