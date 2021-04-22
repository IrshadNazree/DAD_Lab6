package ftmk.rmi.sensor.manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class manage the value of temperature from the sensor.
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {
	private HashMap<String, Integer> specifiedDays;
	private	int count = 0;
	private int total = 0;
	private float avg = 0;
	
	public TemperatureSensorManager() throws RemoteException {
		super();
	}

	@Override
	public int getTemperature() throws RemoteException  {
		
		return 35;
	}
	
	public HashMap<String, Integer> getSpecifiedDay(){
		specifiedDays = new HashMap<String, Integer>();
		
		specifiedDays.put("Monday", 32);
		specifiedDays.put("Tuesday", 31);
		specifiedDays.put("Wednesday", 33);
		specifiedDays.put("Thursday", 35);
		specifiedDays.put("Friday", 36);
		specifiedDays.put("Saturday", 33);
		specifiedDays.put("Sunday", 33);
		
		return specifiedDays;
	}

	public float getAvgTemp(){
		specifiedDays.forEach((key, value) -> {
			  total += value;
			  count++;
			});
		avg = total / count;
		return avg;
	}
}



