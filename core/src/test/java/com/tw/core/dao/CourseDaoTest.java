package com.tw.core.dao;

import com.tw.core.dao.hibernateDao.GenericityInterface;
import com.tw.core.entity.Course;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by yzli on 8/4/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:src/main/webapp/WEB-INF/spring-servlet.xml")
//@ContextConfiguration(locations = "classpath*:/spring-servlet.xml")
@Transactional
public class CourseDaoTest {

    @Autowired
    private GenericityInterface<Course> genericityInterface;

    @BeforeClass
    public void setSystemProperty(){
        System.setProperty("databaseConfig","database-test");
    }

    @Test
    public void test() {

        List<Course> courseList = genericityInterface.getDataList(Course.class);

        System.out.println(courseList.get(0).getEmployee().getName());

        assertTrue(true);
    }


}
