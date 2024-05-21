public class PalindromeTriangle {
    public static void printPattern(Integer n) {
        int i,j;
        for(i = 1; i <= n; i++) {
            for(j = 1; j <= 2* (n-1); j++) {
                System.out.println(" ");
            }
        }
        for(j = i; j >= 1; j--) {
            System.out.println(j + " ");
        }
        for(j = 2; j <= i; j++) {
            System.out.println(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printPattern(6);
    }

    // @Test
    // void addition() {
    //     assertEquals(2, 1 + 1);
    // }
}
