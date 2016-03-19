package org.home.spring.jmx.common.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.home.spring.jmx.context.MyProfile.ANNOTATION_CONFIGURED;

@Profile(ANNOTATION_CONFIGURED)
@Component
@ManagedResource(
        objectName = "org.home.spring.jmx:name=AnnotatedJmxBean",
        description = "My bean which is able to stop the application"
)
public class AnnotatedJmxBean implements Stoppable {
    private final AtomicBoolean continueProcess;

    public AnnotatedJmxBean() {
        this.continueProcess = new AtomicBoolean();
    }

    @ManagedOperation(description = "The method prints provided line on the console.")
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "line", description = "The text which will be printed on the console")
    })
    public void print(String line) {
        System.out.println("Print line:" + line);
    }

    @ManagedOperation
    public void stop() {
        continueProcess.set(true);
    }

    @Override
    public boolean isStopped() {
        return continueProcess.get();
    }
}
