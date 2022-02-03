//package com.nurgunmakarov.spring;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Description;
//import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
//
//public class SpringTemplateEngine {
//    @Bean
//    @Description("Thymeleaf Template Resolver")
//    public ServletContextTemplateResolver templateResolver() {
//        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
//        templateResolver.setPrefix("/WEB-INF/views/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//
//        return templateResolver;
//    }
//}
