package DataStructures.warehouse;

/*
 *
 * This class implements a warehouse on a Hash Table like structure, 
 * where each entry of the table stores a priority queue. 
 * Due to your limited space, you are unable to simply rehash to get more space. 
 * However, you can use your priority queue structure to delete less popular items 
 * and keep the space constant.
 * 
 * @author Ishaan Ivaturi
 */ 
public class Warehouse {
    private Sector[] sectors;
    
    // Initializes every sector to an empty sector
    public Warehouse() {
        sectors = new Sector[10];

        for (int i = 0; i < 10; i++) {
            sectors[i] = new Sector();
        }
    }
    
    /**
     * Provided method, code the parts to add their behavior
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    public void addProduct(int id, String name, int stock, int day, int demand) {
        evictIfNeeded(id);
        addToEnd(id, name, stock, day, demand);
        fixHeap(id);
    }

    /**
     * Add a new product to the end of the correct sector
     * Requires proper use of the .add() method in the Sector class
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    private void addToEnd(int id, String name, int stock, int day, int demand) {
        sectors[id % 10].add(new Product(id, name, stock, day, demand));
        // IMPLEMENT THIS METHOD
    }

    /**
     * Fix the heap structure of the sector, assuming the item was already added
     * Requires proper use of the .swim() and .getSize() methods in the Sector class
     * @param id The id of the item which was added
     */
    private void fixHeap(int id) {
        for (int i = sectors[id % 10].getSize()/2; i >= 1; i--) {
            sectors[id % 10].sink(i);
        }
        // IMPLEMENT THIS METHOD
    }

    /**
     * Delete the least popular item in the correct sector, only if its size is 5 while maintaining heap
     * Requires proper use of the .swap(), .deleteLast(), and .sink() methods in the Sector class
     * @param id The id of the item which is about to be added
     */
    private void evictIfNeeded(int id) {
        if(sectors[id % 10].getSize() == 5) {
            sectors[id % 10].swap(1, 5);
            sectors[id % 10].deleteLast();
            sectors[id % 10].sink(1);
        }
       // IMPLEMENT THIS METHOD
    }

    /**
     * Update the stock of some item by some amount
     * Requires proper use of the .getSize() and .get() methods in the Sector class
     * Requires proper use of the .updateStock() method in the Product class
     * @param id The id of the item to restock
     * @param amount The amount by which to update the stock
     */
    public void restockProduct(int id, int amount) {
        for (int i = 1; i <= sectors[id % 10].getSize(); i++) {
            if(sectors[id % 10].get(i).getId() == id) {
                sectors[id % 10].get(i).updateStock(amount);
            }
        }
        // IMPLEMENT THIS METHOD
    }
    
    /**
     * Delete some arbitrary product while maintaining the heap structure in O(logn)
     * Requires proper use of the .getSize(), .get(), .swap(), .deleteLast(), .sink() and/or .swim() methods
     * Requires proper use of the .getId() method from the Product class
     * @param id The id of the product to delete
     */
    public void deleteProduct(int id) {
        for (int i = 1; i <= sectors[id % 10].getSize(); i++) {
            if(sectors[id % 10].get(i).getId() == id) {
                sectors[id % 10].swap(i, sectors[id % 10].getSize());
                sectors[id % 10].deleteLast();
                sectors[id % 10].sink(i);
            }
        }
        // IMPLEMENT THIS METHOD
    }
    
    /**
     * Simulate a purchase order for some product
     * Requires proper use of the getSize(), sink(), get() methods in the Sector class
     * Requires proper use of the getId(), getStock(), setLastPurchaseDay(), updateStock(), updateDemand() methods
     * @param id The id of the purchased product
     * @param day The current day
     * @param amount The amount purchased
     */
    public void purchaseProduct(int id, int day, int amount) {
        for (int i = 1; i <= sectors[id % 10].getSize(); i++) {
            if(sectors[id % 10].get(i).getId() == id && sectors[id % 10].get(i).getStock() >= amount) {
                sectors[id % 10].get(i).setLastPurchaseDay(day);
                sectors[id % 10].get(i).updateStock(-amount);
                sectors[id % 10].get(i).setLastPurchaseDay(day);
                sectors[id % 10].get(i).updateDemand(amount);
                sectors[id % 10].swim(i);
            }
        }
    }
    
    /**
     * Construct a better scheme to add a product, where empty spaces are always filled
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    public void betterAddProduct(int id, String name, int stock, int day, int demand) {
        //evictIfNeeded(id);
        //addToEnd(id, name, stock, day, demand);
        //fixHeap(id);
        int index = id % 10;
        int originalIndex = index;
        while(sectors[index].getSize() == 5) {
            index = (index + 1) % 10;
            if(index == originalIndex) {
                evictIfNeeded(index);
                break;
            }
        }
        if(sectors[index].getSize() < 5) {
            sectors[index].add(new Product(id, name, stock, day, demand));
            for (int i = sectors[index].getSize()/2; i >= 1; i--) {
                sectors[index].sink(i);
            }
        }
        System.out.println(index + " " + sectors[index]);
        System.out.println();
        // IMPLEMENT THIS METHOD
    }

    /*
     * Returns the string representation of the warehouse
     */
    public String toString() {
        String warehouseString = "[\n";

        for (int i = 0; i < 10; i++) {
            warehouseString += "\t" + sectors[i].toString() + "\n";
        }
        
        return warehouseString + "]";
    }

    /*
     * Do not remove this method, it is used by Autolab
     */ 
    public Sector[] getSectors () {
        return sectors;
    }
}
