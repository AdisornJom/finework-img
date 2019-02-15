package com.fineworkimg.jsf.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author teerawat
 */
@WebFilter(filterName = "CacheFilter", urlPatterns = {"/*"})

public class CacheFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String uri = ((HttpServletRequest) request).getRequestURI();
        uri = StringUtils.lowerCase(uri);
        if (!uri.contains(".js") && !uri.contains(".css") && !uri.contains(".svg") && !uri.contains(".gif") && !uri.contains(".woff")
                && !uri.contains(".png") && !uri.contains(".ttf") && !uri.contains(".jpg") && !uri.contains(".jpeg")) {
            httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            httpResponse.setHeader("Pragma", "no-cache");
            httpResponse.setHeader("Expires", "0");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Cache Filter started: ");
    }

    @Override
    public void destroy() {
    }
}
