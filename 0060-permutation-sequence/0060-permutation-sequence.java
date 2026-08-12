import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        k = k - 1;
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            sb.append(numbers.get(index));
            
            numbers.remove(index);
            
            k = k % factorial[i];
        }

        return sb.toString();
    }
}
