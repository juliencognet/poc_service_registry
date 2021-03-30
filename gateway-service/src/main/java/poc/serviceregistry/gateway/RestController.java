package poc.serviceregistry.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Provider;
import java.util.List;
import java.util.Map;

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
            for (Map.Entry<String, String> entry : serviceInstance.getMetadata().entrySet()) {
                String s = entry.getKey();
                String s2 = entry.getValue();
                serviceUrls += " " + s + "=>" + s2;
            }
            serviceUrls +=" | ";
        }
        return serviceUrls;
    }

    @GetMapping("/callme")
    public String getCallMeUrls(){
        return serviceUrl("callme-service");
    }

    @GetMapping("/caller24")
    public String getCallerUrls(){
        return serviceUrl("caller24-service");
    }




}
