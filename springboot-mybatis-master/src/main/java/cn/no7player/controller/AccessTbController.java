package cn.no7player.controller;

import cn.no7player.Util.wangyi.UuidUtil;
import cn.no7player.service.AccessTbService;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AccessTbController {

    private Logger logger = Logger.getLogger(AccessTbController.class);

    @Autowired
    private AccessTbService accessTbService;

    @RequestMapping("/api/geterror")
    @ResponseBody
    public JSONObject geterror(@RequestBody Map<String, Object> pd){
        JSONObject obj = new JSONObject();
        if(pd!=null && !pd.isEmpty()) {
            //返回的成功，还是失败
            if("Success".equals(pd.get("code"))){
                //如果返回成功
                //查询有没有这段操作的记录
                Map jsdata=accessTbService.getDbcount(pd);
                if(jsdata!=null && !jsdata.isEmpty()) {
                    //如果有，修改这条记录信息的type
                    Map updata=new HashMap();
                    updata.put("ID",jsdata.get("ID"));
                    updata.put("TYPE","2");
                    Integer i=accessTbService.edit(updata);
                    if(i>1){
                        obj.put("mgs","操作成功");
                        obj.put("code",200);
                    }
                }else {
                    //如果没有成功的记录信息,创建一条成功状态的记录信息,并且返回200通过
                    Map adddata=new HashMap();
                    UuidUtil uti=new UuidUtil();
                    adddata.put("ID",uti.get32UUID());
                    adddata.put("ACCESS_NAME",pd.get("ACCESS_NAME"));
                    adddata.put("ACCESS_TIME",new Date());
                    adddata.put("COUNTS",1);
                    adddata.put("TYPE","2");
                    adddata.put("INFORMATION_CODE",pd.get("INFORMATION_CODE"));
                    adddata.put("CID",pd.get("CID"));
                    Integer i=accessTbService.addaccess(adddata);
                    if(i>1){
                        obj.put("mgs","操作成功");
                        obj.put("code",200);
                    }
                }

            }else {
                //如果返回失败
                //查询有没有这段操作的记录
                Map jsdata=accessTbService.getDbcount(pd);
                if(jsdata!=null && !jsdata.isEmpty()) {
                    //如果超过三次，直接返回301，并且返回错误信息三次操作失败
                    int conut= Integer.getInteger(jsdata.get("counts").toString());
                    if(conut>=3){
                        obj.put("mgs","超过三次请求，都失败，请查看原因");
                        obj.put("code",400);
                    }else {
                        //没有超过三次
                        //如果有,修改这条记录的操作次数,并且返回201
                        Map upcout=new HashMap();
                        upcout.put("ID",jsdata.get("ID"));
                        Integer i=accessTbService.editcount(upcout);
                        if(i>1){
                            obj.put("mgs","请再次请求");
                            obj.put("code",201);
                        }

                    }
                }else {
                    //如果没有，创建一条操作失败的信息，并且记录当前操作第几次
                    Map addondata=new HashMap();
                    UuidUtil uti=new UuidUtil();
                    addondata.put("ID",uti.get32UUID());
                    addondata.put("ACCESS_NAME",pd.get("ACCESS_NAME"));
                    addondata.put("ACCESS_TIME",new Date());
                    addondata.put("COUNTS",1);
                    addondata.put("TYPE","0");
                    addondata.put("INFORMATION_CODE",pd.get("INFORMATION_CODE"));
                    addondata.put("CID",pd.get("CID"));
                    //记录失败信息
                    Integer i=accessTbService.addaccess(addondata);
                    if(i>1){
                        obj.put("mgs","请再次请求");
                        obj.put("code",201);
                    }
                }
            }
        }else {
            obj.put("data",pd);
            obj.put("mgs","请求的参数为空");
        }
        return obj;
    }
}
