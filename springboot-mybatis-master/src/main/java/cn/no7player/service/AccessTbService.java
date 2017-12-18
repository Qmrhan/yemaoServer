package cn.no7player.service;

import cn.no7player.mapper.AccessTbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccessTbService {
    @Autowired
    private AccessTbMapper accessTbMapper;

    public Map getDbcount(Map page) {
        Map acdata=new HashMap();
        if(page!=null && !page.isEmpty()) {
            acdata=accessTbMapper.getDbcount(page);
        }
        return acdata;
    }


    public int edit(Map page) {
        int oder=0;
        if(page!=null && !page.isEmpty()) {
            oder=accessTbMapper.edit(page);
        }
        return oder;
    }


    public int addaccess(Map page) {
        int oder=0;
        if(page!=null && !page.isEmpty()) {
            oder=accessTbMapper.addaccess(page);
        }
        return oder;
    }


    public int editcount(Map page) {
        int oder=0;
        if(page!=null && !page.isEmpty()){
            oder=accessTbMapper.editcount(page);
        }
        return oder;
    }
}
