package com.scs.soft.zhihu.api.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

/**
 * @author ABC
 * @date 2020/1/16 16:57
 */
@Configuration
public class CorsConfig {
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        //鏀捐鎵€鏈夎法鍩熺殑瀹㈡埛绔痙omain
        config.addAllowedOrigin("*");
        //鍏佽鐨勮姹傛柟娉曞垪琛�
        String[] requestMethods = {"GET", "POST", "PUT", "DELETE", "OPTIONS"};
        List<String> allowedRequestMethods = Arrays.asList(requestMethods);
        config.setAllowedMethods(allowedRequestMethods);
        //鍏佽鐨勫鎴风璇锋眰澶村垪琛�
        String[] requestHeaders = {"x-requested-with", "Content-Type", "Access-Token"};
        List<String> allowedHeaders = Arrays.asList(requestHeaders);
        config.setAllowedHeaders(allowedHeaders);
        //鍏佽鐨勫搷搴斿ご鍒楄〃
        String[] responseHeaders = {"Access-Control-Expose-Headers", "Access-Token"};
        List<String> allowedExposedHeaders = Arrays.asList(responseHeaders);
        config.setExposedHeaders(allowedExposedHeaders);
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        // 杩欎釜椤哄簭寰堥噸瑕�,璁剧疆鍦ㄦ渶鍓�
        bean.setOrder(0);
        return bean;
    }
}