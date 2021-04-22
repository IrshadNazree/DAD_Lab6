import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;

import ftmk.rmi.sensor.TemperatureSensor;

public class TemperatureClientAyerKeroh {
	public static void main(String[] args) {
		try {
			Registry rmiRegistry = LocateRegistry.getRegistry();
			TemperatureSensor remoteSensorAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");
			int currentTemperature = remoteSensorAyerKeroh.getTemperature();
			HashMap<String, Integer> dailyTemps = remoteSensorAyerKeroh.getSpecifiedDay();
			
			System.out.println("Current temperature in Ayer Keroh is " + currentTemperature + " Celcius");
			dailyTemps.forEach((key, value) -> {
				  value = value - value * 10/100;
				  System.out.println(key + " temperature for Ayer Keroh is " + value + " Celcius");
				});
			
			float avgTemp = remoteSensorAyerKeroh.getAvgTemp();
			System.out.println("Average temperature for Ayer Keroh is " + avgTemp + " Celcius");
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
