package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    // ConfigurationReader class'ini projemizi heryerinden
    // nesne uretmeden, miras almadan kullanabilecek sekilde tasarlayalim.

    // static : program calisir calismaz, bellekte yer tutmaya yarayan keyword.
    static Properties properties;

    static {
        // okumak istedigimiz configuration.properties file'in dosya yolu
        // C:\Users\fidan\IdeaProjects\TestNGProje\configuration.properties
        String path = "configuration.properties";

        // dene - hata varsa yakala.
        // bu islemi DENE eger hata alirsan, PROGRAMI DURDURMA
        try {
            // okumak istediginiz dosyanin path(adres)'ini yaziyorsun
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            // fileInputStream'dan urettigim file dosyasi burada, bunu kullanabilirsin
            properties.load(file);
        } catch (Exception e) {

        }

    }
    // properties.getProperty("username") --> manager2
    public static String getProperty(String key) {
        return properties.getProperty(key);

    }

}