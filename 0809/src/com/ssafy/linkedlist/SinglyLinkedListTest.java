package com.ssafy.linkedlist;

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addLastNode("정산하");
		System.out.println(list.getLastNode());
		list.printList();
		
		
	}

}
