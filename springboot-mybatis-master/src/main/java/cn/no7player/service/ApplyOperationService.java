package cn.no7player.service;

import cn.no7player.mapper.ApplyOperationMapper;
import cn.no7player.model.ApplyOperationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ApplyOperationService {

    @Autowired
    private ApplyOperationMapper applyOperationMapper;

    public ApplyOperationEntity getApplyOperation(Map page) {
        ApplyOperationEntity applyoper=null;
        if(page!=null && !page.isEmpty()) {
            applyoper=applyOperationMapper.getApplyOperation(page);
        }
        return applyoper;
    }
}
