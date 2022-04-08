package vttp.demo.login.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class LoginFilter implements Filter {

    // type "doFilter" to autocomplete method
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // cast
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpResp = (HttpServletResponse) response;

        // get the HTTP session
        HttpSession session = httpReq.getSession();

        // check for authentication
        String username = (String) session.getAttribute("username");
        // remember what object you saved in session, else ClassCastException
        if ((username == null) || username.isBlank()) {
            httpResp.sendRedirect("/");
        }

        // pass forward to next filter
        // MUST HAVE, if not request does not reach controllers
        chain.doFilter(request, response);
    }
}
