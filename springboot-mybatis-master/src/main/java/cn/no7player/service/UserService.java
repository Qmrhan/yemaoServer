package cn.no7player.service;

import cn.no7player.mapper.UserMapper;
import cn.no7player.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserEntity queryUser(String ID) {
        return userMapper.queryUser(ID);
    }



}
