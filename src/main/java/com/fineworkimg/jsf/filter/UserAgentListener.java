package com.fineworkimg.jsf.filter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

/**
 *
 * @author Aekasit
 */
public class UserAgentListener implements Filter {

    private ServletContext context;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        String agent = ((HttpServletRequest) req).getHeader("User-Agent");
        if (agent != null) {
            boolean match = false;
            Map<String, Integer> agents = (Map) context.getAttribute("browserStats");

            for (Map.Entry<String, Integer> entry : agents.entrySet()) {
                String key = entry.getKey();
                if (agent.indexOf(key) != -1) {
                    Integer value = agents.get(key);
                    agents.put(key, ++value);
                    match = true;
                    break;
                }
            }

            if (match == false) {
                Integer value = agents.get("Other");
                agents.put("Other", ++value);
            }

            EventBus eventBus = EventBusFactory.getDefault().eventBus();
            eventBus.publish("/browser", agents);
        }

        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Map<String, Integer> agents = new LinkedHashMap<String, Integer>();
        agents.put("MSIE", 0);
        agents.put("Firefox", 0);
        agents.put("Chrome", 0);
        agents.put("Safari", 0);
        agents.put("Other", 0);

        context = filterConfig.getServletContext();
        context.setAttribute("browserStats", agents);
    }

    @Override
    public void destroy() {

    }
}
