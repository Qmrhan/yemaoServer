package cn.no7player.mapper;

import cn.no7player.model.ApplyInformationEntity;

import java.util.Map;

public interface ApplyInformationMapper {
    public ApplyInformationEntity getApplyInformation(Map page);

    public String getDbPower(Map page);
}
