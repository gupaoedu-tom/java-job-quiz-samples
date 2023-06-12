package com.gupaoedu.job.quiz.node3;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class DruidTest {

    public class StatViewServlet extends HttpServlet {

    }

    public class WebStatFilter implements Filter{

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        }
    }


    @Configuration
    public class Druidconfig {

        @Bean
        public ServletRegistrationBean statViewServlet () {
            ServletRegistrationBean srb =
                    new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
            //设置控制台管理用户
            srb.addInitParameter("loginUsername","root");
            srb.addInitParameter("loginPassword","root" );
            //是否可以重置数据
            srb.addInitParameter("resetEnable","false");
            return srb;
        }

        /**
         * 注册FilterRegistrationBean
         * @return
         */
        @Bean
        public FilterRegistrationBean druidstatFilter(){
            FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
            //添加过滤规则
            bean.addUrlPatterns("/*");
            //添加不需要忽略的格式信息
            bean.addInitParameter("exclusions",
                    "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

            return bean;
        }
    }
}
