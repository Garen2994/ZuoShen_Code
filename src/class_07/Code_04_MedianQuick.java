package class_07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * @Title : 实现一个数据流，随时取得中位数：
 *          加入数时间复杂度：O(logN);取中位数：O(1)
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date : 2020/7/6 15:07
 */
public class Code_04_MedianQuick {

	public static class MedianHolder {
		public PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
		public PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

		/**
		 * @description 调整堆结构
		 * @param
		 * @return void
		 */
		public void ModifyHeapSize(){
			if(minHeap.size() == maxHeap.size() + 2){
				maxHeap.add(minHeap.poll());
			}
			if(maxHeap.size() == minHeap.size() + 2){
				minHeap.add(maxHeap.poll());
			}
		}

		public void addNumber(int num) {
			if(maxHeap.isEmpty()){
				maxHeap.add(num);
				return;
			}
			if(maxHeap.peek() >= num){
				maxHeap.add(num);
			}else{
				if(minHeap.isEmpty()){
					minHeap.add(num);
					return;
				}
				if(minHeap.peek() > num){
					maxHeap.add(num);
				}else{
					minHeap.add(num);
				}
			}
			ModifyHeapSize();
		}

		public Integer getMedian() {
			int minHeapSize = minHeap.size();
			int maxHeapSize = maxHeap.size();
			if((minHeapSize + maxHeapSize) == 0){
				return null;
			}
			Integer minHeapHead = minHeap.peek();
			Integer maxHeapHead = maxHeap.peek();

			//偶数个栈顶元素 取堆顶均值
			if(((minHeapSize + maxHeapSize) & 1) == 0){
				return (minHeapHead + maxHeapHead) >> 1;
			}
			//奇数个 取元素个数多的那个堆的堆顶
			return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;
		}

	}

	// for test
	public static int[] getRandomArray(int maxLen, int maxValue) {
		int[] res = new int[(int) (Math.random() * maxLen) + 1];
		for (int i = 0; i != res.length; i++) {
			res[i] = (int) (Math.random() * maxValue);
		}
		return res;
	}

	// for test, this method is ineffective but absolutely right
	public static int getMedianOfArray(int[] arr) {
		int[] newArr = Arrays.copyOf(arr, arr.length);
		Arrays.sort(newArr);
		int mid = (newArr.length - 1) / 2;
		if ((newArr.length & 1) == 0) {
			return (newArr[mid] + newArr[mid + 1]) / 2;
		} else {
			return newArr[mid];
		}
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		boolean err = false;
		int testTimes = 200000;
		for (int i = 0; i != testTimes; i++) {
			int len = 7;
			int maxValue = 10;
			int[] arr = getRandomArray(len, maxValue);
			MedianHolder medianHold = new MedianHolder();
			for (int j = 0; j != arr.length; j++) {
				medianHold.addNumber(arr[j]);
			}
			if (medianHold.getMedian() != getMedianOfArray(arr)) {
				err = true;
				printArray(arr);
				System.out.println(medianHold.getMedian());
				System.out.println(getMedianOfArray(arr));
				break;
			}
//			printArray(arr);
//			System.out.println(medianHold.getMedian());
//			System.out.println(getMedianOfArray(arr));
		}
		System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");
	}
}
