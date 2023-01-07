package HighSchool.CnData.BCA.util2;


public class TreePrinter {
    public static void main(String[] args) {
        BCABinaryTree<String> t = new BCABinaryTree<>();

        t.insert("Lion");
        t.insert("Frog");
        t.insert("Dog");
        t.insert("Monkey");
        t.insert("Horse");
        t.insert("Fish");
        t.insert("Zebra");
        t.insert("Aphid");
        t.insert("Cow");
        t.insert("Wolf");

        t.printTree();
    }
}
