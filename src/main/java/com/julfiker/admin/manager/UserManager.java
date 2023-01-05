package com.julfiker.admin.manager;

import com.julfiker.admin.dto.UserDto;
import com.julfiker.admin.entity.User;


import java.util.List;

public interface UserManager {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}