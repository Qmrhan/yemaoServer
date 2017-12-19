package cn.no7player.controller;

import cn.no7player.Util.wangyi.UuidUtil;
import cn.no7player.model.UserEntity;
import cn.no7player.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zl on 2015/8/27.
 */
@RestController
@RequestMapping(value="userController")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //@RequestMapping(value={"/getUserInfo"})
    //@ResponseBody
//    public UserEntity getUserInfo(@RequestParam(value = "ID", required = true) String ID) {
//        return userService.queryUser(ID);
//    }


    @RequestMapping(value = "addUser")
    public Map addUser(String name,String password,String phone) {
        Map<String, String> resultObj = new HashMap<>();
        Map udata=new HashMap();
        udata.put("name",name);
        udata.put("password",password);
        udata.put("phone",phone);
        try{
            if(udata != null && !udata.isEmpty()){
                List<Object> resultList = userService.queryUser(udata);
                if (resultList.size()> 0) {
                    resultObj.put("mgs", "用户已存在");
                    resultObj.put("code", "401");
                }else{
                    Map dat=new HashMap();

                    String a=udata.get("name")+"";
                    String b=udata.get("password")+"";
                    String pass = new SimpleHash("SHA-1",udata.get("name").toString(),udata.get("password")).toString();
                    dat.put("password",pass);
                    dat.put("phone",udata.get("phone"));
                    dat.put("ID",UuidUtil.get32UUID());
                    dat.put("name",udata.get("name"));
                    dat.put("create_time",new Date());

                    Integer i = userService.addUser(dat);

                    if(i>=1){
                        resultObj.put("mgs","操作成功");
                        resultObj.put("code","200");
                    }else {
                        resultObj.put("mgs","添加失败");
                        resultObj.put("code","403");
                    }
                }
            }else{
                resultObj.put("msg" , "注册信息不存在！");

                return resultObj;
            }


        }catch(Exception e){
            resultObj.clear();
            resultObj.put("mgs","严重的错误！");
            resultObj.put("code", "");
            return  resultObj;

        }
        return resultObj;

    }
}

