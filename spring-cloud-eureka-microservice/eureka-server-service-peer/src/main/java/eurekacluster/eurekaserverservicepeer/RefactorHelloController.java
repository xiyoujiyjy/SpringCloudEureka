package eurekacluster.eurekaserverservicepeer;

import com.yjy.dto.User;
import com.yjy.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController implements HelloService {

    @Autowired
    private DiscoveryClient client;
    @Override
    public  String hello(@RequestParam String name) {
        ServiceInstance instance=client.getLocalServiceInstance();
        return  instance.getPort()+" Hello World "+name;
    }

    @Override
    public  User hello(@RequestHeader String name, @RequestHeader Integer age) {
        ServiceInstance instance=client.getLocalServiceInstance();
        User u=  new User(name,age);
        u.setPort(instance.getPort());
        return  u;
    }
    @Override
    public  String hello(@RequestBody User user) {
        ServiceInstance instance=client.getLocalServiceInstance();
        return  instance.getPort()+" Hello  "+user.getName()+","+user.getAge();
    }
}
