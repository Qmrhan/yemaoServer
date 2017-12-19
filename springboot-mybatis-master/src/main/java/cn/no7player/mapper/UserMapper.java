
package cn.no7player.mapper;

import cn.no7player.model.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by zl on 2015/8/27.
 */
public interface UserMapper {
    public List queryUser(Map map);
    public int addUser(Map<String, String> map);
}
