package met.local.service;


import met.local.model.Role;
import met.local.model.User;
import met.local.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void saveUserTest() {
        User user = new User();
        Role role = new Role();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        role.setName("ROLE_USER");
        user.setPassword(passwordEncoder.encode("test"));
        user.setEmail("test@test.com");


        when(userRepository.save(user)).thenReturn(user);
        System.out.println(user);
        assertEquals(user, userService.saveUser(user));
    }

    @Test
    void getUserByEmailTest() {
        String email = "bojana32@yahoo.com";

        User user = new User();
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        user.setPassword("sifra");
        user.setEmail(email);


        when(userRepository.findByEmail(email)).thenReturn(user);

        User actualUser = userRepository.findByEmail(email);


        assertEquals(user, actualUser);
        assertEquals(email, actualUser.getEmail());
    }



}
