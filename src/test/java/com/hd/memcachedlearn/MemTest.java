/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hd.memcachedlearn;

import com.google.code.ssm.mapper.JsonObjectMapper;
import com.google.code.ssm.transcoders.JsonTranscoder;
import com.hd.memcachedlearn.dao.RainDao;
import com.hd.memcachedlearn.entity.RainHour;
import com.hd.memcachedlearn.service.IRainService;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Administrator
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//@Ignore
public class MemTest {

    private RainDao rainDao;
    private IRainService rainService;
    private JsonTranscoder transcoder;

    @Before
    public void setUp() {
        rainDao = (RainDao) SpringContextUtil.getBean("rainDao");
        rainService = (IRainService) SpringContextUtil.getBean("rainService");
    }

    @Test
    public void testSpringContext() {
        List<RainHour> rainHourList = rainDao.findRainHourList(null);
        System.out.println(rainHourList.size());
    }

    @Test
    public void testSSM() {
        transcoder = new JsonTranscoder(new JsonObjectMapper());
        RainHour r = rainService.findRainHour("003");
        System.out.println(r);
    }
}
