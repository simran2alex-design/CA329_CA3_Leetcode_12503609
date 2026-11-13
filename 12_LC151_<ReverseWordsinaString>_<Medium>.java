class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        String answer = "";

        for (int i = words.length - 1; i >= 0; i--) {
            answer = answer + words[i];

            if (i > 0) {
                answer = answer + " ";
            }
        }

        return answer;
    }
}
