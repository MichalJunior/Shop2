package pl.camp.it.car.rent;

import org.apache.commons.codec.digest.DigestUtils;

public class Main {
    public static void main(String[] args) {
        String a = new String("ABC");
        String b = new String("ABCd");

        System.out.println(a.equals(b));

        /*String c = null;
        c.equals("ABC");*/

        String hash = DigestUtils.md5Hex("janusz");
        System.out.println(hash);

        System.out.println(DigestUtils.md5Hex("admin" + Authenticator.seed));

        int x = 5;
        boolean y;
        String z;
        if(x == 5) {
            y = true;
            //z = "ABC";
        } else {
            y = false;
            //z = "XYZ";
        }

        y = x==5;

        y = x==5 ? true : false;
        z = x==5 ? "ABC" : "XYZ";
    }
}
