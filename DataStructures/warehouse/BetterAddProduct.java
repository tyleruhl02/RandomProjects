package DataStructures.warehouse;

/*
 * Use this class to test the betterAddProduct method.
 */ 
public class BetterAddProduct {
    public static void main(String[] args) {
        StdIn.setFile("Zbetteraddproduct.in");
        StdOut.setFile("Zbetteraddproduct.out");
        // Use this file to test addProduct

        Warehouse a = new Warehouse();
        int l = Integer.parseInt(StdIn.readLine());
        String nextLine;
        String[] data;

        for (int i = 0; i < l; i++) {
            nextLine = StdIn.readLine();
            data = nextLine.split(" ");
            a.betterAddProduct(Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]), Integer.parseInt(data[0]), Integer.parseInt(data[4]));
        }

        StdOut.print(a);
    }
}
