class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        if(b.equals("")) return 0;
        int i = 1;
        int left = 2;
        String copy = a;

        while(true) {
            if(a.contains(b)) return i;
            if(a.length() > b.length()) left--;
            if(left == 0) return -1;
            a = a + copy;
            i++;  
        }
    }
}