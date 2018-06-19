package com.loveincode.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.SessionListener;

/** 
 * @Description: JAVAMELODY监控配置 
 * 
 * 访问 http://localhost:8080/monitoring
 */  
@Configuration  
public class JavamelodyConfiguration {  
  
    @Bean  
    public FilterRegistrationBean monitorFilter(){  
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MonitoringFilter());  
        filterRegistrationBean.addUrlPatterns("/*");  
        return filterRegistrationBean;  
    }  
  
    @Bean  
    public ServletListenerRegistrationBean sessionListener(){  
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();  
        servletListenerRegistrationBean.setListener(new SessionListener());  
        return servletListenerRegistrationBean;  
    }  
  
}  
