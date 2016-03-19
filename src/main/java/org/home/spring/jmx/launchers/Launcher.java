package org.home.spring.jmx.launchers;

import org.home.spring.jmx.common.beans.Stoppable;
import org.home.spring.jmx.common.thread.MyThread;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Nonnull;

public class Launcher {
    private final Stoppable stoppableBean;

    public Launcher(@Nonnull Class<?> applicationContext, @Nonnull String... profiles) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles(profiles);
        context.register(applicationContext);

        context.refresh();

        stoppableBean = context.getBean(Stoppable.class);
    }

    public void launch() {
        new MyThread(stoppableBean);
    }
}
