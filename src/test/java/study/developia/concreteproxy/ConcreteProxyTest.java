package study.developia.concreteproxy;

import org.junit.jupiter.api.Test;
import study.developia.concreteproxy.code.ConcreteClient;
import study.developia.concreteproxy.code.ConcreteLogic;
import study.developia.concreteproxy.code.TimeProxy;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreteLogic);
        concreteClient.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient concreteClient = new ConcreteClient(timeProxy);
        concreteClient.execute();
    }
}
