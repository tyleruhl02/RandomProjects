package DataStructures.warehouse;

/*
 * Use this class to test the deleteProduct method.
 */ 
public class DeleteProduct {
    public static void main(String[] args) {
        StdIn.setFile("Zdeleteproduct.in");
        StdOut.setFile("Zdeleteproduct.out");
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
                a.deleteProduct(Integer.parseInt(data[1]));
            }
        }

        StdOut.print(a);
    }
}
