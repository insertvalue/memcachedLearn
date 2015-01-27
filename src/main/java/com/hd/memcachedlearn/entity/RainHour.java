/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hd.memcachedlearn.entity;

import com.google.code.ssm.api.CacheKeyMethod;
import java.io.Serializable;

/**
 *
 * @author xuweilin
 */
@SuppressWarnings("serial")
public class RainHour implements Serializable {

    //终端sn
    private String termSn;
    //统计日期
    private String dataTime;
    //雨量值
    private float rainValue;

    @CacheKeyMethod
    public String getTermSn() {
        return termSn;
    }

    public void setTermSn(String termSn) {
        this.termSn = termSn;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public float getRainValue() {
        return rainValue;
    }

    public void setRainValue(float rainValue) {
        this.rainValue = rainValue;
    }

    @Override
    public String toString() {
        return "RainHour{" + "termSn=" + termSn + ", dataTime=" + dataTime + ", rainValue=" + rainValue + '}';
    }

}
