package ee.mathias.are.helmes.exercise.sectorpicker.common.session;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SessionContext {
    private static final ThreadLocal<String> context = new ThreadLocal<>();
    private static final String SESSION_ID = "sessionId";

    public void setSessionId() {
        String sessionId = generateSessionId();
        context.set(sessionId);
        MDC.put(SESSION_ID, sessionId);
    }

    public String getSessionId() {
        return context.get();
    }

    public void clear() {
        context.remove();
        MDC.remove(SESSION_ID);
    }

    private String generateSessionId() {
        return UUID.randomUUID().toString();
    }
}