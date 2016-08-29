package ej222up_assign3;

import java.util.Arrays;

/**
 * Created by Elias on 2016-02-24.
 */
public class SortingAlgorithms{
    public static void main(String[] args) {
        int[] firstArray = {5,2,6,1,8,9,12,-2};
        int[] secondArray = insertionSort(firstArray);
        /*for(int i = 0; i<firstArray.length; i++){
            System.out.println(secondArray[i]);
        }
        */
        int[] testArray = mergeSort(firstArray);
        //System.out.println("Before sorting: " + Arrays.toString(firstArray));;
        //System.out.println("After sorting: " + Arrays.toString(testArray));


        String[] people = new String[4];
        people[0] = ("Elias Johansson");
        people[1] = ("Linus Nilsson");
        people[2] = ("Alexander Bertilsson");
        people[3] = ("Viktor Nilsson");
        System.out.println("Merged Sort: " + Arrays.toString(mergedSort(people)));
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSort(people)));
    }
    public static int[] insertionSort(int[] in) { // Sort the array from smallest to largest.
        int[] tempArray = new int[in.length];
        for (int i = 0; i < in.length; i++) {
            tempArray[i] = in[i];
        }
        int temp; // declares a local variable if temp.
        for (int i = 0; i < tempArray.length; i++) { //Goes through each element of the length of in.
            for (int j = i + 1; j < tempArray.length; j++) { //Looks for the element one step ahead of the location i.

                if (in[i] > in[j]) { //If the element on the location of i is higher than the value of j..
                    temp = tempArray[i];  //Saves the value of in to the temporary variable temp.
                    tempArray[i] = tempArray[j]; //Overwrites the value of the location i with the value at the locaion of j.
                    tempArray[j] = temp; //Saves information stored in the temporary variable to the location j.
                    /*
                        Example: if a>b.
                        temp = a;
                        a <-> b.
                        b = temp;
                        b,a.
                     */
                }
            }
        }
        return tempArray; //returns the array in. Containing the new sorted order of elements.
    }

    public static int[] mergeSort(int[] in) {
        int[] temp = new int[in.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = in[i];
        }
        if (temp.length <= 1) {
            return temp;
        }
        int halfSize = temp.length / 2;
        int[] left = new int[halfSize];
        int[] right;
        if(temp.length % 2 == 0){
            right = new int[halfSize];
        }
        else{
            right = new int[halfSize + 1];
        }
        for (int i = 0; i < left.length; i++) {
            left[i] = in[i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = in[j + halfSize];
        }
        left = mergeSort(left);
        right = mergeSort(right);
        temp = merged(left,right);
        return temp;
    }
    public static int[] merged(int[] left, int[] right){
        int resultLength = left.length + right.length;
        int[] mergedArray = new int[resultLength];
        int indexL = 0;
        int indexR = 0;
        int indexM = 0;
        while(indexL < left.length || indexR < right.length){
            if(indexL < left.length && indexR < right.length) {
                if (left[indexL] <= right[indexR]) {
                    mergedArray[indexM] = left[indexL];
                    indexL++;
                    indexM++;
                } else {
                    mergedArray[indexM] = right[indexR];
                    indexR++;
                    indexM++;
                }
            }
            else if(indexL < left.length){
                mergedArray[indexM] = left[indexL];
                indexM++;
                indexL++;
            }
            else if(indexR < right.length){
                mergedArray[indexM] = right[indexR];
                indexM++;
                indexR++;
            }
            System.out.println(Arrays.toString(mergedArray));
        }
        return mergedArray;
    }

    public static String[] mergedSort(String[] in) {
        String[] temp = new String[in.length];
        for(int i = 0; i < in.length; i++){
            temp[i] = in[i];
        }
        if(in.length <= 1)
            return temp;
        int midIndex = in.length/2;
        String[] left = new String[midIndex];
        String[] right;
        if(in.length % 2 == 0)
            right = new String[midIndex];
        else
            right = new String[midIndex + 1];

        for(int i = 0; i < left.length; i++){
            left[i] = in[i];
        }
        for(int j = 0; j < right.length; j++){
            right[j] = in[j + midIndex];
        }
        left = mergedSort(left);
        right = mergedSort(right);
        temp = merged(left,right);
        return temp;
    }

    public static String[] merged(String[] left, String[] right){
        int resultLength = left.length + right.length;
        String[] mergedArray = new String[resultLength];
        int indexL = 0;
        int indexR = 0;
        int indexM = 0;
        while(indexL < left.length || indexR < right.length){
            if(indexL < left.length && indexR < right.length) {
                if (left[indexL].compareTo(right[indexR]) <= 0) {
                    mergedArray[indexM] = left[indexL];
                    indexL++;
                    indexM++;
                }
                else{
                    mergedArray[indexM] = right[indexR];
                    indexR++;
                    indexM++;
                }
            }
            else if(indexL < left.length){
                mergedArray[indexM] = left[indexL];
                indexM++;
                indexL++;
            }
            else if(indexR < right.length){
                mergedArray[indexM] = right[indexR];
                indexM++;
                indexR++;
            }
            System.out.println(Arrays.toString(mergedArray));
        }
        return mergedArray;
    }
    public static String[] insertionSort(String[] in) { // Sort the array from smallest to largest.
        String[] tempArray = new String[in.length];
        for (int i = 0; i < in.length; i++) {
            tempArray[i] = in[i];
        }
        String temp; // declares a local variable if temp.
        for (int i = 0; i < tempArray.length; i++) { //Goes through each element of the length of in.
            for (int j = i + 1; j < tempArray.length; j++) { //Looks for the element one step ahead of the location i.
                if (in[i].compareTo(in[j]) >= 0) { //If the element on the location of i is higher than the value of j..
                    temp = tempArray[i];  //Saves the value of in to the temporary variable temp.
                    tempArray[i] = tempArray[j]; //Overwrites the value of the location i with the value at the locaion of j.
                    tempArray[j] = temp; //Saves information stored in the temporary variable to the location j.
                    /*
                        Example: if a>b.
                        temp = a;
                        a <-> b.
                        b = temp;
                        b,a.
                     */
                }
            }
        }
        return tempArray; //returns the array in. Containing the new sorted order of elements.
    }
}