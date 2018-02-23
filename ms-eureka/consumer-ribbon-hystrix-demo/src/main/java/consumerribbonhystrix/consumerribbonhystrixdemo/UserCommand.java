package consumerribbonhystrix.consumerribbonhystrixdemo;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

public class UserCommand  extends HystrixCommand<User> {
     private RestTemplate restTemplate;
     private  Long id;
     public  UserCommand(Setter setter,RestTemplate restTemplate, Long id){
         super(setter);
         this.restTemplate=restTemplate;
         this.id=id;
     }
     @Override
     protected User run() throws Exception {
         return  restTemplate.getForObject("http://USER-SERVICE/users/{1}",User.class,id);
     }
     @Override
    protected User getFallback(){
        return  new User();
     }
 }
