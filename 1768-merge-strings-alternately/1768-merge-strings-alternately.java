class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        String word = "";
        while(i<word1.length() && j<word2.length()){
            word = word + word1.charAt(i) + word2.charAt(j);
            i++;
            j++;
        }
        while(i<word1.length()){
            word += word1.charAt(i++);
        }
        while(j<word2.length()){
            word += word2.charAt(j++);
        }
        return word;
    }
}