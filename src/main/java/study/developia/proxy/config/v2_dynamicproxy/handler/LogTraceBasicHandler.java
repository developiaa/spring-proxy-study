package study.developia.proxy.config.v2_dynamicproxy.handler;

import study.developia.proxy.trace.TraceStatus;
import study.developia.proxy.trace.logtrace.LogTrace;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogTraceBasicHandler implements InvocationHandler {

    private final Object target;
    private final LogTrace logTrace;

    public LogTraceBasicHandler(Object target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        TraceStatus status = null;
        try {
            String message = method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()";
            status = logTrace.begin(message);
            // target 호출
            Object invoke = method.invoke(target, objects);
            logTrace.end(status);
            return invoke;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
