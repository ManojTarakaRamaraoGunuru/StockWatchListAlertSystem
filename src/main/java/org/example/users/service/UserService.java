package org.example.users.service;

import org.example.users.entity.User;
import org.example.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public static boolean validatePassword(String passwd) {
        String password_regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,20}$";
        Pattern pattern = Pattern.compile(password_regex);
        return pattern.matcher(passwd).matches();
    }

    public static boolean validateEmail(String email) {
        String email_regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
        Pattern pattern = Pattern.compile(email_regex, Pattern.CASE_INSENSITIVE);
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return pattern.matcher(email).matches();
    }

    public static String hashPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hashBytes = digest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    public static boolean validate(String data, String regex) {
        if (data == null || regex == null) {
            return false;
        }
        return Pattern.matches(regex, data);
    }

    public User signUp(User user) {
        this.validateSignup(user);
        user.setStatus(true);
        user.setPassword(UserService.hashPassword(user.getPassword()));
        return userRepository.save(user);
    }

    public User signIn(User user) {
        User existedUser = userRepository.findByUsername(user.getUsername());
        if (existedUser == null) {
            throw new RuntimeException("User does not exists");
        }

        if (!UserService.hashPassword(user.getPassword()).equals(existedUser.getPassword())) {
            throw new IllegalArgumentException("Password is incorrect");
        }
        return existedUser;
    }

    public void validateSignup(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("User already exists");
        }

        if (!validatePassword(user.getPassword())) {
            throw new IllegalArgumentException("Please enter a password that contains capital & small letters, numbers and special characters.");
        }

        if (!validateEmail(user.getEmail())) {
            throw new IllegalArgumentException("Please enter a valid email address");
        }
    }

        public List<User> getAllUsers(){
            return userRepository.findAll();
        }
}
