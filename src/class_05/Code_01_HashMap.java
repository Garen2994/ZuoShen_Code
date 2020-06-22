package class_05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * @Title :  哈希表与哈希函数的认识
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date : 2020/6/22 11:26
 */
public class Code_01_HashMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("garen", "24");

        System.out.println(map.containsKey("garen"));
        System.out.println(map.containsKey("hou"));
        System.out.println("=========================");

        System.out.println(map.get("garen"));
        System.out.println(map.get("hou"));
        System.out.println("=========================");

        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println("=========================");

        System.out.println(map.remove("garen"));
        System.out.println(map.containsKey("garen"));
        System.out.println(map.get("garen"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println("=========================");

        map.put("garen", "24");
        System.out.println(map.get("garen"));
        map.put("garen", "18");
        System.out.println(map.get("garen"));
        System.out.println("=========================");

        map.put("garen", "24");
        map.put("hou", "18");
        map.put("tong", "22");

        for (String key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println("=========================");

        for (String values : map.values()) {
            System.out.println(values);
        }
        System.out.println("=========================");

        map.clear();
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        map.put("D", "1");
        map.put("E", "2");
        map.put("F", "3");
        map.put("G", "1");
        map.put("H", "2");
        map.put("I", "3");
        for (Entry<String, String> entry : map.entrySet()) {  //entrySet+foreach遍历HashMap (JDK1.8特性)
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "," + value);
        }
        System.out.println("=========================");

//		 you can not remove item in map when you use the iterator of map
//	    try {
//		    for (Entry<String, String> entry : map.entrySet()) {
//		        if (!entry.getValue().equals("1")) {
//		            map.remove(entry.getKey());
//		        }
//		    }
//	    } catch (Exception e) {
//	        throw new RuntimeException("Wrong Operation");
//	    }


        // if you want to remove items, collect them first, then remove them by this way.
        List<String> removeKeys = new ArrayList<>();
        for (Entry<String, String> entry : map.entrySet()) {
            if (!entry.getValue().equals("1")) {
                removeKeys.add(entry.getKey());
            }
        }
        for (String key : removeKeys) {
            map.remove(key);
        }
	    for (Entry<String, String> entry : map.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    System.out.println(key + "," + value);
	    }
    }
}
