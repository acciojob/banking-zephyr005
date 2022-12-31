package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        validateLicenseId();
        this.tradeLicenseId = tradeLicenseId;

        try{
            if(balance < 5000){
                throw new Exception("Insufficient Balance");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    static char getMaxCountChar(int[] charCount){
        int max = 0;
        char ch = 0;
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > max) {
                max = charCount[i];
                ch = (char)((int)'A' + i);
            }
        }
        return ch;
    }

    static String rearrangeString(String tradeLicenseID) {
        int N = tradeLicenseID.length();
        if (N == 0)
            return "";

        int[] charCount = new int[26];
        for (int i = 0; i < 26; i++) {
            charCount[i] = 0;
        }
        for (char ch : tradeLicenseID.toCharArray()) {
            charCount[(int)ch - (int)'A']++;
        }

        char ch_max = getMaxCountChar(charCount);
        int maxCount = charCount[(int)ch_max - (int)'A'];

        // check if the result is possible or not
        if (maxCount > (N + 1) / 2)
            return "";

        String res = "";
        for (int i = 0; i < N; i++) {
            res += ' ';
        }

        int ind = 0;
        // filling the most frequently occurring char in the
        // even indices
        while (maxCount > 0) {
            res = res.substring(0, ind) + ch_max
                    + res.substring(ind + 1);
            ind = ind + 2;
            maxCount--;
        }
        charCount[(int)ch_max - (int)'A'] = 0;

        // now filling the other Chars, first filling the
        // even positions and then the odd positions
        for (int i = 0; i < 26; i++) {
            while (charCount[i] > 0) {
                ind = (ind >= N) ? 1 : ind;
                res = res.substring(0, ind)
                        + (char)((int)'A' + i)
                        + res.substring(ind + 1);
                ind += 2;
                charCount[i]--;
            }
        }
        return res;
    }

    static boolean duplicateConsecutiveCharacterCheck(String tradeLicenseId){
        int size = tradeLicenseId.length();
        for(int i=1; i<size; i++){
            if(tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i-1)){
                return true;
            }
        }
        return false;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        String str = tradeLicenseId;

        try {
            if(duplicateConsecutiveCharacterCheck(tradeLicenseId)){

                String res = rearrangeString(str);

                if (res == "")
                    throw new Exception("Valid License can not be generated");
                else
                    tradeLicenseId = res;
            }
            else{
                return;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
