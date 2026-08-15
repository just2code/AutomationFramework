package com.automation.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	private Properties properties;
	
	private static volatile ConfigReader configReader;	
	
	private ConfigReader() {
		
		try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties"))
		{
			properties = new Properties();
			if(inputStream==null)
			{
				throw new RuntimeException("Config properties not found");
			}
			properties.load(inputStream);			
		}catch(IOException e)
		{
			throw new RuntimeException("Config properties not working",e);
		}
	}

	public static ConfigReader getInstance()
	{
		if(configReader==null)
		{
			synchronized(ConfigReader.class) {
				if(configReader==null)
				{
					configReader=new ConfigReader();
				}
			}
		}
		
		return configReader;
	}	
	
	public String get(String key)
	{		
		
		if(key==null||key.isEmpty())
		{
			throw new RuntimeException("Key is empty");
		}
		String value = properties.getProperty(key);
		if(value==null||value.isEmpty())
		{
			throw new RuntimeException("No value for the key "+key);
		}
		return value;
	}
	

}
