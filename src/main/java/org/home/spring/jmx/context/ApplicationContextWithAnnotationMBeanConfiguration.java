package org.home.spring.jmx.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

@Configuration
@ComponentScan("org.home.spring.jmx.common")
@EnableMBeanExport
public class ApplicationContextWithAnnotationMBeanConfiguration {}
