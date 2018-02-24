package consumerribbonhystrix.consumerribbonhystrixdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "userInfo",method = RequestMethod.GET)
    public  String nameConsumer(){
       UserCommand userCommand=new UserCommand(restTemplate,1L);
        //userCommand.queue().get().getName();
       return  userCommand.execute().getName();
    }
}
