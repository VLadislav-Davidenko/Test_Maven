import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class TestMaven {
    public static void main(String[] args) {
       /* List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi");
        fruits.forEach(System.out::println);

        List<String> reverseFruits = Lists.reverse(fruits);
        reverseFruits.forEach(System.out::println);

        System.out.println("=====================");

        Multimap<String, String> map = ArrayListMultimap.create();
        map.put("key", "firstValue");
        map.put("key", "secondValue");
        System.out.println(map);*/
        Properties prop = new Properties();

        try(InputStream resourceAsStrem = TestMaven.class.getClassLoader()
                .getResourceAsStream("config.properties")){
            prop.load(Objects.requireNonNull(resourceAsStrem));
        } catch (IOException e){
            System.err.println("Unable to load properties file: " + "config.properties");

        }
        prop.get("props.local.hello");
        prop.get("props.mvn.hello");

    }
}
