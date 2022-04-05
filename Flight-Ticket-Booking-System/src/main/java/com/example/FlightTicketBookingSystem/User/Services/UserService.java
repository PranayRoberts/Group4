package com.example.FlightTicketBookingSystem.User.Services;

import com.example.FlightTicketBookingSystem.User.Model.Contact;
import com.example.FlightTicketBookingSystem.User.Model.User;
import com.example.FlightTicketBookingSystem.User.Repository.ContactRepository;
import com.example.FlightTicketBookingSystem.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    ContactRepository contactRepository;

    public UserService() {
    }

    @Autowired
    public UserService(UserRepository userRepository,ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
    }

    public User registerUser(User user) {
        Optional<User> userName = userRepository.findUserByUserName(user.getUserName());
        if (userName.isPresent())
            throw new IllegalStateException("Username already exists!");
        Optional<User> email = userRepository.findUserByEmail(user.getEmail());
        if (email.isPresent())
            throw new IllegalStateException("email already exists!");
        return userRepository.save(user);
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }
    public User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return user.get();
        }
        else throw new IllegalStateException("User doesn't exists");
    }

    public User loginUser(String userValue, String password) {

        Optional<User> userName = userRepository.findUserByUserName(userValue);
        Optional<User> email = userRepository.findUserByEmail(userValue);

        //checking for username and password
        if (userName.isPresent()) {
            if (userName.get().getPassword().equals(password))
                return userName.get();
            else
                throw new IllegalStateException("please check username and password");
        }
        //checking for email and password
        else if (email.isPresent()) {
            if (email.get().getPassword().equals(password))
                return email.get();
            else
                throw new IllegalStateException("please check email and password");
        }
        else
            throw new IllegalStateException("user doesn't exists!");


    }

    @Transactional
    public Integer forgotPassword(Integer id, String userValue1, String userValue2) {
        if (userValue1!=null && id==null && userValue2==null){
            Optional<User> userName = userRepository.findUserByUserName(userValue1);
            Optional<User> email = userRepository.findUserByEmail(userValue1);

            //checking for username and password
            if (userName.isPresent()) {
                return userName.get().getId();
            }
            //checking for email and password
            else if (email.isPresent()) {
                return email.get().getId();
            }
            else
                throw new IllegalStateException("user doesn't exists!");
        }
        else if(userValue1==null && id!=null && userValue2!=null){
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()){
                user.get().setPassword(userValue2);
                return 0;
            }
        }
        return -1;
    }


    @Transactional
    public User UpdateUser(Integer id,User user){
        Optional<User> u = userRepository.findById(id);
        u.get().setFirstName(user.getFirstName());
        u.get().setLastName(user.getLastName());
        u.get().setPassword(user.getPassword());

        Contact contact =contactRepository.getById(u.get().getContact().getId());
        contact.setAddressLine(user.getContact().getAddressLine());
        contact.setCity(user.getContact().getCity());
        contact.setState(user.getContact().getState());
        contact.setCountry(user.getContact().getCountry());
        contact.setZipCode(user.getContact().getZipCode());
        contact.setMobileNo(user.getContact().getMobileNo());
        return u.get();
    }
}
