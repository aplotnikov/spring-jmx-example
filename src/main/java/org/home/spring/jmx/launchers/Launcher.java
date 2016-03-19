package org.home.spring.jmx.launchers;

import org.home.spring.jmx.common.thread.MyThread;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Nonnull;

public class Launcher {
    private final AnnotationConfigApplicationContext context;

    public Launcher(@Nonnull Class<?> applicationContext, @Nonnull String... profiles) {
        context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles(profiles);
        context.register(applicationContext);

        context.refresh();
    }

    public void launch() {
        context.getBean(MyThread.class);
    }
}
