package it.unical.studenti.ProvaIngSw;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyListUtilTest {

	private MyListUtil myList;
	private DateTime date = new DateTime();
	
	@Before
	public void initTest() {
		myList = new MyListUtil();
	}
	
	@Before
	@After
	public void print() {
		System.out.println(date.toString());
	}
	
	@Test (expected = NullPointerException.class)
	public void nullTest() {
		System.out.println("Testing the null test");
		myList.sort(null, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void illegalTest() {
		System.out.println("Testing the Illegal test");
		myList.sort(new ArrayList<Integer>(Arrays.asList(10,5,-1,7)), 7);
	}
	
	@Test
	public void sortTest(){
		System.out.println("Testing the sorting test");
		List<Integer> tAsc = myList.sort(new ArrayList<Integer>(Arrays.asList(2,-1,19,5,-24,36)), 0);
		List<Integer> tDesc = myList.sort(new ArrayList<Integer>(Arrays.asList(2,-1,19,5,-24,36)), 1);
		
		List<Integer> orderedAsc = new ArrayList<Integer>(Arrays.asList(-24,-1,2,5,19,36));
		assertArrayEquals(orderedAsc.toArray(), tAsc.toArray());
		
		for(int i =0; i < tAsc.size(); ++i) {
			assertEquals(tAsc.get(i), orderedAsc.get(i));
		}
		
		List<Integer> orderedDesc = new ArrayList<Integer>(Arrays.asList(36,19,5,2,-1,-24));
		assertArrayEquals(orderedDesc.toArray(), tDesc.toArray());
		
		for(int i =0; i < tDesc.size(); ++i) {
			assertEquals(tDesc.get(i), orderedDesc.get(i));
		}
		
		}
	
}
