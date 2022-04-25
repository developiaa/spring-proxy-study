package study.developia.proxy.config.v6_aop;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import study.developia.proxy.config.AppV1Config;
import study.developia.proxy.config.AppV2Config;
import study.developia.proxy.config.v6_aop.aspect.LogTraceAspect;
import study.developia.proxy.trace.logtrace.LogTrace;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AopConfig {

    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace) {
        return new LogTraceAspect(logTrace);
    }
}
