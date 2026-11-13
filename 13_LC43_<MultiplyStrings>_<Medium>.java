class Solution {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;
                int position = i + j + 1;

                int sum = product + result[position];

                result[position] = sum % 10;
                result[position - 1] += sum / 10;
            }
        }

        String answer = "";

        for (int digit : result) {
            // Skip zeros at the start of the answer
            if (answer.length() > 0 || digit != 0) {
                answer = answer + digit;
            }
        }

        if (answer.length() == 0) {
            return "0";
        }

        return answer;
    }
}
