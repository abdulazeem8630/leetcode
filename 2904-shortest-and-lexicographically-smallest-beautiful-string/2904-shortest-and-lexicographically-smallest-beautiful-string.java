class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int minLength = Integer.MAX_VALUE;
        String result = "";
        
        int left = 0;
        int countOnes = 0;
        
        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                countOnes++;
            }
            
            while (countOnes == k) {
                if (s.charAt(left) == '1') {
                    int currentLength = right - left + 1;
                    String currentSubstring = s.substring(left, right + 1);
                    if (currentLength < minLength) {
                        minLength = currentLength;
                        result = currentSubstring;
                    } else if (currentLength == minLength) {
                        if (currentSubstring.compareTo(result) < 0) {
                            result = currentSubstring;
                        }
                    }
                    
                    countOnes--;
                }
                left++;
            }
        }
        
        return result;
    }
}
