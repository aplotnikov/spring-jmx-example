package org.home.spring.jmx.launchers;

import org.home.spring.jmx.context.ApplicationContext;

import static org.home.spring.jmx.context.MyProfile.CHOOSE_METHOD;
import static org.home.spring.jmx.context.MyProfile.MANUALLY_CONFIGURED;

public class LauncherWithChosenMethodConfiguration {
    public static void main(String... args) {
        new Launcher(
                ApplicationContext.class,
                MANUALLY_CONFIGURED,
                CHOOSE_METHOD
        ).launch();
    }
}
