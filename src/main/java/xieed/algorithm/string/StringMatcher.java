package xieed.algorithm.string;

public class StringMatcher {
    public int BruteForce(String master, String pattern){
        int mLen = master.length();
        int pLen = pattern.length();
        if(mLen < pLen){
            return -1;
        }

        char[] mArray = master.toCharArray();
        char[] pArray = pattern.toCharArray();
        for(int i = 0; i<= mLen - pLen; i++){
            boolean matched = true;
            for(int j = 0; j<pLen; j++){
                if(mArray[j + i]!=pArray[j]){
                    matched = false;
                    break;
                }
            }
            if(matched){
                return  i;
            }
        }
        return -1;
    }




    public int RabinKarp(String master, String pattern) {
        int mLen = master.length();
        int pLen = pattern.length();
        if (mLen < pLen) {
            return -1;
        }

        int phash = hashOver26Decimal(pattern);
        int[] subStrsHash = hashSubStrs(master, mLen, pLen);
        //compare hash value
        for (int i = 0; i < subStrsHash.length; i++) {
            if (subStrsHash[i] == phash) {
                return i;
            }
        }

        return -1;
    }

    public int[] hashSubStrs(String master, int mLen, int pLen) {
        int[] subStrHash = new int[mLen-pLen + 1];
        for(int i = 0 ; i<mLen-pLen + 1; i++){
            if(i == 0){
                subStrHash[i] = hashOver26Decimal(master.substring(i,pLen+i));
            }else{
                //h(i) =(h(i-1) - s[i-1]*26^(m-1))*26 + s[i+m-1], m is length of patter str
                subStrHash[i] = (int) ((subStrHash[i-1] -decimal26Value(master.charAt(i-1))*Math.pow(26, pLen - 1))*26 + decimal26Value(master.charAt(i+pLen-1)));
            }
        }

        return subStrHash;
    }

    /**
     * a:1,b:2,c:3,d:4......
     * @param pattern
     * @return
     */
    public int hashOver26Decimal(String pattern) {
        char[] chars = pattern.toCharArray();
        int i = 0;
        int len = pattern.length();
        int hash = 0;
        while(i< len){
            hash += decimal26Value(chars[i]) *Math.pow(26,(len-i-1));
            i++;
        }
        return hash;
    }

    private int decimal26Value(int aChar) {
        return aChar - 'a' + 1;
    }


}
