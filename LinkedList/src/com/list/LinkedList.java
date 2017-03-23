package com.list;

class ListNode{
	
	int data;  //data of the node
	ListNode next; //pointer to the next node
	
	public ListNode(){	
	}
	
public ListNode(int data){
	this.data =data;	
}

//methods
public void setData(int data){
	this.data =data;
}
public int getData(){
	return data;
}
public void setNext(ListNode next){
	this.next = next;
}
public ListNode getNext(){
	return next;
}
}

public class LinkedList {
	
	int length = 0;ListNode head;
	
	public int ListLength() { 
		ListNode currentNode = head;
		while(currentNode != null){ 
			currentNode = currentNode.getNext();
			//length++;
			} 
		return length;
		}
	
	
	public void insertAtBegining(ListNode node) {
		node.setNext(head);
		head = node;
	    length++;
	}
	public void insertAtEnd(ListNode node){
		if(head==null){
			head = node;
		}
		else{
			ListNode p,q;
			for(p=head;(q=p.getNext())!=null;p=q);
				p.setNext(node);
			length++;
		}
	}
	public void insertAtPosition(int data,int position){
		
		System.out.println("the length of the list is "+ length);
		
		if(position < 0 ){
			System.out.println("when position less than 0");
			position =0;
		}
		if(position > length){
			System.out.println("when positon greater than length");
			System.out.println("the length of the list is "+ length);
			position = length;
		}
		if(head == null){
			System.out.println("when head node is null");
			head = new ListNode(data);
			System.out.println("after head node assignment");
		}
		else if(position == 0){
			ListNode temp = new ListNode(data);
			temp.next = head;
			head = temp;
		}
		else{
			ListNode temp = head;
			for(int i=1;i<position;i++){
				temp = temp.getNext();
			}
			ListNode newNode = new ListNode(data);
			newNode.next = temp.next;
			temp.setNext(newNode);
		}
		length++;
	}
	
	public ListNode reverseList(ListNode currentnode){
		ListNode prev = null;
		ListNode nextNode;
		while(currentnode!=null){
			nextNode = currentnode.next;
			currentnode.next = prev;
			prev = currentnode;
			currentnode =nextNode;
		}
		return prev;
	}
	
	public void print(ListNode head){
		ListNode current = head;
		while(current!=null){
			System.out.print("    "+current.data);
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList ll = new LinkedList();
		
		ListNode node1= new ListNode();
		ListNode node2= new ListNode();
		//ListNode node3= new ListNode();
		ListNode node4= new ListNode();
		node1.setData(57);
		node2.setData(100);
		//node3.setData(3);
		node4.setData(4);
		
		//ll.insertAtPosition(99,2);
		ll.insertAtBegining(node1);
		//ll.insertAtBegining(node3);
		ll.insertAtEnd(node2);
		ll.insertAtEnd(node4);
		//ll.insertAtPosition(4,1);
		ll.print(node1);
		ListNode reverseList = ll.reverseList(node1);
		System.out.println("End value length of the list is "+ll.ListLength());
		System.out.println("after reversing the list");
	    ll.print(reverseList);
		//ll.print();
	}

}
