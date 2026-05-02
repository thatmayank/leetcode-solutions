class Solution {
    public int rotatedDigits(int n) {
        int count = 0;

        for(int i = 0; i <= n; i++) {
            int num = i;
            boolean invalid = false;
            boolean notSame = false;

            while(num != 0) {
                int digit = num % 10;

                if(digit == 3 || digit == 4 || digit == 7) {
                    invalid = true;
                    break;
                }

                if(digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                    notSame = true;
                }

                num = num / 10;
            }

            count += (invalid == false && notSame == true) ? 1 : 0;
        }
        return count;
    }
}