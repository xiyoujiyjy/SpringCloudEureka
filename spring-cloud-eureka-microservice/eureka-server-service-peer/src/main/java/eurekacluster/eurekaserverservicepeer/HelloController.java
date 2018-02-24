package eurekacluster.eurekaserverservicepeer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    private  DiscoveryClient client;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public  String hello() {
        ServiceInstance instance=client.getLocalServiceInstance();
        return  instance.getPort()+" Hello World ";
    }
    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public  String hello(@RequestParam String name) {
        ServiceInstance instance=client.getLocalServiceInstance();
        return  instance.getPort()+" Hello World "+name;
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public  User hello(@RequestHeader String name,@RequestHeader Integer age) {
        ServiceInstance instance=client.getLocalServiceInstance();
        User u=  new User(name,age);
        u.setPort(instance.getPort());
        return  u;
    }
    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public  String hello(@RequestBody User user) {
        ServiceInstance instance=client.getLocalServiceInstance();
        return  instance.getPort()+" Hello  "+user.getName()+","+user.getAge();
    }
}
