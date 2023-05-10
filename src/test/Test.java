package test;

public class Test {

    static String farmNane;
    RedCow cow;

    Test() {

    }

    Test(String s) {
        cow = new RedCow(150, 112, 500);
        farmNane = s;
    }

    static class RedCow {
        String cowName = "红牛";
        int height, weight, price;

        RedCow(int h, int w, int p) {
            height = h;
            weight = w;
            price = p;
        }

    }

}

