package DataStructures.warehouse;

/*
 * Use this class to put it all together.
 */ 
public class Everything {
    public static void main(String[] args) {
        StdIn.setFile("Zeverything.in");
        StdOut.setFile("Zeverything.out");
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
            else if (data[0].startsWith("purchase")){
                a.purchaseProduct(Integer.parseInt(data[2]), Integer.parseInt(data[1]), Integer.parseInt(data[3]));
            }
            else if (data[0].startsWith("restock")) {
                a.restockProduct(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            }
            else if (data[0].startsWith("delete")) {
                a.deleteProduct(Integer.parseInt(data[1]));
            }
        }

        StdOut.print(a);
    }
}
