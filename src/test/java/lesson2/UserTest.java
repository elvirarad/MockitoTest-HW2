package lesson2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.lesson2.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserTest {

    private static User user1;
    private static User user2;

    static User user;

    @BeforeAll
    public static void initParam() {
        System.out.println("Start testing");
        user1 = new User();
        user2 = new User("word781", 33,"1@mail.ru");
    }

    @AfterAll
    private static void shouldDoAfterAll(){
        System.out.println(("Finish testing"));
    }

    @Test
    void shouldBeEmptyParameters(){
        assertFalse(user2.getName() != null && user2.getEmail() == null);
    }

    @Test
    void shouldBeNonEmptyParameters(){
        assertTrue(user1.getName() == null && user1.getEmail() == null);
    }

    @Test
    void shouldThrowException(){
        System.out.println("ThrowException");
        assertThrows(IllegalArgumentException.class, ()-> new User("123", "mail.ru"));
    }

    @Test
    void shouldLoginEqualEmailThrowException(){
        System.out.println("ThrowExceptionEqual");
        assertThrows(IllegalArgumentException.class, ()-> new User("123456", "123456"));
    }

    @Test
    public void testCreateUserWithParameters(){
        assertTrue(user2.getEmail() != null && user2.getName() != null);
    }

    @Test
    public void testCreateUserWithoutParameters(){
        assertTrue(user1.getEmail() == null && user1.getName() == null);
    }

    @Test
    public void testCreateCorrectUser(){
        assertEquals(new User("word781", 33, "1@mail.ru"), user2);
    }

    @Test
    public void testNotValidUserParametersThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> new User("test", 35, "testtest.ru"));
    }

    @Test
    void testIfValidationWasCalled(){
        //setup
        User user = spy(User.class);
        String testEmail = "test12@test.ru";
        //run
        user.setEmail(testEmail);
        //assert
        verify(user, atLeast(1)).validationEmail(testEmail);
    }

    @Test
    public void testIfValidationEmailWasCalledWhenValidateParameterWasCalled(){
        User user = mock(User.class);
        String testEmail = "test@test.ru";

        user.validationParameter("test", 33, testEmail);

        verify(user, atLeast(1)).validationParameter("test", 33, testEmail);
    }

}
