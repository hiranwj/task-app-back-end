package lk.hiranwj.app;

import lk.hiranwj.app.api.filter.SecurityFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

@Slf4j
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {   /* AACDSI */

    public WebAppInitializer() {
        log.debug("Spring starting...!");
        System.out.println("WebAppInitializer()");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {new SecurityFilter()};
    }
}
