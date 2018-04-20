package com.bdqn.service;

import com.bdqn.entity.NewsUsers;

public interface UserService {

    NewsUsers login(String userName, String password);

}
