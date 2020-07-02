package class_07;

/**
 * @Title : Trie Tree-前缀树的应用实现
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date : 2020/6/25 21:50
 */
public class Code_01_TrieTree {

	public static class TrieNode {
		public int path;
		public int end;
		public TrieNode[] nexts;

		public TrieNode() {
			path = 0;
			end = 0;
			nexts = new TrieNode[26];
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		/**
		 * @description 插入新的word
		 * @param word
		 * @return void
		 */
		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				//用相对于a的ASCII差值作为下标索引，隐式地记录了该字母 也可以用map
				index = chs[i] - 'a';
				if (node.nexts[index] == null) { //没有到当前结点的路径 则新建
					node.nexts[index] = new TrieNode();
				}
				node = node.nexts[index];   //跳到下一结点
				node.path++;
			}
			node.end++; //以这个点为终点的word+1
		}
		/**
		 * @description 删除某个字符串
		 * @param word
		 * @return void
		 */
		public void delete(String word) {
			if (search(word) != 0) {
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					if (--node.nexts[index].path == 0) {
						node.nexts[index] = null;
						return;
					}
					node = node.nexts[index];
				}
				node.end--;
			}
		}
		/**
		 * @description 某词的词频统计
		 * @param word
		 * @return int
		 */
		public int search(String word) {
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}
		/**
		 * @description 统计以某字符串为前缀的字符串有多少个
		 * @param pre
		 * @return int
		 */
		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a'; //ASCII 97-122 'a'-'z'
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.path;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("garen"));
		trie.insert("garen");
		trie.insert("garen");
		trie.insert("garen");
		System.out.println(trie.search("garen"));
		trie.delete("garen");
		System.out.println(trie.search("garen"));
		trie.insert("garen");
		trie.insert("garen");
		trie.delete("garen");
		System.out.println(trie.search("garen"));
		trie.delete("garen");
		System.out.println(trie.search("garen"));
		trie.insert("garena");
		trie.insert("garenac");
		trie.insert("garenab");
		trie.insert("garenad");
		trie.delete("garena");
		System.out.println(trie.search("garena"));
		System.out.println(trie.prefixNumber("garen"));

	}
}
