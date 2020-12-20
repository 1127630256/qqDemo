package com.qq.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
    private static Properties[] properties = null;

    static {
        String [] propertieyFiles = {
                "WEB-INF/config/DataSourceConfig.properties"
        };
        properties = new Properties[propertieyFiles.length];
        try {
            for (int i=0;i < propertieyFiles.length;i++){
                properties[i].load(ConfigUtil.class.getClassLoader().getResourceAsStream(propertieyFiles[i]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        for (int i=0;i < properties.length;i++){
            if (properties[i].containsKey(key)){
                return properties[i].getProperty(key);
            }
        }
        return null;
    }
}
