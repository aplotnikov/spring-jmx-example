package org.home.spring.jmx.context;

import org.home.spring.jmx.common.beans.Stoppable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodExclusionMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodNameBasedMBeanInfoAssembler;

import java.util.HashMap;
import java.util.Map;

import static org.home.spring.jmx.context.MyProfile.CHOOSE_METHOD;
import static org.home.spring.jmx.context.MyProfile.EXCLUDE_METHOD;
import static org.home.spring.jmx.context.MyProfile.INTERFACE_DEFINE;

@Configuration
@ComponentScan("org.home.spring.jmx.common")
public class ApplicationContext {
    @Bean
    public MBeanExporter jmxBeansExporter(MBeanInfoAssembler assembler, Stoppable stoppable) {
        Map<String, Object> beans = new HashMap<>();
        beans.put("org.home.spring.jmx:name=" + stoppable.getClass().getSimpleName(), stoppable);

        MBeanExporter exporter = new MBeanExporter();
        exporter.setBeans(beans);
        exporter.setAssembler(assembler);

        return exporter;
    }

    @Profile(CHOOSE_METHOD)
    @Bean
    public MethodNameBasedMBeanInfoAssembler methodNameBasedMBeanInfoAssembler() {
        MethodNameBasedMBeanInfoAssembler assembler = new MethodNameBasedMBeanInfoAssembler();

        assembler.setManagedMethods(new String[]{
                "print", "stop"
        });

        return assembler;
    }

    @Profile(EXCLUDE_METHOD)
    @Bean
    public MethodExclusionMBeanInfoAssembler methodExclusionMBeanInfoAssembler() {
        MethodExclusionMBeanInfoAssembler assembler = new MethodExclusionMBeanInfoAssembler();

        assembler.setIgnoredMethods("print");

        return assembler;
    }

    @Profile(INTERFACE_DEFINE)
    @Bean
    public InterfaceBasedMBeanInfoAssembler assembler() {
        InterfaceBasedMBeanInfoAssembler assembler = new InterfaceBasedMBeanInfoAssembler();

        assembler.setManagedInterfaces(new Class<?>[]{
                Stoppable.class
        });

        return assembler;
    }
}
