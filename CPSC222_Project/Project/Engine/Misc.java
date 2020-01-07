package Engine;

public class Misc{
	
	public static StopWatch sw1;



	public static void start(){
		sw1= new StopWatch();
		sw1.start();



	}
	public static double elapsed(){


		return sw1.elapsed();

	}
}