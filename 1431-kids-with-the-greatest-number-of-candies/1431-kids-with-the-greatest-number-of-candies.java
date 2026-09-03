import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> ans = new ArrayList<>();
        
        for (int c : candies) {
            ans.add(c + extraCandies >= max);
        }
        
        return ans;
    }
}
