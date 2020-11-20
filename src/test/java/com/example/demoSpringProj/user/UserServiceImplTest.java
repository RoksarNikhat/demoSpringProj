package com.example.demoSpringProj.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepositoryMock;

    @BeforeEach
    void setUp(){
        userService =new UserServiceImpl(userRepositoryMock);
    }

    @Test
    void shouldSaveUserWithValidInput(){
        User user= new User(null,"Rahul","Verma","rv@gmail.com");
        try {
            userService.saveUser(user);
            verify(userRepositoryMock).save(user);
        } catch (Exception e) {
            fail("Save user should not throw exception for valid input ");
        }

    }


}