package org.home.spring.jmx.launchers;

import org.home.spring.jmx.context.ApplicationContext;

import static org.home.spring.jmx.context.MyProfile.EXCLUDE_METHOD;
import static org.home.spring.jmx.context.MyProfile.MANUALLY_CONFIGURED;

public class LauncherWithExcludedMethodConfiguration {
    public static void main(String... args) {
        new Launcher(
                ApplicationContext.class,
                MANUALLY_CONFIGURED,
                EXCLUDE_METHOD
        ).launch();
    }
}
