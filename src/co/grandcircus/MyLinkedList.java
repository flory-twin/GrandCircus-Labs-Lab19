package co.grandcircus;

public class MyLinkedList implements MyList
{
   private Node head;
   private int myLength = 0; // created a helper method to get the node at a certain location
   // to help us prevent some code duplication
   
   private Node getNodeAt(int index) {
      Node node = null;
      if (myLength > 0) {
         node = head;
         for (int i = 0; i < index; i++) {
            if (node == null) {
               return null;
            }
            node = node.getNext();
         }
      }
      return node;
   }
   
   @Override
   public void addAtBeginning(String data) {
      if (head == null) {
         head = new Node(head, data);
      } else {
         Node oldHead = head;
         head = new Node(null, data);
         head.setNext(oldHead);
      }
      
      myLength++;
   }
   
   @Override
   public void removeFromBeginning() {
      if (myLength > 0) {
         if (myLength == 1) {
            head = null;
         } else if (myLength > 1) {
            head = head.getNext();
         }
         
         myLength--;
      }
   } // code challenge
   
   @Override
   public void addAtEnd(String data) {
      // check to make sure the list is not empty!
      if (myLength == 0) {
         // if empty add to the beginning (hint: we have some code for that!) //
         addAtBeginning(data);
      }
      
      // otherwise - create logic to add to the end (tail)
      Node newTail = new Node();
      newTail.next = null;
      newTail.value = data;
      
      Node oldTail = getNodeAt(myLength - 1);
      oldTail.next = newTail;
      // increase the length
      myLength++;
   } // code challenge
   
   @Override
    public void removeFromEnd() {
      if (myLength > 0) {
         if (myLength == 1) {
            head = null;
         } else {
            getNodeAt(myLength - 1).next = null;
         }
         
         myLength--;
      }
   }
   
   // think again about methods that you can reuse! } // code challenge
   @Override
   public String get(int index) {
      return getNodeAt(index).value;
   }
   
   @Override
   public int size() {
      return myLength;
   }
   
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder("[ ");
      Node node = head;
      // follow the links between the nodes until it reaches the end
      while (node != null) {
         sb.append(node);
         node = node.getNext();
      }
      sb.append(" ]");
      return sb.toString();
   }

   @Override
   public boolean removeAt(int index) {
      boolean removeSucceeded = false;
      
      if (myLength > 0) {
         if (index == 0) {
            removeFromBeginning();
            removeSucceeded = true;
         } else if (index > 0) {
            
            // The real logic for removeAt lies within this branch; all other cases are handled by existing methods.
            if (index < myLength - 1) {
               // We already know that index >= 1, and index < myLength. As a result,
               // we know the list has at least two members.
               Node last = head;
               Node current = head.next;
               
               // Iterate up to i.
               for (int i = 2; i < index + 1; i++) {
                  // This, of course, only activates for index > 2.
                  last = current;
                  current = current.next;
               }
               
               // We're at i. 
               Node next = current.next;
               last.next = next;
               removeSucceeded = true;
               
            } else if (index == myLength - 1) {
               removeFromEnd();
               removeSucceeded = true;
            }
         }
      }
      return removeSucceeded;
   }

   @Override
   public boolean insertAt(int index, String s) {
      boolean insertSucceeded = false;
      
      if (myLength > 0) {
         if (index == 0) {
            addAtBeginning(s);
            insertSucceeded = true;
         } else if (index > 0) {
            
            // The real logic lies here.
            if (index < myLength - 1) {
               // We already know that index >= 1, and index < myLength. As a result,
               // we know the list has at least two members.
               Node last = head;
               Node current = head.next;
               
               // Iterate up to i.
               for (int i = 2; i < index + 1; i++) {
                  // This, of course, only activates for index > 2.
                  last = current;
                  current = current.next;
               }
               
               // We're at i. 
               last.next = new Node(current, s);
               insertSucceeded = true;
               
            } else if (index == myLength - 1) {
               addAtEnd(s);
               insertSucceeded = true;
            }
         }
      }
      
      return insertSucceeded;
   }
}