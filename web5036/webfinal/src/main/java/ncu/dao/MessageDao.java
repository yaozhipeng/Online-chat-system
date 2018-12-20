package ncu.dao;

import ncu.entity.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageDao {
    void add(@Param("message") Message message);
    void delete(@Param("message") Message message);
    List<Message> queryNewByFromId(@Param("fromId") String fromId, @Param("n") int n);
    List<Message> queryNewByToId(@Param("toId") String toId, @Param("n") int n);
    List<Message> queryAll(@Param("fromId") String fromId, @Param("toId") String toId);
}
