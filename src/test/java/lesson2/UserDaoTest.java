package lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.lesson2.User;
import org.lesson2.UserDao;
import org.lesson2.UserDaoImpl;

import java.util.stream.Stream;

import static lesson2.UserTestConstants.*;

public class UserDaoTest {

    private final UserDao dao = new UserDaoImpl();

    @Test
    public void testUserByUsername() {

        User user = dao.getUserByName("Tom");

        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.getName(), "Tom");
    }

    @Test
    public void testUserByNameIsNull() {
        Assertions.assertNull(dao.getUserByName("person"));
    }

    @MethodSource("provideArgumentsForUserDaoTests")
    @ParameterizedTest
    public void testUserByUsername(String name) {
        User user = dao.getUserByName(name);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.getName(), name);
    }

    @MethodSource("provideWrongArgumentsForUserDaoTests")
    @ParameterizedTest
    public void testUserByNameIsNull(String name){
        Assertions.assertNull(dao.getUserByName(name));
    }

    private static Stream<Arguments> provideArgumentsForUserDaoTests(){
        return Stream.of(
                Arguments.of(USER_NAME_1),
                Arguments.of(USER_NAME_2)
        );
    }

    private static Stream<Arguments> provideWrongArgumentsForUserDaoTests(){
        return Stream.of(
                Arguments.of(USER_NAME_3),
                Arguments.of(USER_NAME_4)
        );
    }

}