package barracksWars.core;

import barracksWars.interfaces.*;
import barracksWars.interfaces.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private final Repository repository;
	private final UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpretCommand(String[] data, String commandName) {

		commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
		try {
			Class<?> clazz = Class.forName("barracksWars.core.commands." + commandName);
			Constructor<?> constructor = clazz.getConstructor(String[].class, Repository.class, UnitFactory.class);
			Executable executable = (Executable) constructor.newInstance(data, this.repository, this.unitFactory);
			return executable.execute();

		} catch (ClassNotFoundException
				| NoSuchMethodException
				| InstantiationException
				| IllegalAccessException
				| InvocationTargetException e) {
			throw new IllegalStateException(e);
		}
	}
}




	

