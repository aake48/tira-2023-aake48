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


      if (array != null && fromIndex >= 0 && toIndex <= array.length){
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
      
      while (low <= high){
          int middle = low + (high - low) / 2;
          if (fromArray[middle].compareTo(aValue) == 0){
            return middle;
          }else if (fromArray[middle].compareTo(aValue) < 0){
            low = middle + 1;
          }else{
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

      while (low <= high){
          int middle = low + (high - low) / 2;
         if (comparator.compare(fromArray[middle], aValue) == 0){
            return middle;
         }else if(comparator.compare(fromArray[middle], aValue) < 0){
            low = middle - 1;
         }else{
            high = middle - 1;
         }
          
      }
      return -1;
   }

   public static <E extends Comparable<E>> void fastSort(E[] array) {
      // TODO: Student, implement this.
   }

   public static <E> void fastSort(E[] array, Comparator<E> comparator) {
      // TODO: Student, implement this.
   }

   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      // TODO: Student, implement this.
   }

}
