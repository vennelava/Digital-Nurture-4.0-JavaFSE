public class main {
    public static void main(String[] args) {
        testAssertions();
    }
    public static void testAssertions() {
        if (2 + 3 == 5) {
            System.out.println("assert Equals PASSED");
        } else {
            System.out.println("assert Equals FAILED");
        }
        if (5 > 3) {
            System.out.println("assert True PASSED");
        } else {
            System.out.println("assert True FAILED");
        }
        if (!(5 < 3)) {
            System.out.println("assert False PASSED");
        } else {
            System.out.println("assert False FAILED");
        }
        Object obj = null;
        if (obj == null) {
            System.out.println("assert Null PASSED");
        } else {
            System.out.println("assert Null FAILED");
        }
        Object obj2 = new Object();
        if (obj2 != null) {
            System.out.println("assert NotNull PASSED");
        } else {
            System.out.println("assert NotNull FAILED");
        }
    }
}
