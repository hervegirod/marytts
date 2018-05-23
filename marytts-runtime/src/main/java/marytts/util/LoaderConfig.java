/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marytts.util;

/**
 *
 * @author Herve
 */
public class LoaderConfig {
   private static LoaderConfig config = null;
   private ClassLoader loader = null;

   private LoaderConfig() {
   }

   public static LoaderConfig getInstance() {
      if (config == null) {
         config = new LoaderConfig();
      }
      return config;
   }

   public ClassLoader getClassLoader() {
      return loader;
   }

   void setClassLoader(ClassLoader loader) {
      this.loader = loader;
   }

   public static Class<?> getClass(String name) throws ClassNotFoundException {
      ClassLoader loader = LoaderConfig.getInstance().loader;
      if (loader == null) {
         return Class.forName(name);
      } else {
         return Class.forName(name, true, loader);
      }

   }

   public static Object newInstance(String name)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
      ClassLoader loader = LoaderConfig.getInstance().loader;
      Class<?> clazz;
      if (loader == null) {
         clazz = Class.forName(name);
      } else {
         clazz = Class.forName(name, true, loader);
      }
      return clazz.newInstance();
   }
}
