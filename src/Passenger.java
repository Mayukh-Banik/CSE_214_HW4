// Mayukh Banik 114489797 R03 mayukh.banik@stonybrook.edu
public class Passenger
{
    private int id = 0;
    private int arrivalTime = 0;
    private boolean isFirstClass = false;

    /**
     * returns the id of the passenger
     * @return int ID number of passenger
     */
    public int getId()
    {
        return id;
    }

    /**
     * returns the arrival time of the passenger
     * @return int arrival time
     */
    public int getArrivalTime()
    {
        return arrivalTime;
    }

    /**
     * returns if the passenger is first class
     * @return boolean of first class
     */
    public boolean getIsFirstClass()
{
    return isFirstClass;
}

    /**
     * sets the arrival time of the passenger
     * @param arrivalTime the arrival time to set the passenger
     */
    public void setArrivalTime(int arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    /**
     * sets the value of first class
     * @param firstClass what first class value should be set to
     */
    public void setFirstClass(boolean firstClass)
    {
        isFirstClass = firstClass;
    }

    /**
     * sets the ID number
     * @param id int ID of passenger
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * string representation of passenger
     * @return string representation of passenger
     */
    public String toString()
    {
        return "P" + id;
    }
}