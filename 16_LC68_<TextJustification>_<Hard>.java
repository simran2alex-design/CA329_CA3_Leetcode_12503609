import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int start = 0;

        while (start < words.length) {
            int end = start;
            int letters = 0;

            // Find as many words as fit on this line
            while (end < words.length &&
                   letters + words[end].length() + (end - start) <= maxWidth) {
                letters += words[end].length();
                end++;
            }

            int gaps = end - start - 1;
            StringBuilder line = new StringBuilder();

            // Last line or a line with one word: use one space between words
            if (end == words.length || gaps == 0) {
                for (int i = start; i < end; i++) {
                    line.append(words[i]);

                    if (i < end - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                // Spread spaces evenly across the gaps
                int spaces = maxWidth - letters;
                int spacesPerGap = spaces / gaps;
                int extraSpaces = spaces % gaps;

                for (int i = start; i < end; i++) {
                    line.append(words[i]);

                    if (i < end - 1) {
                        int spacesHere = spacesPerGap;

                        if (extraSpaces > 0) {
                            spacesHere++;
                            extraSpaces--;
                        }

                        for (int j = 0; j < spacesHere; j++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            start = end;
        }

        return result;
    }
}
