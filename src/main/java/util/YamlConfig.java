package util;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.HashMap;


public class YamlConfig {

    /**
     * 从yaml 文件获取对应跳转的游戏页面
     */
    public static Object getGameMapClass(String name){
        InputStream in = null;
        Object result = null;
        try{
            Yaml yaml = new Yaml();
            in = YamlConfig.class.getClassLoader().getResourceAsStream("game.yaml");
            HashMap hashMap = yaml.loadAs(in,HashMap.class);
            result =  hashMap.get(name);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                in.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return result;
    }
}

