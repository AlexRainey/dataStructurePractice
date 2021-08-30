package org.rainey;

public class ListNode {
    private int value;
    private ListNode before;
    private ListNode after;

    public ListNode(int value, ListNode before, ListNode after){
        this.value=value;
        this.before=before;
        this.after=after;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getBefore() {
        return before;
    }

    public void setBefore(ListNode before) {
        this.before = before;
    }

    public ListNode getAfter() {
        return after;
    }

    public void setAfter(ListNode after) {
        this.after = after;
    }
}
