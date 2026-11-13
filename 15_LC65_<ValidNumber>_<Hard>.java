class Solution {
    public boolean isNumber(String s) {
        boolean hasDigit = false;
        boolean hasDot = false;
        boolean hasExponent = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                hasDigit = true;
            } else if (ch == '+' || ch == '-') {
                // A sign is allowed at the start or right after e/E
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (ch == '.') {
                // A dot is allowed once, and only before e/E
                if (hasDot || hasExponent) {
                    return false;
                }
                hasDot = true;
            } else if (ch == 'e' || ch == 'E') {
                // e/E needs a number before it and can appear only once
                if (hasExponent || !hasDigit) {
                    return false;
                }
                hasExponent = true;
                hasDigit = false; // The exponent must also have digits
            } else {
                return false;
            }
        }

        return hasDigit;
    }
}
