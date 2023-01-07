package DataStructures.transit;
//package transit;

import java.util.ArrayList;

/**
 * This class contains methods which perform various operations on a layered linked
 * list to simulate transit
 * 
 * @author Ishaan Ivaturi
 * @author Prince Rawal
 */
public class Transit {
	private TNode trainZero; // a reference to the zero node in the train layer

	/* 
	 * Default constructor used by the driver and Autolab. 
	 * DO NOT use in your code.
	 * DO NOT remove from this file
	 */ 
	public Transit() { trainZero = null; }

	/* 
	 * Default constructor used by the driver and Autolab. 
	 * DO NOT use in your code.
	 * DO NOT remove from this file
	 */
	public Transit(TNode tz) { trainZero = tz; }
	
	/*
	 * Getter method for trainZero
	 *
	 * DO NOT remove from this file.
	 */
	public TNode getTrainZero () {
		return trainZero;
	}

	/**
	 * Makes a layered linked list representing the given arrays of train stations, bus
	 * stops, and walking locations. Each layer begins with a location of 0, even though
	 * the arrays don't contain the value 0. Store the zero node in the train layer in
	 * the instance variable trainZero.
	 * 
	 * @param trainStations Int array listing all the train stations
	 * @param busStops Int array listing all the bus stops
	 * @param locations Int array listing all the walking locations (always increments by 1)
	 */
	public void makeList(int[] trainStations, int[] busStops, int[] locations) {
	    TNode[] nodeLocations = new TNode[locations.length+1];
	    nodeLocations[locations.length] = new TNode(locations[locations.length-1], null, null);
		for (int i = locations.length-2; i >= 0; i--) {
            nodeLocations[i+1] = new TNode(locations[i], nodeLocations[i+2], null);
		}
        nodeLocations[0] = new TNode(0, nodeLocations[1], null);
		TNode[] nodeBusStops = new TNode[busStops.length+1];
		nodeBusStops[busStops.length] = new TNode(busStops[busStops.length-1], null, nodeLocations[busStops[busStops.length-1]]);
        for (int i = busStops.length-2; i >= 0; i--) {
            nodeBusStops[i+1] = new TNode(busStops[i], nodeBusStops[i+2], nodeLocations[busStops[i]]);
        }
        nodeBusStops[0] = new TNode(0, nodeBusStops[1], nodeLocations[0]);
        TNode[] nodeTrainStations = new TNode[trainStations.length+1];
        nodeTrainStations[trainStations.length] = new TNode(trainStations[trainStations.length-1], null, nodeBusStops[getIndexOfLocation(nodeBusStops, trainStations[trainStations.length-1])]);
        for (int i = trainStations.length-2; i >= 0; i--) {
            nodeTrainStations[i+1] = new TNode(trainStations[i], nodeTrainStations[i+2], nodeBusStops[getIndexOfLocation(nodeBusStops, trainStations[i])]);
        }
        nodeTrainStations[0] = new TNode(0, nodeTrainStations[1], nodeBusStops[0]);
        trainZero = nodeTrainStations[0];
	    // UPDATE THIS METHOD
	}

	private int getIndexOfLocation(TNode[] a, int location) {
        for (int i = 0; i < a.length; i++) {
            if(a[i].getLocation() == location) {
                return i;
            }
        }
	    return -1;
    }
	
	/**
	 * Modifies the layered list to remove the given train station but NOT its associated
	 * bus stop or walking location. Do nothing if the train station doesn't exist
	 * 
	 * @param station The location of the train station to remove
	 */
	public void removeTrainStation(int station) {
	    TNode currentStation = getTrainZero();
        while(currentStation.getNext() != null) {
            if(currentStation.getNext().getLocation() == station) {
                currentStation.setNext(currentStation.getNext().getNext());
                break;
            }
            currentStation = currentStation.getNext();
        }
        // UPDATE THIS METHOD
	}

	/**
	 * Modifies the layered list to add a new bus stop at the specified location. Do nothing
	 * if there is no corresponding walking location.
	 * 
	 * @param busStop The location of the bus stop to add
	 */
	public void addBusStop(int busStop) {
        TNode currentStation = getTrainZero().getDown();
        while(currentStation.getNext().getLocation() <= busStop) {
            currentStation = currentStation.getNext();
            if(currentStation.getNext() == null) {
                break;
            }
        }
        if(currentStation.getLocation() == busStop) {
            return;
        }
        currentStation.setNext(new TNode(busStop, currentStation.getNext(), null));
        currentStation = currentStation.getNext();
        TNode locationStation = getTrainZero().getDown().getDown();
        while(locationStation.getNext() != null && locationStation.getNext().getLocation() <= busStop) {
            locationStation = locationStation.getNext();
            System.out.println(locationStation.getLocation());
        }
        System.out.println(currentStation.getLocation());
        System.out.println(locationStation.getLocation());
        currentStation.setDown(locationStation);
	    // UPDATE THIS METHOD
	}
	
	/**
	 * Determines the optimal path to get to a given destination in the walking layer, and 
	 * collects all the nodes which are visited in this path into an arraylist. 
	 * 
	 * @param destination An int representing the destination
	 * @return
	 */
	public ArrayList<TNode> bestPath(int destination) {
	    ArrayList<TNode> output = new ArrayList<>();
        TNode currentLocation = getTrainZero();
        do {
            while(currentLocation.getNext() != null && currentLocation.getNext().getLocation() <= destination) {
                output.add(currentLocation);
                currentLocation = currentLocation.getNext();
            }
            output.add(currentLocation);
            currentLocation = currentLocation.getDown();
        } while (currentLocation != null);
        return output;
	    // UPDATE THIS METHOD
	}

	/**
	 * Returns a deep copy of the given layered list, which contains exactly the same
	 * locations and connections, but every node is a NEW node.
	 * 
	 * @return A reference to the train zero node of a deep copy
	 */
	public TNode duplicate() {
        TNode newTrainZero = new TNode(0, null, null);
        TNode oldPtr = getTrainZero();
        TNode newPtr = newTrainZero;
        int counter = 0;
        while(oldPtr.getDown() != null) { // creates location 0 stations
            newPtr.setDown(new TNode(0, null, null));
            oldPtr = oldPtr.getDown();
            newPtr = newPtr.getDown();
            counter++;
        }
        oldPtr = oldPtr.getNext();
        while(oldPtr != null) { // updates walking location next values
            newPtr.setNext(new TNode(oldPtr.getLocation(), null, null));
            oldPtr = oldPtr.getNext();
            newPtr = newPtr.getNext();
        }
        TNode alternativePtr;
        for (int i = 0; i < counter; i++) {
            oldPtr = getTrainZero();
            newPtr = newTrainZero;
            for (int j = 0; j < counter-1-i; j++) {
                oldPtr = oldPtr.getDown();
                newPtr = newPtr.getDown();
            }
            alternativePtr = newPtr.getDown();
            oldPtr = oldPtr.getNext();
            while(oldPtr != null) {
                while(alternativePtr.getLocation()!=oldPtr.getLocation()) {
                    alternativePtr = alternativePtr.getNext();
                }
                newPtr.setNext(new TNode(oldPtr.getLocation(), null, alternativePtr));
                alternativePtr = alternativePtr.getNext();
                newPtr = newPtr.getNext();
                oldPtr = oldPtr.getNext();
            }
        }
	    // UPDATE THIS METHOD
	    return newTrainZero;
	}

	/**
	 * Modifies the given layered list to add a scooter layer in between the bus and
	 * walking layer.
	 * 
	 * @param scooterStops An int array representing where the scooter stops are located
	 */
	public void addScooter(int[] scooterStops) {
	    TNode nextScooterStop = new TNode(scooterStops[scooterStops.length-1]);
	    TNode currentScooterStop;
        for (int i = scooterStops.length-2; i >= 0; i--) { // creates all scooter nodes
            currentScooterStop = new TNode(scooterStops[i], nextScooterStop, null);
            nextScooterStop = currentScooterStop;
        }
        nextScooterStop = new TNode(0, nextScooterStop, trainZero.getDown().getDown());
        TNode alternativePointer = getTrainZero().getDown();
        while(alternativePointer != null) { // updates busStops down pointers
            while(alternativePointer.getLocation() != nextScooterStop.getLocation()) {
                nextScooterStop = nextScooterStop.getNext();
            }
            alternativePointer.setDown(nextScooterStop);
            alternativePointer = alternativePointer.getNext();
        }
        alternativePointer = getTrainZero().getDown().getDown().getDown();
        nextScooterStop = getTrainZero().getDown().getDown();
        while(nextScooterStop != null) { // updates scooter down pointers
            while(nextScooterStop.getLocation() != alternativePointer.getLocation()) {
                alternativePointer = alternativePointer.getNext();
            }
            nextScooterStop.setDown(alternativePointer);
            nextScooterStop = nextScooterStop.getNext();
        }
	    // UPDATE THIS METHOD
        printList();
	}

	/**
	 * Used by the driver to display the layered linked list. 
	 * DO NOT edit.
	 */
	public void printList() {
		// Traverse the starts of the layers, then the layers within
		for (TNode vertPtr = trainZero; vertPtr != null; vertPtr = vertPtr.getDown()) {
			for (TNode horizPtr = vertPtr; horizPtr != null; horizPtr = horizPtr.getNext()) {
				// Output the location, then prepare for the arrow to the next
				StdOut.print(horizPtr.getLocation());
				if (horizPtr.getNext() == null) break;
				
				// Spacing is determined by the numbers in the walking layer
				for (int i = horizPtr.getLocation()+1; i < horizPtr.getNext().getLocation(); i++) {
					StdOut.print("--");
					int numLen = String.valueOf(i).length();
					for (int j = 0; j < numLen; j++) StdOut.print("-");
				}
				StdOut.print("->");
			}

			// Prepare for vertical lines
			if (vertPtr.getDown() == null) break;
			StdOut.println();
			
			TNode downPtr = vertPtr.getDown();
			// Reset horizPtr, and output a | under each number
			for (TNode horizPtr = vertPtr; horizPtr != null; horizPtr = horizPtr.getNext()) {
				while (downPtr.getLocation() < horizPtr.getLocation()) downPtr = downPtr.getNext();
				if (downPtr.getLocation() == horizPtr.getLocation() && horizPtr.getDown() == downPtr) StdOut.print("|");
				else StdOut.print(" ");
				int numLen = String.valueOf(horizPtr.getLocation()).length();
				for (int j = 0; j < numLen-1; j++) StdOut.print(" ");
				
				if (horizPtr.getNext() == null) break;
				
				for (int i = horizPtr.getLocation()+1; i <= horizPtr.getNext().getLocation(); i++) {
					StdOut.print("  ");

					if (i != horizPtr.getNext().getLocation()) {
						numLen = String.valueOf(i).length();
						for (int j = 0; j < numLen; j++) StdOut.print(" ");
					}
				}
			}
			StdOut.println();
		}
		StdOut.println();
	}
	
	/**
	 * Used by the driver to display best path. 
	 * DO NOT edit.
	 */
	public void printBestPath(int destination) {
		ArrayList<TNode> path = bestPath(destination);
		for (TNode vertPtr = trainZero; vertPtr != null; vertPtr = vertPtr.getDown()) {
			for (TNode horizPtr = vertPtr; horizPtr != null; horizPtr = horizPtr.getNext()) {
				// ONLY print the number if this node is in the path, otherwise spaces
				if (path.contains(horizPtr)) StdOut.print(horizPtr.getLocation());
				else {
					int numLen = String.valueOf(horizPtr.getLocation()).length();
					for (int i = 0; i < numLen; i++) StdOut.print(" ");
				}
				if (horizPtr.getNext() == null) break;
				
				// ONLY print the edge if both ends are in the path, otherwise spaces
				String separator = (path.contains(horizPtr) && path.contains(horizPtr.getNext())) ? ">" : " ";
				for (int i = horizPtr.getLocation()+1; i < horizPtr.getNext().getLocation(); i++) {
					StdOut.print(separator + separator);
					
					int numLen = String.valueOf(i).length();
					for (int j = 0; j < numLen; j++) StdOut.print(separator);
				}

				StdOut.print(separator + separator);
			}
			
			if (vertPtr.getDown() == null) break;
			StdOut.println();

			for (TNode horizPtr = vertPtr; horizPtr != null; horizPtr = horizPtr.getNext()) {
				// ONLY print the vertical edge if both ends are in the path, otherwise space
				StdOut.print((path.contains(horizPtr) && path.contains(horizPtr.getDown())) ? "V" : " ");
				int numLen = String.valueOf(horizPtr.getLocation()).length();
				for (int j = 0; j < numLen-1; j++) StdOut.print(" ");
				
				if (horizPtr.getNext() == null) break;
				
				for (int i = horizPtr.getLocation()+1; i <= horizPtr.getNext().getLocation(); i++) {
					StdOut.print("  ");

					if (i != horizPtr.getNext().getLocation()) {
						numLen = String.valueOf(i).length();
						for (int j = 0; j < numLen; j++) StdOut.print(" ");
					}
				}
			}
			StdOut.println();
		}
		StdOut.println();
	}
}
