package cn.com.leave.util;

import java.util.UUID;

/**
 * UUID生成器
 * 
 * @author wxp
 * 
 * @date 2014年7月8日下午1:24:10
 */
public class UUIDGenerator
{
    public static String uuid()
    {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }
    
    public static void main(String[]args)
    {
        System.out.println(UUIDGenerator.uuid());
        System.out.println(System.currentTimeMillis());
        System.out.println( 30 * 24 * 3600 * 1000L );
    }
}
