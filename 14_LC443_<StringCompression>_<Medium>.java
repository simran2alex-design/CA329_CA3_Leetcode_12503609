class Solution {
    public int compress(char[] chars) {
        int read = 0;  // Looks through the original characters
        int write = 0; // Writes the compressed characters

        while (read < chars.length) {
            char letter = chars[read];
            int count = 0;

            // Count how many times this letter repeats in a row
            while (read < chars.length && chars[read] == letter) {
                count++;
                read++;
            }

            // Write the letter
            chars[write] = letter;
            write++;

            // Write the count only when it is greater than 1
            if (count > 1) {
                String countText = String.valueOf(count);

                for (int i = 0; i < countText.length(); i++) {
                    chars[write] = countText.charAt(i);
                    write++;
                }
            }
        }

        return write;
    }
}
