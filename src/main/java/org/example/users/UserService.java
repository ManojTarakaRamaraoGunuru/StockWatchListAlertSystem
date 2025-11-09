package org.example.users;

import org.example.constants.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    public static boolean validate(String data, String regex) {
        if (data == null || regex == null) {
            return false;
        }
        return Pattern.matches(regex, data);
    }

    public User signUp(User user) {
        this.validateSignup(user);
        user.setStatus(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(Roles.USER));
        return userRepository.save(user);
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

    public List<User> getAllUsers() {
            return userRepository.findAll();
        }
}
