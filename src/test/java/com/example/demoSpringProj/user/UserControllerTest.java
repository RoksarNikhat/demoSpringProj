package com.example.demoSpringProj.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    private UserController userController;
    @Mock
    private UserService userServiceMock;

    @BeforeEach
    void setUp(){
        userController =new UserController(userServiceMock);
    }
    @Test
    void shouldSaveUserWithValidInput() throws Exception {
        User expectedUser= new User(1L,"Rahul","Verma","rv@gmail.com");
        when(userServiceMock.saveUser(any())).thenReturn(expectedUser);
        User user= new User(null,"Rahul","Verma","rv@gmail.com");
        try {
           User responseUser= userController.saveUser(user);
            verify(userServiceMock).saveUser(user);
            assertThat(responseUser,equalTo(expectedUser));
        } catch (Exception e) {
            fail("Save user should not throw exception for valid input ");
        }
    }

    @Test
    void shouldThrowException() throws Exception {

        when(userServiceMock.saveUser(any())).thenThrow(new RuntimeException("Custom Exception"));
        Exception e= assertThrows(RuntimeException.class,()-> {userController.saveUser(null);});
        assertThat(e.getMessage(), equalTo("Custom Exception"));



    }


}