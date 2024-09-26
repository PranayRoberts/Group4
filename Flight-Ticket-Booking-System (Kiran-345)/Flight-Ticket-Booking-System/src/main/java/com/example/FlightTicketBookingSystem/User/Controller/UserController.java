package com.example.FlightTicketBookingSystem.User.Controller;

import com.example.FlightTicketBookingSystem.User.Model.User;
import com.example.FlightTicketBookingSystem.User.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/")
public class UserController {

    UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "get_user/")
    public List<User> getValue() {
        return service.getUser();
    }

    @GetMapping(path = "get_user/{id}")
    public User getValueById(@PathVariable Integer id) {
        return service.getUserById(id);
    }

    @PostMapping(path = "register/")
    public User registerUser(@RequestBody User person) {
        return service.registerUser(person);
    }

    @PutMapping(path = "login/")
    public User loginUser(@RequestParam(required = true) String userValue,
                          @RequestBody(required = true) String password) {
        return service.loginUser(userValue, password);
    }

    @PostMapping(path = "forgot_password/")
    public Integer forgotPassword(@RequestParam(required = false) Integer id,
                                  @RequestParam(required = false) String userValue1,
                                  @RequestBody(required = false) String userValue2) {

        return service.forgotPassword(id, userValue1, userValue2);
    }

    @PutMapping(path = "update_user/")
    public User updateUser(@RequestParam(required = true) Integer id,
                           @RequestBody(required = true) User user){
        return service.UpdateUser(id,user);
    }
}
