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
    public void userListToUserDtoList() {
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(new User());
        users.add(new User());
        users.add(new User());
        users.add(new User());

        List<UserDTO> userDTOS = userMapper.toDto(users);

        assertEquals(users.size(), userDTOS.size());
        assertEquals(users.get(DEFAULT_ID.intValue()).getEmail(), userDTOS.get(DEFAULT_ID.intValue()).getEmail());
        assertEquals(users.get(DEFAULT_ID.intValue()).getUserName(), userDTOS.get(DEFAULT_ID.intValue()).getUserName());
        assertEquals(users.get(DEFAULT_ID.intValue()).getPassword(), userDTOS.get(DEFAULT_ID.intValue()).getPassword());
        assertEquals(users.get(DEFAULT_ID.intValue()).getFirstName(), userDTOS.get(DEFAULT_ID.intValue()).getFirstName());
        assertEquals(users.get(DEFAULT_ID.intValue()).getLastName(), userDTOS.get(DEFAULT_ID.intValue()).getLastName());

    }

    @Test
    public void userDTOListToUserList() {
        List<UserDTO> userDTOS = new ArrayList<>();
        userDTOS.add(userDTO);
        userDTOS.add(new UserDTO());
        userDTOS.add(new UserDTO());
        userDTOS.add(new UserDTO());
        userDTOS.add(new UserDTO());

        List<User> users = userMapper.toEntity(userDTOS);

        assertEquals(users.size(), userDTOS.size());
        assertEquals(users.get(DEFAULT_ID.intValue()).getEmail(), users.get(DEFAULT_ID.intValue()).getEmail());
        assertEquals(users.get(DEFAULT_ID.intValue()).getUserName(), users.get(DEFAULT_ID.intValue()).getUserName());
        assertEquals(users.get(DEFAULT_ID.intValue()).getPassword(), users.get(DEFAULT_ID.intValue()).getPassword());
        assertEquals(users.get(DEFAULT_ID.intValue()).getFirstName(), users.get(DEFAULT_ID.intValue()).getFirstName());
        assertEquals(users.get(DEFAULT_ID.intValue()).getLastName(), users.get(DEFAULT_ID.intValue()).getLastName());
    }

    @Test
    public void fromId() {
        assertEquals(userMapper.fromId(DEFAULT_ID).getId(), DEFAULT_ID);
    }
}
