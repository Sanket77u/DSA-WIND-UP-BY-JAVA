
public class PairsArray {

    // Print all the pairs in an array
    static void printPairArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                System.out.print("(" + a[i] + "," + a[j] + ")");
            }
        }
    }

    // print all the pairs of SubArrays
    static void printSubArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(a[k] + " ");
                }
                System.out.println();
            }
        }

    }

    // print maximum sum of subarray by bruteforce
    static void maxSubByBruteForce(int a[]) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += a[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("Maximum sum of subarray is " + maxSum);
    }

    // print maximum sum of subarray by prefix sum
    static void maxSubByPrefixSum(int a[]) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        int prefixSum[] = new int[a.length];
        prefixSum[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }

        for (int i = 0; i < a.length; i++) {

            for (int j = i; j < a.length; j++) {
                curSum = i == 0 ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
            }
        }

        System.out.print("maxSum by prefix array is " + maxSum);

    }


  //print maximum sum of subarray by kadanes algorithm
  static void maxSumByKadane(int a[]){
    int curSum=0;
    int maxSum=0;
     
    for (int i = 0; i < a.length; i++) {

        curSum = curSum + a[i];

        if (curSum > maxSum) {
            maxSum = curSum;
        }

        if (curSum < 0) {
            curSum = 0;
        }
    }
       System.out.print("maxSum is "+maxSum);
  }





    public static void main(String args[]) {
        int a[] = {1, 2, 3, 4, 5, 6};

        printPairArray(a);
        printSubArray(a);
        maxSubByBruteForce(a);
        maxSubByPrefixSum(a);
        maxSumByKadane(a);
    }
}
