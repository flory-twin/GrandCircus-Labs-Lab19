package co.grandcircus;

public class Node
{
   public Node next;
   public Object value;
   public Node() {
      super();
      next = null;
      value = null;
   }
   public Node(Node next, Object value) {
      super();
      this.next = next;
      this.value = value;
   }
   public Node getNext() {
      return next;
   }
   public void setNext(Node next) {
      this.next = next;
   }
   public Object getValue() {
      return value;
   }
   public void setValue(Object value) {
      this.value = value;
   }
   
   @Override
   public String toString() {
      if (next != null)
      {
         return value.toString() + " -> ";
      } else {
         return value.toString();
      }
   }
   
}
