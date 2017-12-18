package cn.no7player.controller;

import cn.no7player.model.UserEntity;
import cn.no7player.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by zl on 2015/8/27.
 */
@Controller
@RequestMapping({ "/user" })
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/getUserInfo"})
    @ResponseBody
    public UserEntity getUserInfo(@RequestParam(value = "ID", required = true) String ID) {
        return userService.queryUser(ID);
    }
}
