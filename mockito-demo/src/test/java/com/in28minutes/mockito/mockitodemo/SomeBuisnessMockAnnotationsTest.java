package com.in28minutes.mockito.mockitodemo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class SomeBuisnessMockAnnotationsTest {

	@Test
	public void TestFindGreatestFromAllData() {
		DataService dataServiceMock = mock(DataService.class);
		// dataServiceMock.retrieveAllData() => new int[] {24,15,3};
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findGreatestFromAllData();
		assertEquals(24, result);
	}

	@Test
	public void TestFindGreatestFromAllDataForOneValue() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 15 });
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findGreatestFromAllData();
		assertEquals(15, result);
	}

}
