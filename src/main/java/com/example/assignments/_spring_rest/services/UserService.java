package com.example.assignments._spring_rest.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.assignments._spring_rest.models.Address;
import com.example.assignments._spring_rest.models.User;
import com.example.assignments._spring_rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// TODO: Roles
// TODO: Mag niet gehele user zien. (password etc)

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(Long id, String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            Long userId = Long.parseLong(jwt.getAudience().get(0));
            User user = userRepository.findById(userId).get();
            if (user.getId() == id) {
                return user;
            } else {
                ArrayList<User> friends = user.getFriends();
                User foundUser = friends.stream().filter(friend -> friend.getId() == id).findFirst().get();
                return foundUser;
            }
        } catch (JWTVerificationException exception){
            return null;
        }
    }

    public void addUser(User user) {
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        user.setPassword(bcryptHashString);
        userRepository.save(user);
    }

    public void updateUser(String username, Address address, String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            Long userId = Long.parseLong(jwt.getAudience().get(0));
            User user = userRepository.findById(userId).get();
            user.setAddress(address);
            user.setUsername(username);
            userRepository.save(user);
        } catch (JWTVerificationException exception){
            return;
        }
    }

    public void addFriend(User newFriend, String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            Long userId = Long.parseLong(jwt.getAudience().get(0));
            User user = userRepository.findById(userId).get();
            ArrayList<User> friends = user.getFriends();
            friends.add(newFriend);
            user.setFriends(friends);
            userRepository.save(user);
        } catch (JWTVerificationException exception){
            return;
        }
    }

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username);
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
        if (result.verified) {
            try {
                Algorithm algorithm = Algorithm.HMAC256("secret");
                String token = JWT.create()
                        .withAudience(user.getId().toString())
                        .sign(algorithm);
                return token;
            } catch (JWTCreationException exception){
                return null;
            }
        }
        return null;
    }
}
