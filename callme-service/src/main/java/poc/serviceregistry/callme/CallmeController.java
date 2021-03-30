package poc.serviceregistry.callme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callme")
public class CallmeController {

    @Value("${SPRING_CLOUD_CONSUL_DISCOVERY_INSTANCE_ID}")
    String instanceId;

    @Autowired
    Environment environment;

    @GetMapping
    public String call() {
        return "I'm "+instanceId+" running on port " + environment.getProperty("local.server.port");
    }

    @GetMapping("/slow")
    public String slow() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        return "I'm Slow "+instanceId+" running on port " + environment.getProperty("local.server.port");
    }

}
