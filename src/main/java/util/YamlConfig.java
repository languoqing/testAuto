package util;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.HashMap;


public class YamlConfig {

    public Object getGameMapClass(String name){
        InputStream in = null;
        Object result = null;
        try{
            Yaml yaml = new Yaml();
            in = YamlConfig.class.getClassLoader().getResourceAsStream("src/java/config/game.yaml");
            HashMap hashMap = yaml.loadAs(in,HashMap.class);
            result =  hashMap.get(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                in.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return result;
    }
}
