package cn.no7player.service;

import cn.no7player.mapper.UserMapper;
import cn.no7player.model.UserEntity;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

//    public UserEntity queryUser(String ID) {
//        return userMapper.queryUser(ID);
//    }

    public List queryUser(Map map) {
        List obj= userMapper.queryUser(map);
        return obj;
    }

    public int addUser(Map<String, String> map) {
            return  userMapper.addUser(map);
    }

}
