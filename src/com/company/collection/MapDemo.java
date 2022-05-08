package collection;

import java.util.HashMap;
import java.util.Iterator;

public class MapDemo {
    public void test(){
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one",1);
        hashMap.put("two",2);
        hashMap.put("three",3);

        useForeach(hashMap);
        useIterator(hashMap);
    }

    public void useForeach(HashMap map){
         map.forEach((key,value) -> System.out.println("key = " + key + ", value = " + value));
    }

    public void useIterator(HashMap map){
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()){
            String key = iter.next();
            System.out.println("key = " + key + ", value = " + map.get(key));
        }
    }
}
