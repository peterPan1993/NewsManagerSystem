package com.bdqn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取properties文件配置的属性值
 */
public class ConfigManager {

	private static ConfigManager configManager;
	private static Properties properties;
	
	//单例模式
	private ConfigManager(){
		try {
			properties=new Properties();
			//类加载器
			InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream("database.properties");
			properties.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//获得实例的静态方法
	public static ConfigManager getInstance(){
		if(configManager==null){
			configManager=new ConfigManager();
		}
		return configManager;
	}
	//读取properties文件数据
	public String getString(String key){
		return properties.getProperty(key);
	}
}
