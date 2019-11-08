package co.grandcircus;

public interface MyList
{
   void addAtBeginning(String s);
   void removeFromBeginning();
   void addAtEnd(String s);
   void removeFromEnd();
   boolean removeAt(int index);
   boolean insertAt(int index, String s);
   String get(int index);
   int size();
}
