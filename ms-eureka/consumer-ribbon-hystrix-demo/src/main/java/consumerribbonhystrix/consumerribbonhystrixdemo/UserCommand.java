package consumerribbonhystrix.consumerribbonhystrixdemo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

public class UserCommand  extends HystrixCommand<User> {
     private RestTemplate restTemplate;
     private  Long id;
     public  UserCommand(RestTemplate restTemplate, Long id){
         super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("UserCommandGroup")));
         this.restTemplate=restTemplate;
         this.id=id;
     }
     @Override
     protected User run() throws Exception {
         return  restTemplate.getForObject("http://USER-SERVICE/users/{1}",User.class,id);
     }
     @Override
    protected User getFallback(){
        User u=  new User();
        u.setName("User Circute break");
        return  u;
     }
 }
