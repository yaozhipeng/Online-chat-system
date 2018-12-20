package ncu.dao;

import ncu.entity.Relation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationDao {
    void add(@Param("relation") Relation relation);
    void delete(@Param("fromId") String fromId, @Param("toId") String toId);
    void modifyState(@Param("fromId") String fromId, @Param("toId") String toId, @Param("state") Integer state);
    List<Relation> queryByFromId(String fromId);
    List<Relation> queryByToId(String toId);
}
