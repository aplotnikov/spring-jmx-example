package org.home.spring.jmx.launchers;

import org.home.spring.jmx.context.ApplicationContextWithAnnotationMBeanConfiguration;

import static org.home.spring.jmx.context.MyProfile.ANNOTATION_CONFIGURED;

public class LauncherWithAnnotationMBeanConfiguration {
    public static void main(String... args) {
        new Launcher(
                ApplicationContextWithAnnotationMBeanConfiguration.class,
                ANNOTATION_CONFIGURED
        ).launch();
    }
}
