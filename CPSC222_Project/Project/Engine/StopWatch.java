package Engine;

public class StopWatch{

private double timeElapsed;
private long startTime;
private long endTime;

	public StopWatch(){
	//Initializes all member variables
	//to a "stopped" state.
	timeElapsed=0;
	startTime=0;
	endTime=0;

}
		
	public double elapsed(){
		//Depending on the state of the stopwatch
		//will return the time elapsed.
	if(endTime>0){

		timeElapsed=endTime-startTime;
	
	}
	else if(startTime==0){

		timeElapsed=0;
	
	}
	else {
		timeElapsed=System.nanoTime()-startTime;
	
	}
	return timeElapsed;
			

}

	public StopWatch start(){//Starts stopwatch
	startTime=System.nanoTime();
	return this;
	
	
	}

	public StopWatch stop(){//Stops the stopwatch
	endTime=System.nanoTime();
	
	return this;
	
	}
	public StopWatch reset(){//Resets the stopwatch
	startTime=0;
	endTime=0;
	timeElapsed=0;
	return this;
	
	}

}
