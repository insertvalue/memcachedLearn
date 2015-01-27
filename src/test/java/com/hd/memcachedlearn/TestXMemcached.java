/**
 * @Title: TestXMemcached
 * @Description:
 * @author pyfeng
 * @date 2015-1-26
 * @version V1.0 Copyright（C） 2010~2020 深圳市宏电技术股份有限公司
 */
package com.hd.memcachedlearn;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

/**
 * @ClassName: TestXMemcached
 * @Description:
 * @author pyfeng
 * @date 2015-1-26
 */
public class TestXMemcached {

    public static void main(String[] args) {
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil
                .getAddresses("localhost:11211"));
        MemcachedClient memcachedClient;
        try {
            memcachedClient = builder.build();
            memcachedClient.set("hello", 0, "Hello,xmemcached1");
            String value = memcachedClient.get("hello");
            System.out.println("hello=" + value);
//            memcachedClient.delete("hello");
//            value = memcachedClient.get("hello");
//            System.out.println("hello=" + value);
            // close memcached client
            memcachedClient.shutdown();
        } catch (MemcachedException e) {
            System.err.println("MemcachedClient operation fail");
        } catch (TimeoutException e) {
            System.err.println("MemcachedClient operation timeout");
        } catch (InterruptedException e) {
        } catch (IOException e) {
            System.err.println("Shutdown MemcachedClient fail");
        }
    }
}
