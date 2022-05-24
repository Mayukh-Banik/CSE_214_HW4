// Mayukh Banik 114489797 R03 mayukh.banik@stonybrook.edu
import java.util.*;
public class PassengerQueue extends ArrayList
{
    private final ArrayList<Passenger> passengerArrayList;

    /**
     * constructor to initialize passengerarraylist
     */
    public PassengerQueue()
    {
        passengerArrayList = new ArrayList<>(0);
    }

    /**
     * adds to the endd of the array list
     * @param passenger passenger to be added to the end of the array list
     */
    public void enqueue(Passenger passenger)
    {
        passengerArrayList.add(passenger);
    }

    /**
     * removes the first passenger in the array list
     * @return the passenger at the beggining of the list
     */
    public Passenger dequeue()
    {
        Passenger passenger = passengerArrayList.get(0);
        passengerArrayList.remove(0);
        return passenger;
    }

    /**
     * looks at the first passenger in the queue
     * @return the passenger first in line
     */
    public Passenger peek()
    {
        return passengerArrayList.get(0);
    }

    /**
     * checks if the arraylist is empty
     * @return boolean of whether it is empty or not
     */
    public boolean isEmpty()
    {
        return passengerArrayList.isEmpty();
    }

    /**
     * string representaiton of the arraylist
     * @return string of the arraylist
     */
    public String toString()
    {
        StringBuilder string = new StringBuilder("[");
        for (Passenger passenger : passengerArrayList)
        {
            string.append(" ").append(passenger).append(" ");
        }
        string.append("]");
        return string.toString();
    }

    /**
     * size of this array list
     * @return int of the length
     */
    public int size()
    {
        return passengerArrayList.size();
    }
}