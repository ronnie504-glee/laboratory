public class ModifiedBinarySearch {

    static void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
    }

    // Finds the index of the FIRST occurrence of target in arr[low..high].
    static int findFirst(int[] arr, int target, int low, int high, int depth) {
        printIndent(depth);
        System.out.println("-> call  findFirst(low=" + low + ", high=" + high + ")");

        int result = -1;
        if (low <= high) {
            int mid = low + (high - low) / 2;
            printIndent(depth);
            System.out.println("   mid=" + mid + " -> arr[" + mid + "]=" + arr[mid]);

            if (arr[mid] == target) {
                // Found a match, but keep searching the LEFT half for an earlier one.
                int leftResult = findFirst(arr, target, low, mid - 1, depth + 1);
                result = (leftResult != -1) ? leftResult : mid;
            } else if (arr[mid] < target) {
                result = findFirst(arr, target, mid + 1, high, depth + 1);
            } else {
                result = findFirst(arr, target, low, mid - 1, depth + 1);
            }
        }

        printIndent(depth);
        System.out.println("<- return findFirst(low=" + low + ", high=" + high + ") = " + result);
        return result;
    }

    // Finds the index of the LAST occurrence of target in arr[low..high].
    static int findLast(int[] arr, int target, int low, int high, int depth) {
        printIndent(depth);
        System.out.println("-> call  findLast(low=" + low + ", high=" + high + ")");

        int result = -1;
        if (low <= high) {
            int mid = low + (high - low) / 2;
            printIndent(depth);
            System.out.println("   mid=" + mid + " -> arr[" + mid + "]=" + arr[mid]);

            if (arr[mid] == target) {
                // Found a match, but keep searching the RIGHT half for a later one.
                int rightResult = findLast(arr, target, mid + 1, high, depth + 1);
                result = (rightResult != -1) ? rightResult : mid;
            } else if (arr[mid] < target) {
                result = findLast(arr, target, mid + 1, high, depth + 1);
            } else {
                result = findLast(arr, target, low, mid - 1, depth + 1);
            }
        }

        printIndent(depth);
        System.out.println("<- return findLast(low=" + low + ", high=" + high + ") = " + result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 4, 4, 8, 9, 11, 11, 15};
        int target = 4;

        System.out.println("Array: " + java.util.Arrays.toString(arr));
        System.out.println("Target: " + target);

        System.out.println("\n=== Finding first occurrence ===");
        int first = findFirst(arr, target, 0, arr.length - 1, 0);

        System.out.println("\n=== Finding last occurrence ===");
        int last = findLast(arr, target, 0, arr.length - 1, 0);

        System.out.println("\nFirst occurrence index: " + first);
        System.out.println("Last occurrence index:  " + last);
        if (first != -1) {
            System.out.println("Total occurrences: " + (last - first + 1));
        }
    }
}
