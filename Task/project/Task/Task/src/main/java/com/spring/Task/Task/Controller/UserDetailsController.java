package com.spring.Task.Task.Controller;


import com.spring.Task.Task.model.User;
import com.spring.Task.Task.service.User_Service;
import io.netty.handler.codec.http.HttpHeaders;
import org.asynchttpclient.*;
import org.asynchttpclient.proxy.ProxyServer;
import org.asynchttpclient.util.HttpConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@RestController
@RequestMapping("System/")//vodafone Orange Etisalat
public class UserDetailsController {


    private User_Service User_Service;



    @Autowired
    public UserDetailsController(User_Service UserService) {
        this.User_Service = UserService;
    }


    //AsyncHttpClient but not use
    public void FUN() throws ExecutionException, InterruptedException {

        DefaultAsyncHttpClientConfig.Builder clientBuilder = Dsl.config()
                .setConnectTimeout(500)
               ;
        AsyncHttpClient client = Dsl.asyncHttpClient(clientBuilder);
        Request getRequest = new RequestBuilder(HttpConstants.Methods.GET)
                .setUrl("http://www.baeldung.com")
                .build();
        getRequest = Dsl.get("http://www.baeldung.com").build();

        /*
        Future<Response> responseFuture = boundGetRequest.execute();
        responseFuture.get();

        Future<Response> responseFuture = client.executeRequest(unboundRequest);
        responseFuture.get();

*/
// bound
        Future<Response> whenResponse =client.prepareGet("http://www.example.com/").execute();

// unbound
    //    Request request = get("http://www.example.com/").build();
      //   whenResponse = client.executeRequest(request);
        whenResponse = client.prepareGet("http://www.example.com/").execute();
        Response response = whenResponse.get();

        Future<Integer> whenStatusCode = client.prepareGet("http://www.example.com/")
                .execute(new AsyncHandler<Integer>() {
                    private Integer status;
                    @Override
                    public State onStatusReceived(HttpResponseStatus responseStatus) throws Exception {
                        status = responseStatus.getStatusCode();
                        return State.ABORT;
                    }
                    @Override
                    public State onHeadersReceived(HttpHeaders headers) throws Exception {
                        return State.ABORT;
                    }
                    @Override
                    public State onBodyPartReceived(HttpResponseBodyPart bodyPart) throws Exception {
                        return State.ABORT;
                    }
                    @Override
                    public Integer onCompleted() throws Exception {
                        return status;
                    }
                    @Override
                    public void onThrowable(Throwable t) {
                    }
                });

        Integer statusCode = whenStatusCode.get();


    }


    // http://localhost:8080/System/users
    @GetMapping("users")
    public List<User> getUsers()
    {
        return User_Service.getUsers();
    }

    // http://localhost:8080/System/user?id=12
    @GetMapping("user")
    public User getUserById (@RequestParam Long id){
        return User_Service.getUserById(id);
    }

    // http://localhost:8080/System/users
    @PostMapping("users")
    public User saveUser(@RequestBody User user){
        return User_Service.saveUser(user);
    }

    // http://localhost:8080/System/users?id=12
    @PutMapping("users")
    public User editUser(@RequestBody User user,@RequestParam Long id){
        user.setId(id);
        return User_Service.saveUser(user);
    }
    @DeleteMapping("user")
    public void removeUser(@RequestParam Long id){
        User_Service.removeUser(id);
    }



}
