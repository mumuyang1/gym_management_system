package com.tw.core.dao;

import com.tw.core.dao.hibernateDao.GenericityInterface;
import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by yzli on 8/4/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
@Transactional

public class CourseDaoTest {

    @Autowired
    private GenericityInterface<Course> genericityInterface;

    @BeforeClass
    public static void setSystemProperty() {
        System.setProperty("databaseConfig", "database-test");
    }


    @Test
    public void test_get_data_function() {

        List<Course> courseList = genericityInterface.getDataList(Course.class);

        assertEquals("游泳", courseList.get(1).getName());
    }

    @Test
    public void test_insert_data_function() {

        Course course = new Course(new Employee(2), "滑雪");

        genericityInterface.insertData(course);

        assertEquals("滑雪", genericityInterface.getDataList(Course.class).get(2).getName());
        assertEquals(3, genericityInterface.getDataList(Course.class).size());
    }

    @Test
    public void test_delete_data_function() {

        Course course = new Course(1);
        genericityInterface.deleteData(course);

        assertEquals(1, genericityInterface.getDataList(Course.class).size());
    }

    @Test
    public void test_update_data_function() {

        Course course = new Course(1, "哑铃", new Employee(1));
        genericityInterface.updateData(course);

        assertEquals("哑铃", genericityInterface.getDataList(Course.class).get(0).getName());
    }
}
