package mybatis.dao;

import mybatis.pojo.Admins;
import mybatis.pojo.Bookes;

import java.util.List;
import java.util.Map;

public interface AdminDao {
    List<Admins> find();
    Bookes getB(int id);

    List<Admins> getLike(String s);

    int add(Admins admins);

    int addByMap(Map<String,Object> map);
}
