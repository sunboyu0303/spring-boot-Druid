package com.jd.test.springboot.druid.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created by sunboyu on 2017/10/12.
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "exclusions", value = "*.js, *.gif, *.jpg, *.bmp, *.png, *.css, *.ico, /druid/*")
        }
)
public class DruidStatFilter extends WebStatFilter {
}
