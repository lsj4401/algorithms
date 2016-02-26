package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MainTest {
	public PIexample p;
	public Main pi;

	@Before
	public void setUp() {
		this.p = new PIexample();
		this.pi = new Main();
	}
	
	// --------------------------------------
	// 각 블록 크기에 맞는 합 - 로직의 기본이 되는 뼈대 구현
	// --------------------------------------	
	@Test
	@Ignore
	public void test() {
//		Integer[] arr = {4,5,6,7,8,9,10,11,12,13};
//		assertEquals(arr, p.copyOfRangeTest());
		
//		int[] result = p.copyOfRangeTest();
//		
//		for (int i = 0; i < result.length ; i++) {
//			System.out.print(result[i] + " ");
//		}
		
		int[] arr = {1,2,3,4,5,6,7, 8, 9, 10};
		System.out.println(p.getMinGrade(arr));
	}

	
	// --------------------------------------
	// pattern test 
	// --------------------------------------	
	@Test
	@Ignore
	public void patternTestCase1() {
		System.out.println("patternTestCase1");
		int expected = 1;
		
		int[] arr = {1,1,1,1,1};
		assertEquals(expected, p.patternTest(arr));
		
		int[] arr1 = {1,1,1,1,2};
		assertNotEquals(expected, p.patternTest(arr1));
		System.out.println();
	}
	
	@Test
	@Ignore
	public void patternTestCase2() {
		System.out.println("patternTestCase2");
		int expected = 2;
				
		int[] arr = {1,2,3,4,5};
		assertEquals(expected, p.patternTest(arr));

		int[] arr2 = {6,5,4,3,2};
		assertEquals(expected, p.patternTest(arr2));
		
		int[] arr3 = {1,2,3,4,6};
		assertNotEquals(expected, p.patternTest(arr3));
		System.out.println();
	}
	
	@Test
	@Ignore
	public void patternTestCase3() {
		System.out.println("patternTestCase3");
		int expected = 3;
		
		int[] arr = {3,1,3,1,3};
		assertEquals(expected, p.patternTest(arr));
		
		int[] arr1 = {3,4,3,4};
		assertEquals(expected, p.patternTest(arr1));
		
		int[] arr2 = {8,6,8};
		assertEquals(expected, p.patternTest(arr2));
		
		int[] arr3 = {1,1,1,1,2};
		assertNotEquals(expected, p.patternTest(arr3));
		System.out.println();
	}
	
	@Test
	@Ignore
	public void patternTestCase4() {
		System.out.println("patternTestCase4");
		int expected = 4;
		
		int[] arr = {1,3,5,7,9};
		assertEquals(expected, p.patternTest(arr));
		
		int[] arr1 = {8,6,4,2,0};
		assertEquals(expected, p.patternTest(arr1));
		
		int[] arr2 = {8,6,4,2,1};
		assertNotEquals(expected, p.patternTest(arr2));
		System.out.println();
	}
	
	
	// --------------------------------------
	// grade() test 
	// --------------------------------------	
	
	@Test
	@Ignore
	public void gradeTest1() {
		System.out.println("patternTestCase1");
		int expected = 1;
		
		int[] arr = {1,1,1,1,1};
		assertEquals(expected, p.grade(arr));
		
		int[] arr1 = {1,1,1,1,2};
		assertNotEquals(expected, p.grade(arr1));
		System.out.println();
	}
	
	
	@Test
	@Ignore
	public void gradeTest2() {
		System.out.println("patternTestCase2");
		int expected = 2;
				
		int[] arr = {1,2,3,4,5};
		assertEquals(expected, p.grade(arr));

		int[] arr2 = {6,5,4,3,2};
		assertEquals(expected, p.grade(arr2));
		
		int[] arr3 = {1,2,3,4,6};
		assertNotEquals(expected, p.grade(arr3));
		System.out.println();
	}
	
	@Test
	@Ignore
	public void gradeTest3() {
		System.out.println("patternTestCase3");
		int expected = 4;
		
		int[] arr = {3,1,3,1,3};
		assertEquals(expected, p.grade(arr));
		
		int[] arr1 = {3,4,3,4};
		assertEquals(expected, p.grade(arr1));
		
		int[] arr2 = {8,6,8};
		assertEquals(expected, p.grade(arr2));
		
		int[] arr3 = {1,1,1,1,2};
		assertNotEquals(expected, p.grade(arr3));
		System.out.println();
	}
	
	@Test
	@Ignore
	public void gradeTest4() {
		System.out.println("patternTestCase4");
		int expected = 5;
		
		int[] arr = {1,3,5,7,9};
		assertEquals(expected, p.grade(arr));
		
		int[] arr1 = {8,6,4,2,0};
		assertEquals(expected, p.grade(arr1));
		
		int[] arr2 = {8,6,4,2,1};
		assertNotEquals(expected, p.grade(arr2));
		System.out.println();
	}
	
	// --------------------------------------
	// getGrade test 
	// --------------------------------------	
	@Test
	@Ignore
	public void getGrageTest1() {
		System.out.println("getGrageTest1");
		int expected = 1;
		
		int[] arr = {1,1,1,1,1};
		assertEquals(expected, p.getGrade(arr));
		
		int[] arr1 = {1,1,1,1,2};
		assertNotEquals(expected, p.getGrade(arr1));
		System.out.println();
	}
	
	@Test
	@Ignore
	public void getGrageTest2() {
		System.out.println("getGrageTest2");
		int expected = 2;
				
		int[] arr = {1,2,3,4,5};
		assertEquals(expected, p.getGrade(arr));

		int[] arr2 = {6,5,4,3,2};
		assertEquals(expected, p.getGrade(arr2));
		
		int[] arr3 = {1,2,3,4,6};
		assertNotEquals(expected, p.getGrade(arr3));
		System.out.println();
	}
	
	@Test
	@Ignore
	public void getGrageTest3() {
		System.out.println("getGrageTest3");
		int expected = 4;
		
		int[] arr = {3,1,3,1,3};
		assertEquals(expected, p.getGrade(arr));
		
		int[] arr1 = {3,4,3,4};
		assertEquals(expected, p.getGrade(arr1));
		
		int[] arr2 = {8,6,8};
		assertEquals(expected, p.getGrade(arr2));
		
		int[] arr3 = {1,1,1,1,2};
		assertNotEquals(expected, p.getGrade(arr3));
		System.out.println();
	}
	
	@Test
	@Ignore
	public void getGrageTest4() {
		System.out.println("getGrageTest4");
		int expected = 5;
		
		int[] arr = {1,3,5,7,9};
		assertEquals(expected, p.getGrade(arr));
		
		int[] arr1 = {8,6,4,2,0};
		assertEquals(expected, p.getGrade(arr1));
		
		int[] arr2 = {8,6,4,2,1};
		assertNotEquals(expected, p.getGrade(arr2));
		System.out.println();
	}
	
	@Test
	@Ignore
	public void getGradeTest5() {
		System.out.println("getGradeTest5");
		int expected = 10;
		
		int[] arr = {4,1,2,3,4};
		assertEquals(expected, p.getGrade(arr));
		System.out.println();
	}
	
	// --------------------------------------
	// final test 
	// -------------------------------------
	@SuppressWarnings("static-access")
	@Test
	public void finalTest() {
		String testCase1 = "12341234";
		assertEquals(4, pi.init(testCase1));
		
		String testCase2 = "11111222";
		assertEquals(2, pi.init(testCase2));
		
		String testCase3 = "12122222";
		assertEquals(5, pi.init(testCase3));
		
		String testCase4 = "22222222";
		assertEquals(2, pi.init(testCase4));
		
		String testCase5 = "12673939";
		assertEquals(14, pi.init(testCase5));
	}

}
