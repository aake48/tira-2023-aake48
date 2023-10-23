package oy.interact.tira.student;

import java.util.Comparator;

public class Algorithms {

   private Algorithms() {
      // nada
   }

   public static <T> void swap(T[] array, int first, int second) {

      if (array != null && first >= 0 && first < array.length && second >= 0 && second < array.length) {
         T temp = array[first];
         array[first] = array[second];
         array[second] = temp;
      }

   }

   ///////////////////////////////////////////
   // Insertion Sort for the whole array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array) {
      insertionSort(array, 0, array.length);
   }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {

      if (array != null && fromIndex >= 0 && toIndex <= array.length) {
         for (int currentIndex = fromIndex; currentIndex < toIndex; currentIndex++) {
            // Storing the element in currentIndex for comparing
            T currentElement = array[currentIndex];
            /*
             * Index that is used in the innder loop to compare the currentElement and the
             * element in currentIndex - 1
             */

            int previousIndex = currentIndex - 1;

            while (previousIndex >= fromIndex && array[previousIndex].compareTo(currentElement) > 0) {
               swap(array, previousIndex, previousIndex + 1);
               previousIndex--;
            }
         }
      }
   }

   //////////////////////////////////////////////////////////
   // Insertion Sort for the whole array using a Comparator
   //////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
      insertionSort(array, 0, array.length, comparator);

   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {

      if (array != null && fromIndex >= 0 && toIndex < array.length && comparator != null) {
         for (int currentIndex = fromIndex; currentIndex < toIndex; currentIndex++) {
            // Storing the element in currentIndex for comparing
            T currentElement = array[currentIndex];

            /*
             * Index that is used in the innder loop to compare the currentElement and the
             * element in currentIndex - 1
             */
            int previousIndex = currentIndex - 1;

            while (previousIndex >= fromIndex && currentElement != null
                  && comparator.compare(array[previousIndex], currentElement) > 0) {
               swap(array, previousIndex, previousIndex + 1);
               previousIndex--;
            }
         }
      }
   }

   ///////////////////////////////////////////
   // Reversing an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array) {
      reverse(array, 0, array.length);
   }

   ///////////////////////////////////////////
   // Reversing a slice of an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {

      // Don Hämäläinen auttanut algoritmin "siistimisessä",
      // aikasempi toteutus ollut monimutkaisempi ja aikatehokkuudeltaan huono
      for (int currentIndex = fromIndex; currentIndex < toIndex / 2; currentIndex++) {
         swap(array, currentIndex, toIndex - 1 - currentIndex);
      }

   }

   ///////////////////////////////////////////
   // Binary search bw indices
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      int low = fromIndex;
      int high = toIndex - 1;

      while (low <= high) {
         int middle = low + (high - low) / 2;
         if (fromArray[middle].compareTo(aValue) == 0) {
            return middle;
         } else if (fromArray[middle].compareTo(aValue) < 0) {
            low = middle + 1;
         } else {
            high = middle - 1;
         }
      }

      return -1;
   }

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {

      int low = fromIndex;
      int high = toIndex - 1;

      while (low <= high) {
         int middle = low + (high - low) / 2;
         if (comparator.compare(fromArray[middle], aValue) == 0) {
            return middle;
         } else if (comparator.compare(fromArray[middle], aValue) < 0) {
            low = middle + 1;
         } else {
            high = middle - 1;
         }

      }
      return -1;
   }

   public static <E extends Comparable<E>> void fastSort(E[] array) {
      quickSort(array, 0, array.length - 1);
   }

   public static <E> void fastSort(E[] array, Comparator<E> comparator) {
      quickSort(array, comparator);
   }

   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      quickSort(array, fromIndex, toIndex - 1, comparator);

   }

   //////// QUICKSORT ////////

   public static <E extends Comparable<E>> void quickSort(E[] array, int low, int high) {
      if (low < high) {
         int partitionIndex = partition(array, low, high);
         quickSort(array, low, partitionIndex - 1);
         quickSort(array, partitionIndex + 1, high);
      }
   }

   public static <E> void quickSort(E[] array, Comparator<E> comparator) {
      quickSort(array, 0, array.length, comparator);
   }

   public static <E> void quickSort(E[] array, int low, int high, Comparator<E> comparator) {
      if (low < high) {
         int partitionIndex = partition(array, low, high, comparator);
         quickSort(array, low, partitionIndex - 1, comparator);
         quickSort(array, partitionIndex + 1, high, comparator);
      }
   }

   private static <E extends Comparable<E>> int partition(E[] array, int low, int high) {

      E pivot = array[high];

      int leftIndex = low - 1;
      int rightIndex = high + 1;

      while (leftIndex < rightIndex) {
         do {
            leftIndex++;
         } while (array[leftIndex].compareTo(pivot) < 0);

         do {
            rightIndex--;
         } while (array[rightIndex].compareTo(pivot) > 0);

         if (leftIndex < rightIndex) {
            swap(array, leftIndex, rightIndex);
         }

      }
      swap(array, high, rightIndex);
      return rightIndex;
   }

   private static <E> int partition(E[] array, int low, int high, Comparator<E> comparator) {


       int middle = low + (high - low) / 2;

     /*  if (comparator.compare(array[middle], array[low]) < 0){
         swap (array, middle, low);
      }
      if (comparator.compare(array[low], array[high]) < 0){
         swap (array, low, high);
      }
      if (comparator.compare(array[middle], array[high]) < 0){
         swap(array, middle, high);
      }  */
      E pivot = array[middle];

      int leftIndex = low - 1;
      int rightIndex = high + 1;

      while (true) {
         do {
            leftIndex++;
         } while (comparator.compare(array[leftIndex], pivot) < 0);

         do {
            rightIndex--;
         } while (comparator.compare(array[rightIndex], pivot) > 0);


         if (leftIndex >= rightIndex){
            return rightIndex;
         }
         
         swap(array, leftIndex, rightIndex);
         

      }
   }

}
