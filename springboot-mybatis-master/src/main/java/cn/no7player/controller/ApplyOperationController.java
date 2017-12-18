package cn.no7player.controller;

import cn.no7player.model.ApplyOperationEntity;
import cn.no7player.service.ApplyOperationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ApplyOperationController {

    private Logger logger = Logger.getLogger(ApplyOperationController.class);

    @Autowired
    private ApplyOperationService applyOperationService;

    //根据ID获取当前应用操作的信息
    @RequestMapping("/api/getApplyOperation")
    public ApplyOperationEntity getApplyOperation(@RequestBody Map<String, Object> pd){
        if(pd!=null && !pd.isEmpty()) {
            return applyOperationService.getApplyOperation(pd);
        }else{
            return null;
        }
    }
}
