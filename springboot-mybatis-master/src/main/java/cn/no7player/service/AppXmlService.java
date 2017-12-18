package cn.no7player.service;

import cn.no7player.mapper.AppXmlMapper;
import cn.no7player.model.AppXmlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AppXmlService {

    @Autowired
    private AppXmlMapper appXmlMapper;

    public AppXmlEntity getAppXml(Map page) {
        AppXmlEntity appxm=null;
        if(page!=null && !page.isEmpty()) {
            appxm= appXmlMapper.getAppXml(page);
        }
        return appxm;
    }
}
