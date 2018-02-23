package consumerribbonhystrix.consumerribbonhystrixdemo;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private  DiscoveryClient client;

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbon-test",method = RequestMethod.GET)
    public String helloConsumer() {
        ServiceInstance instance=client.getLocalServiceInstance();
        return helloService.helloService();
    }
}
