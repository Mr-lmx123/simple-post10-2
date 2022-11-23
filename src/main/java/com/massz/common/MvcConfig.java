package com.massz.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    private String path = "E:/upload/images/";
    /**
     * 文件资源过滤器
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //其中filePath表示访问的前缀。"file:E:/upload/images/"是文件真实的存储路径
        registry.addResourceHandler("/filePath/**").addResourceLocations("file:" + path);
    }
}
