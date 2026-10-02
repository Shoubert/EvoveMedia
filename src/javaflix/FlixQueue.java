
public class FlixQueue emplements cloneable
{
	private int count;
	private MAX_QUEUE = 3;
	private Movie[MAX_QUEUE];
	
	/**
	 * Static constant MAX_QUEUE = 3
	 * amount of movie a customer allow to rent
	 */
    public static  int MAX_QUEUE = 3;
   
    Movie = new Movie[MAX_QUEUE];
	Queue = new FlixQueue;
 /**
 *default constructor Number of movie set to 3
 */
   public FlixQueue()
	{
     	movie = null;
        counter = -1;
	}

	/**
	 * parameterize construtor capable of storing the proper amount of movie
	 */
	public FlixQUEUE(MovieItem)
       {
   	if( m.length == MAX_QUEUE ){
   		movie = m;
		{
			else
		}
	System.exit(1);
	}

	/*
	 * Mutator Methods
	 */
	 public Movie Rent()
	 {
      for (int i=0; i < movie.length; i++ )
		 {
		 if (movie[i].isAvailable() && count != i ){
		 		movie[i].setAvailable(false);
		 		counter = i
		 		return movie[i]; 
		 }	 		
	 }
	 return null;
		 }
	
	 public boolean isEmpty()
	 {
	 if(( ! movie[i].isAvailable() && count !=i)
	 
	 }
	 
	public int compareTo(Object in)
	{
		if(in instanceof Movie)
	{
	Movie m = (Movie)in;
        if((m.getTitle() == this.getTitle() ) && (m.Year() == this.getYear()))
	{
	return 0;
	}
	else
	{
	return -1;
	}

	}
   }

   /**
    * Overiding Methods
    */
    public boolean equals(Object in)
    {
	if(in instanceof Movie || in instanceof Concert)
	{

	FlixQueue = (FlixQueue) in;
	return getTitle().equals(FlixQueue.getTitle() ) && getYear() == FlixQueue.getYear();
    }
        else
 	{
	return false;
        }
   }
}
