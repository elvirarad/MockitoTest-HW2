package lesson2;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lesson2.User;
import org.lesson2.UserDao;
import org.lesson2.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDao dao;

    @InjectMocks
    private UserService userService;

    @Test
    public void checkIfUserExistTrue() {

        when(dao.getUserByName("test12")).thenReturn(new User("test12"));

        boolean userExist = userService.checkUserExist(
                new User("test12"));

        verify(dao, times(1)).getUserByName("test12");
        assertTrue(userExist);
    }

    @Test
    public void checkIfUserExistFalse() {

        when(dao.getUserByName("test12")).thenReturn(null);

        boolean userExist = userService.checkUserExist(
                new User("test12"));

        assertFalse(userExist);
    }

}
