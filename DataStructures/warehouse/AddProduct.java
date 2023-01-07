package DataStructures.warehouse;

import java.util.Arrays;

/*
 * Use this class to test to addProduct method.
 */
public class AddProduct {
    public static void main(String[] args) {
        StdIn.setFile("Zaddproduct.in");
        StdOut.setFile("Zaddproduct.out");
	    // Use this file to test addProduct

        Warehouse a = new Warehouse();
        int l = Integer.parseInt(StdIn.readLine());
        String nextLine;
        String[] data;

        for (int i = 0; i < l; i++) {
            nextLine = StdIn.readLine();
            data = nextLine.split(" ");
            a.addProduct(Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]), Integer.parseInt(data[0]), Integer.parseInt(data[4]));
        }

        StdOut.print(a);
    }
}