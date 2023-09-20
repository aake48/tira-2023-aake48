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


      //Don Hämäläinen auttanut algoritmin "siistimisessä",
      //aikasempi toteutus tehty kahdella for -silmukalla.
      for (int currentIndex = fromIndex; currentIndex < toIndex / 2; currentIndex++) {
         swap(array, currentIndex, toIndex - 1 - currentIndex);
      }

   }

   ///////////////////////////////////////////
   // Binary search bw indices
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      return -1;
   }

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
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
