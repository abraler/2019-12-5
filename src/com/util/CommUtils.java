package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommUtils {
    public static Properties loadProperties(String fileName){
        Properties properties=new Properties();
        //将配置文件转为输入
        InputStream in =CommUtils.class.getClassLoader()
                .getResourceAsStream(fileName);
        //加载配置文件
        try{
            properties.load(in);
        }catch (IOException e){
            e.printStackTrace();

        }
        return properties;
    }
}
