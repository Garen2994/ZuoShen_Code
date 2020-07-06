package class_07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * @Title : 做项目获利的最大钱数
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date : 2020/7/3 21:17
 */
public class Code_03_IPO {
	public static class Node {
		public int p;
		public int c;

		public Node(int p, int c) {
			this.p = p;    //profit
			this.c = c;    //cost
		}
	}


	/**
	 * @description IPO收益最大的项目做法(不能并行)
	 * @param k 最多能做的项目数
	 * @param W 当前的钱数
	 * @param Profits 项目利润
	 * @param Cost 项目花费
	 * @return int
	 */
	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Cost) {
		Node[] nodes = new Node[Profits.length];
		for (int i = 0; i < Profits.length; i++) {
			nodes[i] = new Node(Profits[i],Cost[i]);
		}
		//维护一个小根堆-花费最少
		PriorityQueue<Node> minCostPri = new PriorityQueue(new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2){
				return o1.c - o2.c;
			}
		});
		//维护一个大根堆-利润最高
		PriorityQueue<Node> maxProfitPri = new PriorityQueue(new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2){
				return o2.p - o1.p;
			}
		});
		for (int i = 0; i < nodes.length; i++) {
			minCostPri.add(nodes[i]);
		}
//		minCostPri.addAll(Arrays.asList(nodes));
		for (int i = 0; i < k; i++) {
			while(!minCostPri.isEmpty()&& minCostPri.peek().c <= W){
				maxProfitPri.add(minCostPri.poll());
			}
			if(maxProfitPri.isEmpty()){
				return W;
			}
			W+= maxProfitPri.poll().p;
		}
		return W;
	}

	public static void main(String[] args) {
		int k = 2;
		int W = 0;
		int[] Cost = {0,1,1};
		int[] Profits = {1,2,3};
		System.out.println("当前的钱数：" + findMaximizedCapital(k, W, Profits, Cost));
	}
}
