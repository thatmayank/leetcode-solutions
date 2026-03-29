class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;

        //case 1: swap 0 with 2
        String temp1 = swap(s2.toCharArray(), 0, 2);
        if(temp1.equals(s1)) return true;
        //case 2: swap 1 with 3
        String temp2 = swap(s2.toCharArray(), 1, 3);
        if(temp2.equals(s1)) return true;
        //case 3: swap both
        String temp3 = swap(temp1.toCharArray(), 1, 3);
        if(temp3.equals(s1)) return true;

        return false;
    }

    private String swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;

        return new String(s);
    }
}