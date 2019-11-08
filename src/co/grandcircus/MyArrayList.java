package co.grandcircus;

import java.util.Arrays;

public class MyArrayList implements MyList
{
   private String[] arr = new String[4]; // when declaring a new String array we MUST assign a size (in this case, 4)
   private int myLength = 0; // we will use this method as a helper method inside this class (so we'll use
   // the 'private' access modifier)
   
   private boolean isFull() {
      return arr.length == myLength;
   } // we will use this as a helper method as well to dynamically increase
   // the size of the array
   
   private boolean isEmpty() {
      return (arr.length == 0);
   }
   
   private void doubleLength() { // why is the type void? find out
      // make a copy of the array that is twice as long
      arr = Arrays.copyOf(arr, arr.length * 2);
   }
   
   @Override
    public void addAtBeginning(String data) {
        if (isFull()) { 
            doubleLength();
        } else if (isEmpty()) {
           arr[0] = data;
        } else {
        // loop backwards and shift all the items over to make room for the new data
           for (int i = myLength; i > 0; i--) {
               arr[i] = arr[i - 1]; // this is assigning the previous element to the new index
           }        arr[0] = data;
        }
        myLength++;
    }
   
   @Override
   public void removeFromBeginning() {
      if (myLength != 0) {
         if (myLength == 1) {
            arr[0] = null;
         } else {
            for (int i = 0; i < arr.length - 1; i++) {
               arr[i] = arr[i + 1];
            }
         }
         myLength--;
      }
   }
   
   @Override
   public void addAtEnd(String data) {
      if (isFull()) {
         doubleLength();
      } 
      arr[myLength] = data;
      myLength++;
   }
   
   @Override
   public void removeFromEnd() {
      if (myLength != 0) {
         // clear the slot and decrement the length
         arr[myLength - 1] = null;
         myLength--;
      }
   }
   
   @Override
   public String get(int index) {
      if (index > myLength) {
         throw new ArrayIndexOutOfBoundsException("index out of bounds");
      }
      return arr[index];
   }
   
   @Override
   public int size() {
      return myLength;
   }
   
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder("[ ");
      for (int i = 0; i < myLength; i++) {
         sb.append(arr[i]);
         if (i != myLength - 1) {
            sb.append(", ");
         }
      }
      sb.append(" ]");
      return sb.toString();
   }

   @Override
   public boolean removeAt(int index) {
      // To remove a member in the middle of the array, we'll need to move the (i+1)st
      //  element into the 'removed' array, then repeat until the nth item in the array
      //  has been processed.
      boolean removed = false;
      
      // Validation: Check for negative indices and out-of-bounds
      if (index >= 0 && index < myLength) {
         // Check for special case where index is at end of array.
         if (index == myLength - 1) {
            removeFromEnd();
            removed = true;
         } else {
            for (int i = index; i < myLength - 1; i++) {
               arr[i] = arr[i + 1];
            }
         removeFromEnd();
         removed = true;
         }
      }
      
   return removed;
   }

   @Override
   public boolean insertAt(int index, String s) {
      boolean inserted = false;
      
      // Validation: Check for negative indices and out-of-bounds.
      if (index >= 0 && index < myLength) {
         //Check for special case where index is at end of array.
         if (index == myLength - 1) {
            addAtEnd(s);
            inserted = true;
         } else {
            for (int i = myLength - 1; i >= index; i--)
            {
               //Move ith element outward.
               if (isFull()) {
                  doubleLength();
               } 
               arr[i + 1] = arr[i];
               if (i == index) {
                  arr[i] = s;
               }
            }
            inserted = true;
         }
      }
      
      return inserted;
   }
}