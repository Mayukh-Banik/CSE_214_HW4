// Mayukh Banik 114489797 R03 mayukh.banik@stonybrook.edu
import java.util.*;
public class LIRRSimulator
{
    public static final int[][] numberOfFirstAndSecondClassServed = new int[2][4];
    public static final int[][] numberOfFirstAndSecondClassLeftBehind= new int[2][4];
    public static final int[][] averageWaitTimeFirstAndSecondClass = new int[2][4];
    public static int numberOfFirstClassLeftBehind = 0;
    public static int totalNumberOfPassengersServed = 0;
    public static int numberOfSecondClassLeftBehind = 0;
    public static int firstClassCapacity = 0;
    public static int secondClassCapacity = 0;
    public static int numberOfTrains = 0;
    public static int lastArrivalTimeOfPassengers = 0;
    public static final double[][] arrivalProbability = new double[2][4];
    public static final String[] arrivalProbabilityString = {"First class probability: ", "Second class probability: "};
    public static final Station Mineola = new Station();
    public static final Station Hicksville = new Station();
    public static final Station Syosset = new Station();
    public static final Station Huntington = new Station();
    public static Train[] train;
    public static final Scanner input = new Scanner(System.in);
    public static int idNumber = 1;

    /**
     * takes in inputs and makes sure it is valid
     * @param args default
     */
    public static void main(String[] args)
    {
        System.out.println("Welcome to the LIRR Simulator, Leaving Irate Riders Regularly. ");
        boolean catcher;
        do
        {
            try
            {
                System.out.println("Mineloa: \n" + arrivalProbabilityString[0]);
                arrivalProbability[0][0] = input.nextDouble();
                Mineola.setFirstArrival(new BooleanSource(arrivalProbability[0][0]));
                System.out.println(arrivalProbabilityString[1]);
                arrivalProbability[1][0] = input.nextDouble();
                Mineola.setSecondArrival(new BooleanSource(arrivalProbability[1][0]));
                System.out.println("Hicksville: \n" + arrivalProbabilityString[0]);
                arrivalProbability[0][1] = input.nextDouble();
                Hicksville.setFirstArrival(new BooleanSource(arrivalProbability[0][1]));
                System.out.println(arrivalProbabilityString[1]);
                arrivalProbability[1][1] = input.nextDouble();
                Hicksville.setSecondArrival(new BooleanSource(arrivalProbability[1][1]));
                System.out.println("Syosset: \n" + arrivalProbabilityString[0]);
                arrivalProbability[0][2] = input.nextDouble();
                Syosset.setFirstArrival(new BooleanSource(arrivalProbability[0][2]));
                System.out.println(arrivalProbabilityString[1]);
                arrivalProbability[1][2] = input.nextDouble();
                Syosset.setSecondArrival(new BooleanSource(arrivalProbability[1][2]));
                System.out.println("Huntington: \n" + arrivalProbabilityString[0]);
                arrivalProbability[0][3] = input.nextDouble();
                Huntington.setFirstArrival(new BooleanSource(arrivalProbability[0][3]));
                System.out.println(arrivalProbabilityString[1]);
                arrivalProbability[1][3] = input.nextDouble();
                Huntington.setSecondArrival(new BooleanSource(arrivalProbability[1][3]));
                catcher = false;
            }
            catch (IllegalArgumentException illegalArgumentException)
            {
                System.out.println("One of your inputs was above 1.0 or below 0.0");
                catcher = true;
            }
        }
        while (catcher);
        do
        {
            try
            {
                System.out.println("Enter the First Class Capacity: ");
                firstClassCapacity = input.nextInt();
                System.out.println("Enter the Second Class Capacity: ");
                secondClassCapacity = input.nextInt();
                if (firstClassCapacity < 0 || secondClassCapacity < 0)
                {
                    throw new CustomException();
                }
                catcher = false;
            }
            catch (CustomException exception)
            {
                System.out.println("You inputted a first class or second class capacity below 0.");
            }
        }
        while (catcher);
        do
        {
            System.out.println("Enter the number of trains: ");
            numberOfTrains = input.nextInt();
            train = new Train[numberOfTrains];
            for (int counter = 0; counter < numberOfTrains; counter++)
            {
                train[counter] = new Train();
                train[counter].setTrainNumber(counter);
                train[counter].setFirstCapacity(firstClassCapacity);
                train[counter].setSecondCapacity(secondClassCapacity);
                train[counter].setTimeUntilNextArrival( 5 * counter + 15);
            }
            System.out.println("Please enter last arrival time of passengers: ");
            lastArrivalTimeOfPassengers = input.nextInt();
            try
            {
                if (( 5 * numberOfTrains + 10) < lastArrivalTimeOfPassengers)
                {
                    throw new CustomException();
                }
                if (lastArrivalTimeOfPassengers < 0)
                {
                    throw new CustomException();
                }
                catcher = false;
            }
            catch (CustomException customException)
            {
                System.out.println("There are passengers arriving after the last train leaves the last stop. ");
                catcher = true;
            }
        }
        while (catcher);
        handlesSimulation();
    }

    /**
     * handles the simulation in the class
     */
    public static void handlesSimulation()
    {
        int counter2 = 0;
        System.out.println("Begin Simulation: \n ---------------------------------------------------------------");
        for (int counter = 0; counter <= 5 * numberOfTrains + 10; counter++)
        {
            if (counter2 <= lastArrivalTimeOfPassengers)
            {
                Mineola.simulateTimeStep();
                Hicksville.simulateTimeStep();
                Syosset.simulateTimeStep();
                Huntington.simulateTimeStep();
                counter2++;
            }
            System.out.println("Time " + counter + ":\n\nStation Overview: \n\nMineola: \n" + Mineola
                + "Hicksville: \n" + Hicksville + "Syosset: \n" + Syosset + "Huntington: \n"
                + Huntington);
            for (int counter3 = 0; counter3 < numberOfTrains; counter3++)
            {
                train[counter3].simulateTimeStep();
                System.out.println(train[counter3].toString());
            }
        }
        totalNumberOfPassengersServed = Mineola.numberOfFirstClassDeque + Mineola.numberOfSecondClassDeque +
                Hicksville.numberOfFirstClassDeque + Hicksville.numberOfSecondClassDeque + 
                Syosset.numberOfSecondClassDeque + Syosset.numberOfFirstClassDeque
                + Huntington.numberOfSecondClassDeque + Huntington.numberOfFirstClassDeque;
        numberOfFirstAndSecondClassServed[0][0] = Mineola.numberOfFirstClassDeque;
        numberOfFirstAndSecondClassServed[1][0] = Mineola.numberOfFirstClassDeque;
        numberOfFirstAndSecondClassServed[0][1] = Hicksville.numberOfFirstClassDeque;
        numberOfFirstAndSecondClassServed[1][1] = Hicksville.numberOfFirstClassDeque;
        numberOfFirstAndSecondClassServed[0][2] = Syosset.numberOfFirstClassDeque;
        numberOfFirstAndSecondClassServed[1][2] = Syosset.numberOfFirstClassDeque;
        numberOfFirstAndSecondClassServed[0][3] = Huntington.numberOfFirstClassDeque;
        numberOfFirstAndSecondClassServed[1][3] = Huntington.numberOfFirstClassDeque;
        numberOfFirstAndSecondClassLeftBehind[0][0] = Mineola.firstClassLeftBehind();
        numberOfFirstAndSecondClassLeftBehind[1][0] = Mineola.secondClassLeftBehind();
        numberOfFirstAndSecondClassLeftBehind[0][1] = Hicksville.firstClassLeftBehind();
        numberOfFirstAndSecondClassLeftBehind[1][1] = Hicksville.secondClassLeftBehind();
        numberOfFirstAndSecondClassLeftBehind[0][2] = Syosset.firstClassLeftBehind();
        numberOfFirstAndSecondClassLeftBehind[1][2] = Syosset.secondClassLeftBehind();
        numberOfFirstAndSecondClassLeftBehind[0][3] = Huntington.firstClassLeftBehind();
        numberOfFirstAndSecondClassLeftBehind[1][3] = Huntington.secondClassLeftBehind();
        averageWaitTimeFirstAndSecondClass[0][0] = Mineola.firstClassTotalTimeWaiting /
                Mineola.numberOfFirstClassArrived;
        averageWaitTimeFirstAndSecondClass[1][0] = Mineola.secondClassTotalTimeWaiting /
                Mineola.numberOfSecondClassArrived;
        averageWaitTimeFirstAndSecondClass[0][1] = Hicksville.firstClassTotalTimeWaiting /
                Hicksville.numberOfFirstClassArrived;
        averageWaitTimeFirstAndSecondClass[1][1] = Hicksville.secondClassTotalTimeWaiting /
                Hicksville.numberOfSecondClassArrived;
        averageWaitTimeFirstAndSecondClass[0][2] = Syosset.firstClassTotalTimeWaiting /
                Syosset.numberOfFirstClassArrived;
        averageWaitTimeFirstAndSecondClass[1][2] = Syosset.secondClassTotalTimeWaiting /
                Syosset.numberOfSecondClassArrived;
        averageWaitTimeFirstAndSecondClass[0][3] = Huntington.firstClassTotalTimeWaiting /
                Huntington.numberOfFirstClassArrived;
        averageWaitTimeFirstAndSecondClass[1][3] = Huntington.secondClassTotalTimeWaiting /
                Huntington.numberOfSecondClassArrived;
        for (int counter = 0; counter < 4; counter++)
        {
            numberOfFirstClassLeftBehind += numberOfFirstAndSecondClassLeftBehind[0][counter];
            numberOfSecondClassLeftBehind += numberOfFirstAndSecondClassLeftBehind[1][counter];
        }
        System.out.println("At the end of the simulation:\n" +
                "A total of " + totalNumberOfPassengersServed + " passengers were served, " +
                numberOfFirstClassLeftBehind + " first class passengers were left without a seat, " +
                numberOfSecondClassLeftBehind + " second class passengers were left without a seat.\n" +
                "At Mineola " + numberOfFirstAndSecondClassServed[0][0] + " first class passengers were served " +
                "with an average wait time of " + averageWaitTimeFirstAndSecondClass[0][0] + " min, " +
                numberOfFirstAndSecondClassServed[1][0] + " second class " +
                "passengers were served with an average wait time of " + averageWaitTimeFirstAndSecondClass[1][0] +
                " min. " + numberOfFirstAndSecondClassLeftBehind[0][0] + " first class passengers and " +
                numberOfFirstAndSecondClassLeftBehind[1][0] + " second class passengers were left without a seat.\n" +
                "At Hicksville " + numberOfFirstAndSecondClassServed[0][1] + " first class passengers were served " +
                "with an average wait time of " + averageWaitTimeFirstAndSecondClass[0][1] + " min, " +
                numberOfFirstAndSecondClassServed[1][1] + " second class passengers were served with an average wait " +
                "time of " + averageWaitTimeFirstAndSecondClass[1][1] + " min. " +
                numberOfFirstAndSecondClassLeftBehind[0][1] + " first class passengers and " +
                numberOfFirstAndSecondClassLeftBehind[1][1] + " second class passengers were left without a seat.\n" +
                "At Syosset " + numberOfFirstAndSecondClassServed[0][2] + " first class passengers were served " +
                "with an average wait time of " + averageWaitTimeFirstAndSecondClass[0][2] + " min, " +
                numberOfFirstAndSecondClassServed[1][2] + " second class passengers were served with an average wait " +
                "time of " + averageWaitTimeFirstAndSecondClass[1][2] + " min. " +
                numberOfFirstAndSecondClassLeftBehind[0][2] + " first class passengers and " +
                numberOfFirstAndSecondClassLeftBehind[1][2] + " second class passengers were left without a seat.\n" +
                "At Huntington " + numberOfFirstAndSecondClassServed[0][3] + " first class passengers were served " +
                "with an average wait time of " + averageWaitTimeFirstAndSecondClass[0][3] + " min, " +
                numberOfFirstAndSecondClassServed[1][3] + " second class passengers were served with an average wait " +
                "time of " + averageWaitTimeFirstAndSecondClass[1][3] + " min. " +
                numberOfFirstAndSecondClassLeftBehind[0][3] + " first class passengers and " +
                numberOfFirstAndSecondClassLeftBehind[1][3] + " second class passengers were left without a seat.");
    }
}