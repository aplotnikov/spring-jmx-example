package org.home.spring.jmx.common.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.home.spring.jmx.context.MyProfile.MANUALLY_CONFIGURED;

@Profile(MANUALLY_CONFIGURED)
@Component
public class JmxBean implements Stoppable {
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

    @Override
    public boolean isStopped() {
        return continueProcess.get();
    }
}
