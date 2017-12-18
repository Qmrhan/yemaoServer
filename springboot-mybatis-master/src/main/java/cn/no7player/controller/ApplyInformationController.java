package cn.no7player.controller;

import cn.no7player.model.ApplyInformationEntity;
import cn.no7player.service.ApplyInformationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ApplyInformationController {

    private Logger logger = Logger.getLogger(ApplyInformationController.class);

    @Autowired
    private ApplyInformationService applyInformationService;

    //根据ID获取当前应用的信息
    @RequestMapping("/api/getApplyInformation")
    @ResponseBody
    public ApplyInformationEntity getApplyInformation(@RequestBody Map<String, Object> pd){
        if(pd!=null && !pd.isEmpty()){
            return applyInformationService.getApplyInformation(pd);
        }else {
            return null;
        }

    }



    //根据当前传入的应用授权码验证当前应用是否可以操作数据库
    @RequestMapping("/api/getDbPower")
    @ResponseBody
    public String grtDbPower(@RequestBody Map<String, Object> pd){
        if(pd!=null && !pd.isEmpty()) {
            return applyInformationService.getDbPower(pd);
        }else {
            return null;
        }
    }

}
