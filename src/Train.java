// Mayukh Banik 114489797 R03 mayukh.banik@stonybrook.edu
public class Train
{
    private int firstCapacity;
    private int secondCapacity;
    private int timeUntilNextArrival;
    public PassengerQueue firstClassOnTrain;
    public PassengerQueue secondClassOnTrain;
    private PassengerQueue firstClassEmbarkingOnTrain;
    private PassengerQueue secondClassEmbarkingOnTrain;
    private Passenger tempPassenger;
    private int trainNumber;

    /**
     * sets default value for every data field
     */
    public Train()
    {
        firstCapacity = 0;
        secondCapacity = 0;
        timeUntilNextArrival = 0;
        firstClassOnTrain = new PassengerQueue();
        secondClassOnTrain = new PassengerQueue();
        firstClassEmbarkingOnTrain = new PassengerQueue();
        secondClassEmbarkingOnTrain = new PassengerQueue();
        tempPassenger = new Passenger();
    }

    /**
     * simulates a timestamp depending on where the train is
     */
    public void simulateTimeStep()
    {
        if (timeUntilNextArrival == 15)
        {
            do
            {
                if (LIRRSimulator.Huntington.firstClassSize() != 0 && firstClassOnTrain.size() < firstCapacity)
                {
                    tempPassenger = LIRRSimulator.Huntington.firstClassDeque();
                    firstClassOnTrain.enqueue(tempPassenger);
                    firstClassEmbarkingOnTrain.enqueue(tempPassenger);
                }
                if (firstClassOnTrain.size() > firstCapacity && LIRRSimulator.Huntington.firstClassSize() != 0)
                {
                    tempPassenger = LIRRSimulator.Huntington.firstClassDeque();
                    secondClassOnTrain.enqueue(tempPassenger);
                    firstClassEmbarkingOnTrain.enqueue(tempPassenger);
                }
                if (LIRRSimulator.Huntington.secondClassSize() != 0 && secondClassOnTrain.size() < secondCapacity)
                {
                    tempPassenger = LIRRSimulator.Huntington.secondClassDeque();
                    secondClassOnTrain.enqueue(tempPassenger);
                    secondClassEmbarkingOnTrain.enqueue(tempPassenger);
                }
            }
            while (LIRRSimulator.Huntington.firstClassSize() != 0 && LIRRSimulator.Huntington.secondClassSize() != 0
                    && firstClassOnTrain.size() != firstCapacity && secondClassOnTrain.size() != secondCapacity);
        }
        if (timeUntilNextArrival == 10)
        {
            do
            {
                if (LIRRSimulator.Syosset.firstClassSize() != 0 && firstClassOnTrain.size() < firstCapacity)
                {
                    tempPassenger = LIRRSimulator.Syosset.firstClassDeque();
                    firstClassOnTrain.enqueue(tempPassenger);
                    firstClassEmbarkingOnTrain.enqueue(tempPassenger);
                }
                if (firstClassOnTrain.size() > firstCapacity && LIRRSimulator.Syosset.firstClassSize() != 0)
                {
                    tempPassenger = LIRRSimulator.Syosset.firstClassDeque();
                    secondClassOnTrain.enqueue(tempPassenger);
                    firstClassEmbarkingOnTrain.enqueue(tempPassenger);
                }
                if (LIRRSimulator.Syosset.secondClassSize() != 0 && secondClassOnTrain.size() < secondCapacity)
                {
                    tempPassenger = LIRRSimulator.Syosset.secondClassDeque();
                    secondClassOnTrain.enqueue(tempPassenger);
                    secondClassEmbarkingOnTrain.enqueue(tempPassenger);
                }
            }
            while (LIRRSimulator.Syosset.firstClassSize() != 0 && LIRRSimulator.Syosset.secondClassSize() != 0
                    && firstClassOnTrain.size() != firstCapacity && secondClassOnTrain.size() != secondCapacity);
        }
        if (timeUntilNextArrival == 5)
        {
            do
            {
                if (LIRRSimulator.Hicksville.firstClassSize() != 0 && firstClassOnTrain.size() < firstCapacity)
                {
                    tempPassenger = LIRRSimulator.Hicksville.firstClassDeque();
                    firstClassOnTrain.enqueue(tempPassenger);
                    firstClassEmbarkingOnTrain.enqueue(tempPassenger);
                }
                if (firstClassOnTrain.size() > firstCapacity && LIRRSimulator.Hicksville.firstClassSize() != 0)
                {
                    tempPassenger = LIRRSimulator.Hicksville.firstClassDeque();
                    secondClassOnTrain.enqueue(tempPassenger);
                    firstClassEmbarkingOnTrain.enqueue(tempPassenger);
                }
                if (LIRRSimulator.Hicksville.secondClassSize() != 0 && secondClassOnTrain.size() < secondCapacity)
                {
                    tempPassenger = LIRRSimulator.Hicksville.secondClassDeque();
                    secondClassOnTrain.enqueue(tempPassenger);
                    secondClassEmbarkingOnTrain.enqueue(tempPassenger);
                }
            }
            while (LIRRSimulator.Hicksville.firstClassSize() != 0 && LIRRSimulator.Hicksville.secondClassSize() != 0
                    && firstClassOnTrain.size() != firstCapacity && secondClassOnTrain.size() != secondCapacity);
        }
        if (timeUntilNextArrival == 0)
        {
            do
            {
                if (LIRRSimulator.Mineola.firstClassSize() != 0 && firstClassOnTrain.size() < firstCapacity)
                {
                    tempPassenger = LIRRSimulator.Mineola.firstClassDeque();
                    firstClassOnTrain.enqueue(tempPassenger);
                    firstClassEmbarkingOnTrain.enqueue(tempPassenger);
                }
                if (firstClassOnTrain.size() > firstCapacity && LIRRSimulator.Mineola.firstClassSize() != 0)
                {
                    tempPassenger = LIRRSimulator.Mineola.firstClassDeque();
                    secondClassOnTrain.enqueue(tempPassenger);
                    firstClassEmbarkingOnTrain.enqueue(tempPassenger);
                }
                if (LIRRSimulator.Mineola.secondClassSize() != 0 && secondClassOnTrain.size() < secondCapacity)
                {
                    tempPassenger = LIRRSimulator.Mineola.secondClassDeque();
                    secondClassOnTrain.enqueue(tempPassenger);
                    secondClassEmbarkingOnTrain.enqueue(tempPassenger);
                }
            }
            while (LIRRSimulator.Mineola.firstClassSize() != 0 && LIRRSimulator.Mineola.secondClassSize() != 0
                    && firstClassOnTrain.size() != firstCapacity && secondClassOnTrain.size() != secondCapacity);
        }
        timeUntilNextArrival--;
    }

    /**
     * sets the capacity of the first class of the train
     * @param firstCapacity the capacity of first class
     */
    public void setFirstCapacity(int firstCapacity)
    {
        this.firstCapacity = firstCapacity;
    }

    /**
     * sets capacity of second class
     * @param secondCapacity second class capacity
     */
    public void setSecondCapacity(int secondCapacity)
    {
        this.secondCapacity = secondCapacity;
    }

    /**
     * sets the time until the next arrival
     * @param timeUntilNextArrival time until next arrival
     */
    public void setTimeUntilNextArrival(int timeUntilNextArrival)
    {
        this.timeUntilNextArrival = timeUntilNextArrival;
    }

    /**
     * sets the number of the train
     * @param trainNumber the train number
     */
    public void setTrainNumber(int trainNumber)
    {
        this.trainNumber = trainNumber;
    }

    /**
     * string representation of the train
     * @return string
     */
    public String toString()
    {
        String string;
        if (timeUntilNextArrival > 15)
        {
            string = "Train " + trainNumber + " will arrive at Huntington in " + Math.abs(10 - timeUntilNextArrival)
                    + " minutes\n";
        }
        else if (timeUntilNextArrival < 15 && timeUntilNextArrival > 10)
        {
            string = "Train " + trainNumber + " will arrive at Syosset in " + Math.abs(10 - timeUntilNextArrival) +
                    " minutes\n";
        }
        else if (timeUntilNextArrival < 10 && timeUntilNextArrival > 5)
        {
            string = "Train " + trainNumber + " will arrive at Hicksville in " + Math.abs(5 - timeUntilNextArrival) +
                    " minutes\n";
        }
        else if (timeUntilNextArrival < 5 && timeUntilNextArrival > 0)
        {
            string = "Train " + trainNumber + " will arrive at Mineola in " + timeUntilNextArrival + " minutes\n";
        }
        else if (timeUntilNextArrival == 15)
        {
            string = "Train " + trainNumber + " arrives at Huntington, There are " + firstClassOnTrain.size()
                    + " in first class and " + secondClassOnTrain.size() + " in second class.\nPassengers embarking " +
                    "on first class: " + firstClassEmbarkingOnTrain + "\nPassengers embarking in second class: "
                    + secondClassEmbarkingOnTrain + "\n";
        }
        else if (timeUntilNextArrival == 10)
        {
            string = "Train " + trainNumber + " arrives at Syosset, There are " + firstClassOnTrain.size()
                    + " in first class and " + secondClassOnTrain.size() + " in second class.\nPassengers embarking " +
                    "on first class: " + firstClassEmbarkingOnTrain + "\nPassengers embarking in second class: "
                    + secondClassEmbarkingOnTrain + "\n";
        }
        else if (timeUntilNextArrival == 5)
        {
            string = "Train " + trainNumber + " arrives at Hicksville, There are " + firstClassOnTrain.size()
                    + " in first class and " + secondClassOnTrain.size() + " in second class.\nPassengers embarking " +
                    "on first class: " + firstClassEmbarkingOnTrain + "\nPassengers embarking in second class: "
                    + secondClassEmbarkingOnTrain + "\n";
        }
        else if (timeUntilNextArrival == 0)
        {
            string = "Train " + trainNumber + " arrives at Mineola, There are " + firstClassOnTrain.size()
                    + " in first class and " + secondClassOnTrain.size() + " in second class.\nPassengers embarking " +
                    "on first class: " + firstClassEmbarkingOnTrain + "\nPassengers embarking in second class: "
                    + secondClassEmbarkingOnTrain + "\n";
        }
        else
        {
            string = "Train " + trainNumber + " has stopped picking up passengers, There are " +
                    firstClassOnTrain.size() + " in first class, " + secondClassOnTrain.size() + " in second class.\n";
        }
        return string;
    }
}