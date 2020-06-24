package class_05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Title : 设计并查集
 * @Description : 检查两个元素是否属于同一集合
 * 元素A，B所在集合合并为一个集合
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date : 2020/6/24 20:53
 */
public class Code_04_UnionFind {

    public class Node {
        char value;

	    public Node(char value) {
		    this.value = value;
	    }
    }

    public class UnionFindSet {
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
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findHead(Node node) {
            Node father = fatherMap.get(node);
            //recurse until father = node
            if (father != node) {
                father = findHead(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (bHead != aHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }
    }

}
