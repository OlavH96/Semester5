package rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.data.Password;
import rest.data.User;
import rest.util.TokenGenerator;

import java.util.HashMap;
import java.util.Map;

@RestController("/") // Hvis man har /login her funker det ikke V(^-^)V
public class LoginController {

    Map<String, User> users = new HashMap<>();

    @GetMapping("/test")
    public String test(){
        return "Test!";
    }
    
    @PostMapping("/login/")
    public boolean create(@RequestBody Map<String, String> newUser){

        System.out.println("\nNEW USER"+newUser+"\n");

        Password password = Password.generate(newUser.get("password"));

        if (users.containsKey(newUser.get("username"))) return false;

        users.putIfAbsent(newUser.get("username"), new User(newUser.get("username"),  password));

        System.out.println(users.get(newUser.get("username"))+"\n");
        return true;
    }

    @GetMapping("/login/{username}")
    public String login(@PathVariable String username,  @RequestHeader("password") String password) {

        /*System.out.println(request.getHeaders());
        String password = request.getHeaders().get("password").get(0);
*/
        System.out.println("\nLOGGING IN: "+username+" - psw: "+password);

        User user1 = users.get(username);

        boolean passwordIsCorrect = (user1 != null) && user1.authenticate(password);
        String token = TokenGenerator.generate(username);
        if (passwordIsCorrect) {
            System.out.println("Password Correct");
            return token;
        }
        else {
            System.out.println("Password Wrong");
            return "NO"; // Litt halvveis
        }
    }

    @GetMapping("/login/{username}/test")
    public ResponseEntity<String> testToken(@PathVariable String username, @RequestHeader("token") String token) {

        System.out.println("\nTesting token: "+ token);

        User user1 = users.get(username);

        if (user1 != null) {

            if (TokenGenerator.validate(token)) {

                return ResponseEntity.ok().build();
            }
        }

        return ResponseEntity.badRequest().build();
    }
}