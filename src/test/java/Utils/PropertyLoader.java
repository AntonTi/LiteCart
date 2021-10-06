package test.java.Utils;

import java.util.ResourceBundle;

public class PropertyLoader {
    //for private data (credentials, etc) uncomment and create a file 'cred.properties' in folder 'resources'
    //DON'T FORGET to add the file 'cred.properties' to gitignore !!!

    private static ResourceBundle res = ResourceBundle.getBundle("config");
    /*private static ResourceBundle resCred = ResourceBundle.getBundle("cred");*/

    public static String getProperty(String name) {
        return res.getString(name);
    }

    /*public static String getCredProperty(String name) {
        return resCred.getString(name);
    }*/
}
