package ncu.dao;

import ncu.entity.Impression;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ImpressionDao {
    void add(@Param("impression") Impression impression);
    void delete(@Param("fromId") String fromId, @Param("toId") String toId);
    void modify(@Param("impression") Impression impression);
    List<Impression> queryByFromId(String fromId);
    List<Impression> queryByToId(String toId);
    Impression query(@Param("fromId") String fromId, @Param("toId") String toId);
}
