package org.rainey;

import org.rainey.ListNode;

public class LinkedList {
    private ListNode head;

    public LinkedList(){}

    public LinkedList(ListNode head){
        this.head=head;
    }
    public LinkedList(int headVal){
        this.head=new ListNode(headVal,null,null);
    }

    public void append(ListNode newNode){
        if(this.head==null){
            this.head = newNode;
            return;
        }
        ListNode currentNode = this.getHead();
        while(currentNode.getAfter()!=null){
            currentNode = currentNode.getAfter();
        }
        newNode.setBefore(currentNode);
        currentNode.setAfter(newNode);
    }

    public ListNode getNode(int value){
        ListNode currentNode = this.getHead();
        boolean more = true;
        while(more){
            if(currentNode.getValue()==value){
                return currentNode;
            } else if(currentNode.getAfter()==null){
                more=false;
            } else {
                currentNode = currentNode.getAfter();
            }
        }
        return null;
    }

    public void delete(ListNode node){
        if(node==this.head){
            this.head = this.head.getAfter();
            this.head.setBefore(null);
        } else if (node.getAfter()==null){
            ListNode first = node.getBefore();
            first.setAfter(null);
        } else {
            ListNode first = node.getBefore();
            ListNode third = node.getAfter();
            first.setAfter(third);
            third.setBefore(first);
        }
    }

    public void insertBefore(ListNode newNode, ListNode beforeNode){
        if(beforeNode==this.head){
            this.head=newNode;
            this.head.setAfter(beforeNode);
            beforeNode.setBefore(newNode);
        } else {
            ListNode first = beforeNode.getBefore();
            first.setAfter(newNode);
            beforeNode.setBefore(newNode);
        }
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }
}

