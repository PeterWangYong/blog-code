package com.peter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
  private static Properties env = new Properties();
  static {
    try {
      InputStream config = BeanFactory.class.getResourceAsStream("/applicationContext.properties");
      env.load(config);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static UserService getUserService() {
    UserService userService = null;
    try {
      Class clazz = Class.forName(env.getProperty("userService"));
      userService = (UserService)clazz.newInstance();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    }
    return userService;

  }

  public static Object getBean(String key) {
    Object ret = null;
    try {
      Class clazz = Class.forName(env.getProperty(key));
      ret = clazz.newInstance();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return ret;
  }
}
