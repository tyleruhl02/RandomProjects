package DataStructures.warehouse;

public class PurchaseProduct {
    public static void main(String[] args) {
        StdIn.setFile("Zpurchaseproduct.in");
        StdOut.setFile("Zpurchaseproduct.out");
        // Use this file to test addProduct

        Warehouse a = new Warehouse();
        int l = Integer.parseInt(StdIn.readLine());
        String nextLine;
        String[] data;

        for (int i = 0; i < l; i++) {
            nextLine = StdIn.readLine();
            data = nextLine.split(" ");
            if(data[0].startsWith("add")) {
                a.addProduct(Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]), Integer.parseInt(data[1]), Integer.parseInt(data[5]));
            }
            else {
                a.purchaseProduct(Integer.parseInt(data[2]), Integer.parseInt(data[1]), Integer.parseInt(data[3]));
            }
        }

        StdOut.print(a);
    }
}
