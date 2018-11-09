
import java.util.*;

@SuppressWarnings("unchecked")
public class BinaryHeap
{
   private static final int CAPACITY = 10 ;

   private int size;            // Number of elements in heap
   private int[] heap;     // The heap array

   public BinaryHeap()
   {
      size = 0;
      heap =  new int[CAPACITY];
   }

   
   private void percolatingDown(int k)
   {
     int tmp = heap[k];
      int child;

      for(; 2*k <= size; k = child)
      {
         child = 2*k;

         if(child != size &&
            heap[child] > (heap[child + 1])  )
             child++;

         if(tmp  >  heap[child]  )
             heap[k] = heap[child]  ;
         else
                break;
      }
      
      heap[k] = tmp;
   }


   public int remove() throws RuntimeException
   {
      if (size == 0) throw new RuntimeException();
      
      int min = heap[1];
      heap[1] = heap[size--];
      percolatingDown(1);
      return min;
    }
  

  // adds a new item

   public void add(int  x)
   {
      if(size == heap.length - 1)
         doubleSize();

      //add a new item to the end of the array
      int pos = ++size;

      //Percolate up
      for(; pos > 1 && x  < heap[pos/2] ; pos = pos/2 )
         heap[pos] = heap[pos/2];

      heap[pos] = x;
   }

   private void doubleSize()
   {
      int[] old = heap;
      heap =  new int[heap.length * 2];
      System.arraycopy(old, 1, heap, 1, size)   ;
   }

  

   
}
