package cn.no7player.service;

import cn.no7player.mapper.ApplyInformationMapper;
import cn.no7player.model.ApplyInformationEntity;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApplyInformationService {

    @Autowired
    private ApplyInformationMapper applyInformationMapper;


    public ApplyInformationEntity getApplyInformation(Map page) {
        ApplyInformationEntity applyinfor=null;
        if(page!=null && !page.isEmpty()) {
            applyinfor= applyInformationMapper.getApplyInformation(page);
        }
        return applyinfor;
    }


    public String getDbPower(Map page) {
        Map obj=new HashMap();
        if(page!=null && !page.isEmpty()) {
            if(applyInformationMapper.getDbPower(page)!=null){
                obj.put("mgs","success");
                obj.put("code","200");
            }else {
                obj.put("mgs","fail");
                obj.put("code","400");
            }
        }
        return JSONArray.toJSONString(obj);
    }

}
