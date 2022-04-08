package vttp.demo.login;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vttp.demo.login.filters.LoginFilter;

// boilerplate for registering filters

@Configuration
public class AppConfig {

    @Bean
    public FilterRegistrationBean<LoginFilter> registerFilters() {
        // create an instance of LoginFilter
        LoginFilter filter = new LoginFilter();

        // create an instance of registration bean
        FilterRegistrationBean<LoginFilter> loginFilter = new FilterRegistrationBean<>();
        loginFilter.setFilter(filter);
        loginFilter.addUrlPatterns("/protected/*");

        return loginFilter;
    }
}
