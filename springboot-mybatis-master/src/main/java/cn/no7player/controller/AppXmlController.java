package cn.no7player.controller;

import cn.no7player.model.AppXmlEntity;
import cn.no7player.service.AppXmlService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class AppXmlController {

    private Logger logger = Logger.getLogger(AppXmlController.class);

    @Autowired
    private AppXmlService appXmlService;


    //根据ID获取当前xml的信息
    @RequestMapping("/api/getUser")
    public AppXmlEntity getAppXml(@RequestBody Map<String, Object> pd){
        if(pd!=null && !pd.isEmpty()) {
            return appXmlService.getAppXml(pd);
        }else {
            return null;
        }
    }
}
