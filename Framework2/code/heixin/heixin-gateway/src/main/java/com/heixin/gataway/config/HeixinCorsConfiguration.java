package com.heixin.gataway.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class HeixinCorsConfiguration {

    @Bean
    public FilterRegistrationBean  corsFilter(){
        //初始化cors配置对象
        CorsConfiguration configuration = new CorsConfiguration();
        //允许跨域的域名，如果要携带cookie，不能写*。  *：代表所有域名都可以跨域访问
        configuration.addAllowedOrigin("http://manage.heixin.com:9001");
        configuration.addAllowedOrigin("http://manage.heixin.com");
        configuration.addAllowedOrigin("http://www.heixin.com");
        configuration.setAllowCredentials(true);//允许携带cookie
        configuration.addAllowedMethod("*");//代表所有的请求方法 GET POST.....
        configuration.addAllowedHeader("*");//允许携带任何头信息

        //初始化cors配置源对象
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**",configuration);

        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(configurationSource));
        // 这个顺序很重要哦，为避免麻烦请设置在最前
        bean.setOrder(0);
        return bean;
    }
}
