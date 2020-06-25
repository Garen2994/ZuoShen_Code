package class_05;

import java.util.*;

/**
 * @Title : 设计并查集
 * @Description : 检查两个元素是否属于同一集合
 *                元素A，B所在集合合并为一个集合
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date : 2020/6/24 20:53
 */
public class Code_04_UnionFind {

    public static class Node {
        char value;

        public Node(char value) {
            this.value = value;
        }

        public char getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return value == node.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
    /**
     * @description UnionFind类
     * @param null
     * @return
     */
    public static class UnionFindSet {
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> sizeMap;

        public UnionFindSet() {
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
        }

        /**
         * @description 构建并查集
         * @param nodes
         * @return void
         */
        public void makeSets(List<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }
        /**
         * @description 找到元素所在集合的代表元素
         * @param node
         * @return class_05.Code_04_UnionFind.Node
         */
        private Node findHead(Node node) {//可以改成栈
            Stack<Node> stack = new Stack<>();
            Node cur = node;
            Node parent  = fatherMap.get(node);
            while(cur != parent){
                stack.push(cur);
                cur = parent;
                parent = fatherMap.get(cur);
            }
            while(!stack.isEmpty()){
                fatherMap.put(stack.pop(),parent);
            }
            return parent;
//            Node father = fatherMap.get(node);
//            //recurse until father = node
//            if(father != node){
//                father = findHead(father);
//            }
//            fatherMap.put(node,father);
//            return father;
        }

        /**
         * @description 判断两个元素是否属于同一集合
         * @param a
         * @param b
         * @return boolean
         */
        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        /**
         * @description 合并两个元素所在集合
         * @param a
         * @param b
         * @return void
         */
        public void union(Node a, Node b) {
            if(a == null || b == null){
                throw new RuntimeException("Node is null");
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if(aHead != bHead){
                int aSetSize = sizeMap.get(aHead);//只用到head元素对应的size值
                int bSetSize = sizeMap.get(bHead);
                if(aSetSize <= bSetSize){
                    fatherMap.put(aHead,bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                }else{
                    fatherMap.put(bHead,aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        list.add(new Node('a'));
        list.add(new Node('b'));
        list.add(new Node('c'));
        list.add(new Node('d'));
        list.add(new Node('e'));
        list.add(new Node('f'));
        UnionFindSet set = new UnionFindSet();
        set.makeSets(list);
        set.union(list.get(2),list.get(4)); //Union two set
        System.out.println(set.findHead(list.get(2)).getValue());
        System.out.println(set.findHead(list.get(4)).getValue());
        System.out.println("两个元素是否属于同一集合:" + (set.isSameSet(list.get(2), list.get(4))  ? " 是 " : " 否 "));
        System.out.println(set.sizeMap.get(list.get(4)));
//        System.out.println(set.sizeMap.get(list.get(2)));
    }

}
