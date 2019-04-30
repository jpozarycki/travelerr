package com.pozarycki.travelerr.service.mapper;

import com.pozarycki.travelerr.domain.User;
import com.pozarycki.travelerr.domain.dto.UserDTO;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class UserMapperTest {

    private static final String DEFAULT_USERNAME = "default username";
    private static final String DEFAULT_PASSWORD = UUID.randomUUID().toString();
    private static final String DEFAULT_FIRST_NAME = "default first name";
    private static final String DEFAULT_LAST_NAME = "default last name";
    private static final String DEFAULT_EMAIL = "default@email.com";
    private static final Long DEFAULT_ID = 1L;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    private User user;
    private UserDTO userDTO;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setId(DEFAULT_ID);
        user.setUserName(DEFAULT_USERNAME);
        user.setEmail(DEFAULT_EMAIL);
        user.setFirstName(DEFAULT_FIRST_NAME);
        user.setLastName(DEFAULT_LAST_NAME);
        user.setPassword(DEFAULT_PASSWORD);

        userDTO = new UserDTO(user);
    }

    @Test
    public void userToUserDTO() throws Exception {
        UserDTO userDTOTest = userMapper.toDto(user);

        assertEquals(DEFAULT_ID, userDTOTest.getId());
        assertEquals(DEFAULT_FIRST_NAME, userDTOTest.getFirstName());
        assertEquals(DEFAULT_LAST_NAME, userDTOTest.getLastName());
        assertEquals(DEFAULT_EMAIL, userDTOTest.getEmail());
        assertEquals(DEFAULT_PASSWORD, userDTOTest.getPassword());
        assertEquals(DEFAULT_USERNAME, userDTOTest.getUserName());
    }

    @Test
    public void userDTOToUser() throws Exception {
        User userTest = userMapper.toEntity(userDTO);

        assertEquals(DEFAULT_ID, userTest.getId());
        assertEquals(DEFAULT_FIRST_NAME, userTest.getFirstName());
        assertEquals(DEFAULT_LAST_NAME, userTest.getLastName());
        assertEquals(DEFAULT_EMAIL, userTest.getEmail());
        assertEquals(DEFAULT_PASSWORD, userTest.getPassword());
        assertEquals(DEFAULT_USERNAME, userTest.getUserName());
    }

    @Test
    public void userListToUserDtoList() throws Exception {
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(new User());
        users.add(new User());
        users.add(new User());
        users.add(new User());

        List<UserDTO> userDTOS = userMapper.toDto(users);

        assertEquals(users.size(), userDTOS.size());
        assertEquals(users.get(0).getEmail(), users.get(0).getEmail());
        assertEquals(users.get(0).getUserName(), users.get(0).getUserName());
        assertEquals(users.get(0).getPassword(), users.get(0).getPassword());
        assertEquals(users.get(0).getFirstName(), users.get(0).getFirstName());
        assertEquals(users.get(0).getLastName(), users.get(0).getLastName());

    }

    @Test
    public void userDTOListToUserList() throws Exception {
        List<UserDTO> userDTOS = new ArrayList<>();
        userDTOS.add(userDTO);
        userDTOS.add(new UserDTO());
        userDTOS.add(new UserDTO());
        userDTOS.add(new UserDTO());
        userDTOS.add(new UserDTO());

        List<User> users = userMapper.toEntity(userDTOS);

        assertEquals(users.size(), userDTOS.size());
        assertEquals(users.get(0).getEmail(), users.get(0).getEmail());
        assertEquals(users.get(0).getUserName(), users.get(0).getUserName());
        assertEquals(users.get(0).getPassword(), users.get(0).getPassword());
        assertEquals(users.get(0).getFirstName(), users.get(0).getFirstName());
        assertEquals(users.get(0).getLastName(), users.get(0).getLastName());
    }

    @Test
    public void fromId() throws Exception {
        assertEquals(userMapper.fromId(DEFAULT_ID).getId(), DEFAULT_ID);
    }
}
