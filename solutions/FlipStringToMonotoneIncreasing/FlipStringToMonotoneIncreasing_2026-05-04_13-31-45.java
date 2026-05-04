class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int one = 0;
        int flips = 0;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') {
                one++;
            } else {
                flips = Math.min(flips + 1, one);
            }
        }
        return flips;
    }
}

/*
Core idea:
if it is one, one++;
if it is zero, either flip to one i.e. one++
               or flip all ones before it
               which is flips = Math.min(flips+1, one)
*/