package org.optaplanner.examples.driverallot.app;

public class MyTimeUtil {
	public static int min2format(int timeInMin){
		//80 minutes => 120
		int timeHr = timeInMin/60;				//1
		int timeMin = timeInMin - timeHr*60;	//20
		return 100*timeHr + timeMin;			//120
	}
	
	public static int format2Min(int formatedTime){
		//120 => 80 minutes
		int timeHr = formatedTime/100;				//1
		int timeMin = formatedTime - timeHr*100;	//20
		return 60*timeHr + timeMin;					//80
	}
}
