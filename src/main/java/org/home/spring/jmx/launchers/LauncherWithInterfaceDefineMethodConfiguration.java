package org.home.spring.jmx.launchers;

import org.home.spring.jmx.context.ApplicationContext;

import static org.home.spring.jmx.context.MyProfile.INTERFACE_DEFINE;
import static org.home.spring.jmx.context.MyProfile.MANUALLY_CONFIGURED;

public class LauncherWithInterfaceDefineMethodConfiguration {
    public static void main(String... args) {
        new Launcher(
                ApplicationContext.class,
                MANUALLY_CONFIGURED,
                INTERFACE_DEFINE
        ).launch();
    }
}
