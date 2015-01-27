/**
 * @Title: IRainService
 * @Description:
 * @author pyfeng
 * @date 2015-1-23
 * @version V1.0 Copyright（C） 2010~2020 深圳市宏电技术股份有限公司
 */
package com.hd.memcachedlearn.service;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.hd.memcachedlearn.entity.RainHour;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: IRainService
 * @Description:
 * @author pyfeng
 * @date 2015-1-23
 */
public interface IRainService {

    public List<RainHour> findRainHourList(Map<String, Object> queryMap);
    
    public RainHour findRainHour(@ParameterValueKeyProvider String termSn);
    
}
