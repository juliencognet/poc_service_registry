package pl.piomin.services.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Provider;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/service-info")
public class RestController {

    @Autowired
    private DiscoveryClient discoveryClient;


    public String serviceUrl(String serviceId) {
        List<ServiceInstance> list = discoveryClient.getInstances(serviceId);
        String serviceUrls="";
        for (ServiceInstance serviceInstance : list) {
            serviceUrls += serviceInstance.getUri();
        }
        return serviceUrls;
    }

    @GetMapping("/callme")
    public String getCallMeUrls(){
        return serviceUrl("callme-service");
    }

    @GetMapping("/caller")
    public String getCallerUrls(){
        return serviceUrl("caller-service");
    }




}
