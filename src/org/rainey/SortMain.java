package org.rainey;

public class SortMain {
    public static void main(String[] args) {
        String[] stringArgs = args[0].split(",");
        int[] nums = new int[stringArgs.length];
        for(int i = 0; i<stringArgs.length; i++){
            nums[i] = Integer.parseInt(stringArgs[i]);
        }

        //mergeSort(nums);
        quickSort(nums,0,nums.length-1);

        System.out.println("stopper");

    }

    public static void quickSort(int[] nums, int start, int end){
        if (start==end){return;}
        int p = partition(nums,start,end);
        if(start<=p) {
            quickSort(nums, start, p - 1);
        }
        if(p<end) {
            quickSort(nums, p, end);
        }

        System.out.println("stopper");
    }

    public static int partition(int[] nums, int start, int end){
        int p = nums[(start+end)/2];
        while (start<=end){
            while(nums[start]<p){start++;}
            while(nums[end]>p){end--;}

            if(start<=end){
                int startVal = nums[start];
                int endVal = nums[end];
                nums[start]=endVal;
                nums[end]=startVal;
                start++;
                end--;
            }
        }
        return start;
    }

    public static void mergeSort(int[] nums){
        int[] sorted = sortForMerge(nums,0,nums.length-1);

        System.out.println("stopper");
    }
    public static int[] sortForMerge(int[] nums, int start, int end){
        if(end-start<=0){
            int[] result = new int[1];
            result[0]=nums[start];
            return result;
        } else if (end-start<=1){
            int[] result = new int[2];
            if(nums[0]<nums[1]){
                result[0]=nums[start];
                result[1]=nums[end];
                return result;
            } else {
                result[1]=nums[start];
                result[0]=nums[end];
                return result;
            }
        } else {

            int middle = (start + end) / 2;
            int[] sortedLeft = sortForMerge(nums, start, middle);
            int[] sortedRight = sortForMerge(nums, middle + 1, end);

            int[] result = mergeSorted(sortedLeft, sortedRight);
            return result;
        }
    }

    public static int[] mergeSorted(int[] left, int[] right){
        int[] result = new int[left.length+right.length];
        int leftI=0;
        int rightI=0;
        int resultI=0;

        while (leftI<left.length || rightI<right.length){
            if(leftI>=left.length){
                result[resultI]=right[rightI];
                resultI++;
                rightI++;
                continue;
            }
            if(rightI>=right.length){
                result[resultI]=left[leftI];
                resultI++;
                leftI++;
                continue;
            }

            if (left[leftI]<right[rightI]){
                result[resultI]=left[leftI];
                resultI++;
                leftI++;
            } else {
                result[resultI]=right[rightI];
                resultI++;
                rightI++;
            }
        }
        return result;
    }
}
