//package com.loveincode.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity // 注解开启Spring Security的功能
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .antMatchers("/person","/person/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                ////以上代码指定了/和/home不需要任何认证就可以访问，其他的路径都必须通过身份验证。
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                //定义当需要用户登录时候，转到的登录页面。
//            .logout()
//                .permitAll();
//    }
//	
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//	  return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
//	
////    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }
//
//}