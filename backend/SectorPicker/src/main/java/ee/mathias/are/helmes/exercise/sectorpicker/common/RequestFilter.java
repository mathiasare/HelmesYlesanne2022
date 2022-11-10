package ee.mathias.are.helmes.exercise.sectorpicker.common;

import ee.mathias.are.helmes.exercise.sectorpicker.common.session.SessionContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class RequestFilter implements Filter {

    private final SessionContext sessionContext;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        sessionContext.setSessionId();
        HttpServletRequest req = (HttpServletRequest) request;
        log.info("Incoming: {} {}", req.getMethod(), req.getRequestURI());
        try {
            chain.doFilter(request, response);
        } finally {
            sessionContext.clear();
        }
    }
}
