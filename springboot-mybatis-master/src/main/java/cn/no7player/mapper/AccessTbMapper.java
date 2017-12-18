package cn.no7player.mapper;

import java.util.Map;

public interface AccessTbMapper {
    public Map getDbcount(Map page);

    public int edit(Map page);

    public int addaccess(Map page);

    public int editcount(Map page);
}
