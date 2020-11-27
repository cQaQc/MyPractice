package mybatis.dao;


import java.util.List;
import java.util.Map;

import mybatis.pojo.*;
import org.apache.ibatis.annotations.Select;

@SuppressWarnings("all")
public interface BookesDao {

    List<Bookes> find(Map map);

    List<Bookes> findU(int id);

    List<Bookes> getRowBounds();

    Admins getAById(int id);

    int addBook(Bookes book);

}
