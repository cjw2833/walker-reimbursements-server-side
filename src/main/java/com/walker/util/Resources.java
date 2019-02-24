package com.walker.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import com.walker.controllers.Controller;
import com.walker.controllers.CreateReimbsController;
import com.walker.controllers.LoginController;
import com.walker.controllers.UpdateReimbsController;
import com.walker.controllers.EmpReimbsController;
import com.walker.controllers.FmReimbsController;

public class Resources {
	public static HashMap<String, Controller> map = new HashMap<String, Controller>();
	private static Properties prop = getWRResources();
	
	static {
		map.put(prop.getProperty("LOGIN"), new LoginController());
		map.put(prop.getProperty("EMP-REIMBS"), new EmpReimbsController());
		map.put(prop.getProperty("FM-REIMBS"), new FmReimbsController());
		map.put(prop.getProperty("CREATE-REIMBS"), new CreateReimbsController());
		map.put(prop.getProperty("UPDATE-REIMBS"), new UpdateReimbsController());
	}
	
	private static Properties getWRResources() {
		try {
			Properties p = new Properties();
			p.loadFromXML(Resources.class.getResourceAsStream("/wr-resources.xml"));
			return p;
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
