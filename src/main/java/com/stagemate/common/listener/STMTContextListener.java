package com.stagemate.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.stagemate.common.AESEncryptor;

@WebListener
public class STMTContextListener implements ServletContextListener {

    public STMTContextListener() {}

    public void contextDestroyed(ServletContextEvent sce)  {}

    public void contextInitialized(ServletContextEvent sce)  {
    	new AESEncryptor();
    }
	
}
