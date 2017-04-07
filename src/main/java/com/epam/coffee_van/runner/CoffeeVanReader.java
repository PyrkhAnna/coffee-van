package com.epam.coffee_van.runner;

import java.io.IOException;

public interface CoffeeVanReader {
	public ExternalData readCoffeeVanData(String path) throws IOException;
}
