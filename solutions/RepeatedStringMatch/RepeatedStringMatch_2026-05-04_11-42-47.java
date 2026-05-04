class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        if(b.equals("")) return 0;
        int i = 1;
        int left = 2;
        StringBuilder copy = new StringBuilder(a);

        while(true) {
            if(copy.toString().contains(b)) return i;
            if(copy.length() > b.length()) left--;
            if(left == 0) return -1;
            copy.append(a);
            i++;  
        }
    }
}