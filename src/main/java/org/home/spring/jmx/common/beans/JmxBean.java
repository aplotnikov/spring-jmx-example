package org.home.spring.jmx.common.beans;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class JmxBean implements InterfaceJmxBean {
    private final AtomicBoolean continueProcess;

    public JmxBean() {
        this.continueProcess = new AtomicBoolean();
    }

    public void print(String line) {
        System.out.println("Print line:" + line);
    }

    @Override
    public void stop() {
        continueProcess.set(true);
    }

    public boolean isStopped() {
        return continueProcess.get();
    }
}
