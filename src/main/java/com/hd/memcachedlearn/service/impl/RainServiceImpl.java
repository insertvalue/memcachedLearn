/**
 * @Title: RainServiceImpl
 * @Description:
 * @author pyfeng
 * @date 2015-1-23
 * @version V1.0 Copyright（C） 2010~2020 深圳市宏电技术股份有限公司
 */
package com.hd.memcachedlearn.service.impl;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.google.code.ssm.json.Holder;
import com.hd.memcachedlearn.dao.RainDao;
import com.hd.memcachedlearn.entity.RainHour;
import com.hd.memcachedlearn.service.IRainService;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @ClassName: RainServiceImpl
 * @Description:
 * @author pyfeng
 * @date 2015-1-23
 */
@Service("rainService")
public class RainServiceImpl implements IRainService {

    private static final String NAMESPACE = "test";

    @Resource
    private RainDao rainDao;

    public List<RainHour> findRainHourList(Map<String, Object> queryMap) {
        return rainDao.findRainHourList(queryMap);
    }

    @ReadThroughSingleCache(namespace = NAMESPACE, expiration = 600)
    public RainHour findRainHour(@ParameterValueKeyProvider String termSn) {
        RainHour r = new RainHour();
        r.setTermSn(termSn);
        r.setDataTime(Long.toString(System.currentTimeMillis()));
        r.setRainValue((int) (Math.random() * 100));
        try {
            Thread.sleep(1000 * 5);
            System.out.println("set termSn:" + termSn);
        } catch (InterruptedException ex) {
            Logger.getLogger(RainServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

}
