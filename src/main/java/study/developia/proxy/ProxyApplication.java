package study.developia.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import study.developia.proxy.config.AppV1Config;
import study.developia.proxy.config.AppV2Config;
import study.developia.proxy.config.v1_proxy.ConcreteProxyConfig;
import study.developia.proxy.config.v1_proxy.InterfaceProxyConfig;
import study.developia.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import study.developia.proxy.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import study.developia.proxy.trace.logtrace.LogTrace;
import study.developia.proxy.trace.logtrace.ThreadLocalLogTrace;

//@Import(AppV1Config.class)
//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
@Import(DynamicProxyFilterConfig.class)
@SpringBootApplication(scanBasePackages = "study.developia.proxy.app") //주의
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}

}
