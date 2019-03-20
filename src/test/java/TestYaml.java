import org.junit.jupiter.api.Test;
import util.YamlConfig;

import java.io.File;
import java.io.InputStream;

public class TestYaml {

    @Test
    public void testYaml() throws Exception{
        Object a = YamlConfig.getGameMapClass("欢乐卡当");
        System.out.print(a.toString());

//        String a  = YamlConfig.class.getClassLoader().getResource("game.yaml").getPath();
//        System.out.print(a);

    }
}
