package DataStructures.warehouse;

public class Restock {
    public static void main(String[] args) {
        StdIn.setFile("Zrestock.in");
        StdOut.setFile("Zrestock.out");
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
                a.restockProduct(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            }
        }

        StdOut.print(a);
    }
}
