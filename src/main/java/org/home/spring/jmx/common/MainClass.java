package org.home.spring.jmx.common;

import org.home.spring.jmx.context.ApplicationContext;
import org.home.spring.jmx.context.MyProfile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String... args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles(MyProfile.CHOOSE_METHOD);
        //context.getEnvironment().setActiveProfiles(MyProfile.EXCLUDE_METHOD);
        //context.getEnvironment().setActiveProfiles(MyProfile.INTERFACE_DEFINE);

        context.register(ApplicationContext.class);
        context.refresh();

        context.getBean(MyThread.class);
    }
}
