// Mayukh Banik 114489797 R03 mayukh.banik@stonybrook.edu
public class Station
{
    private final PassengerQueue firstClass;
    private final PassengerQueue secondClass;
    private BooleanSource firstArrival;
    private BooleanSource secondArrival;
    public int numberOfFirstClassArrived;
    public int numberOfSecondClassArrived;
    public int numberOfFirstClassDeque;
    public int numberOfSecondClassDeque;
    public int firstClassTotalTimeWaiting;
    public int secondClassTotalTimeWaiting;

    /**
     * initializes all the data fields
     */
    public Station()
    {
        firstClass = new PassengerQueue();
        secondArrival = null;
        secondClass = new PassengerQueue();
        firstArrival = null;
        numberOfFirstClassDeque = 0;
        numberOfSecondClassDeque = 0;
        numberOfSecondClassArrived = 0;
        numberOfFirstClassArrived = 0;
    }

    /**
     * size of the passengers waiting in the station
     * @return the number of people waiting
     */
    public int firstClassSize()
    {
        return firstClass.size();
    }

    /**
     * size of the passengers waiting in the station
     * @return the number of people waiting
     */
    public int secondClassSize()
    {
        return secondClass.size();
    }

    /**
     * simulates a timestamp of the program
     */
    public void simulateTimeStep()
    {
        Passenger tempPassenger1 = new Passenger();
        Passenger tempPassenger2 = new Passenger();
        if (firstArrival.occurs())
        {
            tempPassenger1.setFirstClass(true);
            tempPassenger1.setId(LIRRSimulator.idNumber);
            LIRRSimulator.idNumber++;
            firstClass.enqueue(tempPassenger1);
            numberOfFirstClassArrived++;
        }
        if (secondArrival.occurs())
        {
            tempPassenger2.setFirstClass(false);
            tempPassenger2.setId(LIRRSimulator.idNumber);
            LIRRSimulator.idNumber++;
            secondClass.enqueue(tempPassenger2);
            numberOfSecondClassArrived++;
        }
        firstClassTotalTimeWaiting = firstClassTotalTimeWaiting + firstClass.size();
        secondClassTotalTimeWaiting = secondClassTotalTimeWaiting + secondClass.size();
    }

    /**
     * sets the first arrival
     * @param firstArrival firstborn to be set
     */
    public void setFirstArrival(BooleanSource firstArrival)
    {
        this.firstArrival = firstArrival;
    }

    /**
     * sets the first arrival
     * @param secondArrival secondArrival to be set
     */
    public void setSecondArrival(BooleanSource secondArrival)
    {
        this.secondArrival = secondArrival;
    }

    /**
     * returns the first passenger
     * @return passenger
     */
    public Passenger firstClassPassengerPeek()
    {
        return firstClass.peek();
    }
    /**
     * returns the second passenger
     * @return passenger
     */
    public Passenger secondClassPassengerPeek()
    {
        return secondClass.peek();
    }

    /**
     * removes first class passenger
     * @return passenger
     */
    public Passenger firstClassDeque()
    {
        numberOfFirstClassDeque++;
        return firstClass.dequeue();
    }

    /**
     * removes second class passenger
     * @return passenger
     */
    public Passenger secondClassDeque()
    {
        numberOfSecondClassDeque++;
        return secondClass.dequeue();
    }

    /**
     * returns number of first class left behind
     * @return number of first class left behind
     */
    public int firstClassLeftBehind()
    {
        return firstClass.size();
    }

    /**
     * returns number of second class left behind
     * @return number left behind
     */
    public int secondClassLeftBehind()
    {
        return secondClass.size();
    }

    /**
     * string of station
     * @return string of station
     */
    public String toString()
    {
        return (firstArrival.occurs() ? "First Class passenger arrives\n" : "No first class passenger arrives\n") +
                (secondArrival.occurs() ? "Second class passenger arrives\n" : "No Second class passenger arrives\n")
                + "Queues: \n" + firstClass + "\n" + secondClass + "\n";
    }
}