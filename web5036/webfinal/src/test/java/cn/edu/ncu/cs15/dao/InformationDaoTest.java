package cn.edu.ncu.cs15.dao;

import cn.edu.ncu.cs15.TestBase;
import cn.edu.ncu.cs15.entity.Information;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class InformationDaoTest extends TestBase{
    @Autowired
    private InformationDao informationDao;

    @Test
    public void add() {
        Information information = new Information();
        information.setUserId("asdf");
        informationDao.add(information);
    }
}
