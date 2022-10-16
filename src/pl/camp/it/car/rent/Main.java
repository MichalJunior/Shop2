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
    }
}
