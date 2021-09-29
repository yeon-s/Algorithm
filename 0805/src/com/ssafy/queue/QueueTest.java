package com.ssafy.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		System.out.println(queue.isEmpty()+"/"+queue.size());
		
		queue.offer("오서연");
		queue.offer("김수빈");
		queue.offer("심으뜸");
		
		System.out.println(queue.isEmpty()+"/"+queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty()+"/"+queue.size());
		
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.isEmpty()+"/"+queue.size());
		System.out.println(queue.poll());
	}

}
