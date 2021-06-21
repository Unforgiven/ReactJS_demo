package ru.softlab.REST_demo.service;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.softlab.REST_demo.domain.User;
import ru.softlab.REST_demo.repos.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserService() {
    }

    public ResponseEntity<Iterable<User>> findAll() {

        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<User> findById(Long id) {

        return new ResponseEntity<>(userRepo.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<User> findByUsername(String username) {

        return new ResponseEntity<>(userRepo.findByUsername(username), HttpStatus.OK);
    }

    public ResponseEntity<User> create(User user) {
        if(userRepo.findByUsername(user.getUsername()) != null)
            return new ResponseEntity<>(userRepo.findByUsername(user.getUsername()), HttpStatus.CONFLICT);

        return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
    }

    public ResponseEntity<User> update(User user) {
        return new ResponseEntity<>(userRepo.save(user), HttpStatus.OK);
    }


    public ResponseEntity<String> auth(User user) {
        JSONObject jsonObject = new JSONObject();

        try {
            if (userRepo.findByUsername(user.getUsername()).getPassword().equals(user.getPassword())) {
                jsonObject.put("authStatus", "OK");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }

    public String delete(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            userRepo.delete(userRepo.findById(id).get());
            jsonObject.put("message", "User was deleted");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
