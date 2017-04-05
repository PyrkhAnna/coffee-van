package com.epam.coffee_van.parser;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.epam.coffee_van.runner.DOMCoffeeVanReader;
import com.epam.coffee_van.runner.ExternalData;
import com.epam.coffee_van.util.Configuration;

public class VanDOMParserTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		ExternalData data=null;
			
		DOMCoffeeVanReader readData = new DOMCoffeeVanReader();
		try {
			data = readData.readCoffeeVanData(Configuration.getKey("path.read"));
		} catch (IOException e) {
			//Log.debug(e);
		}
		assertNull(data);
		
	}

}
