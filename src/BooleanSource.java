// Mayukh Banik 114489797 R03 mayukh.banik@stonybrook.edu
public class BooleanSource
{
    private final double probability;

    /**
     * sets the probability of this class
     * @param probability the probability to be set to
     * @throws IllegalArgumentException in case its above 1 or below 0
     */
    public BooleanSource(double probability) throws IllegalArgumentException
    {
        if (probability < 0.0 || probability > 1.0)
        {
            throw new IllegalArgumentException();
        }
        this.probability = probability;
    }

    /**
     * checks whether the event happens
     * @return true/false of whether it happens
     */
    public boolean occurs()
    {
        return (Math.random() < probability);
    }
}