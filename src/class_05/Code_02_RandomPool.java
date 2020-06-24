package class_05;

import java.util.HashMap;
import java.util.Random;

/**
 * @Title : 设置RandomPool结构
 * @Description : 实现三个功能--操作达到常量时间---不允许重复--等概率随机访问
 * 用两个HashMap或动态数组+HashMap (LeetCode 380)
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date : 2020/6/22 16:31
 */
public class Code_02_RandomPool {

    public static class Pool<K> {
        public HashMap<K, Integer> keyIndexMap;
        public HashMap<Integer, K> indexKeyMap;
        public int size;

        public Pool() {
            keyIndexMap = new HashMap<>();
            indexKeyMap = new HashMap<>();
            size = 0;
        }

        public void insert(K key) {
            if (!keyIndexMap.containsKey(key)) {
                keyIndexMap.put(key, size);
                indexKeyMap.put(size++, key);
            }
        }

        public void delete(K key) {
            if (keyIndexMap.containsKey(key)) {
                int deleteIndex = keyIndexMap.get(key);
                int lastIndex = --size;
                K lastKey = indexKeyMap.get(lastIndex);
                keyIndexMap.put(lastKey, deleteIndex);
                indexKeyMap.put(deleteIndex, lastKey);
                keyIndexMap.remove(key);
                indexKeyMap.remove(lastIndex);
            }
        }

        public K getRandom() {
            if (size == 0) {
                return null;
            }
            Random r = new Random();
            int idx = r.nextInt(size);
            return indexKeyMap.get(idx);
        }
    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("1");
        pool.insert("2");
        pool.insert("3");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        pool.delete("1");
        pool.delete("2");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }

}
