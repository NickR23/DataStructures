package edu.ncsu.csc316.dsa.list;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
/**
 * ArrayBasedList test cases.
 * @author nicholasrrichardson
 * @param <E> - Generic element class.
 *
 */
public class ArrayBasedListTest<E> {
	
	private Student[] expected;
	private ArrayBasedList<Student> actual;
/**
 * Setup.
 * @throws Exception - For stuff.
 */
	@Before
	public void setUp() throws Exception {
		expected = new Student[11];
		actual = new ArrayBasedList<Student>(12);
		for(int i = 0; i < 10; i++)
		{
			expected[i] = new Student("Nick", "Rich", i + 1);
			actual.add(i, new Student("Nick", "Rich", i + 1));
		}
		expected[10] = new Student("Nick", "Rich", 2624);
	}
	/**
	 * Tests the no-arg constructor.
	 * $$ Check sizes after implementing add methods.
	 */
	@Test
	public void testArrayBasedList() {
		ArrayBasedList<Student> test = new ArrayBasedList<Student>();
		Assert.assertEquals(0, test.size());
	}
	
	/**
	 * Tests the default constructor.
	 * $$ Check sizes after implementing add methods.
	 */
	@Test
	public void testArrayBasedListInt() {
		ArrayBasedList<Student> test = new ArrayBasedList<Student>(20);
		Assert.assertEquals(0, test.size());
	}
	
	/**
	 * Test iterator for ArrayBasedList.
	 */
	@Test
	public void testIterator()
	{
		ArrayBasedList<String> test = new ArrayBasedList<String>();
		test.addLast("HEY");
		test.addLast("YOU");
		test.addLast("WHAT");
		String[] expect = {"HEY" , "YOU" , "WHAT"};
		Iterator<String> iter = test.iterator();
		int i = 0;
		while(iter.hasNext())
		{
			String result = iter.next();
			Assert.assertEquals(expect[i], result);
			i++;
		}
		
		iter = test.iterator();
		iter.remove();
		Assert.assertEquals("HEY", test.first());
		iter.next();
		iter.remove();
		Assert.assertEquals("YOU", test.first());
		iter.next();
		iter.remove();
		Assert.assertEquals("WHAT", test.first());

	}
	
	/**
	 * Tests add().
	 */
	@Test
	public void testAdd() {
		
		/**
		 * Test linear additions.
		 */
		ArrayBasedList<Student> test = new ArrayBasedList<Student>(20);
		Assert.assertEquals(0, test.size());
		for(int i = 0; i < 10; i++)
		{
			test.add(i, new Student("Nick", "Rich", 1 + i));
		}
		for(int i = 0; i < 10; i++)
		{
			if (test.get(i) == null)
			{
				fail("test[" + i + "] is null... :(" );
			}
			Assert.assertEquals(expected[i], test.get(i));
		}
		
		/**
		 * Test full array.
		 */
		ArrayBasedList<Student> test2 = new ArrayBasedList<Student>();
		for(int i = 0; i < 20; i++)
		{
			test2.add(i, new Student("Nick", "Rich", 1 + i));
		}
		Assert.assertEquals(true, test2.size() > 10);
		
		/**
		 * Test indexOutOfBoundsException thrown.
		 */
		try {
			test2.add(100, new Student("Nick", "Rich", 9789));
		}
		catch(IndexOutOfBoundsException e)
		{
			Assert.assertTrue(true);
		}


	}
	/**
	 * Tests addFirst().
	 */
	@Test
	public void testAddFirst() {
		ArrayBasedList<Student> test = new ArrayBasedList<Student>(20);
		for(int i = 0; i < 10; i++)
		{
			test.add(i, new Student("Nick", "Rich", 1 + i));
		}
		Student testStudent = new Student("Nick", "Rich", 9898);
		test.addFirst(testStudent);
		Assert.assertEquals(testStudent, test.get(0));
		Assert.assertEquals(expected[0], test.get(1));
	}

	/**
	 * Tests addLast().
	 */
	@Test
	public void testAddlast() {
		actual.addLast(expected[10]);
		for(int i = 0; i < 10; i++)
		{
			if (actual.get(i) == null)
			{
				fail("test[" + i + "] is null... :(" );
			}
			Assert.assertEquals(expected[i], actual.get(i));
		}
	}
	/**
	 * Tests the first() method.
	 */
	@Test
	public void testFirst() {
		ArrayBasedList<Student> test = new ArrayBasedList<Student>();
		Student s = new Student("Nick", "Rich", 45);
		test.add(0, s);
		Assert.assertEquals(s, test.first());
	}

	/**
	 * Tests get().
	 */
	@Test
	public void testGet() {
		ArrayBasedList<Student> test = new ArrayBasedList<Student>();
		Student s = new Student("Nick", "Rich", 45);
		Student s2 = new Student("Nick", "Rich", 48);
		test.add(0, s);
		test.add(0, s2);
		Assert.assertEquals(s2, test.get(0));
		
		try {
			test.get(-1);
		}
		catch(IndexOutOfBoundsException e)
		{
			Assert.assertTrue(true);
		}
		}
/**
 * Tests testIsEmpty()
 */
	@Test
	public void testIsEmpty() {
		ArrayBasedList<String> test = new ArrayBasedList<String>();
		Assert.assertEquals(true, test.isEmpty());
		test.addFirst("HEY");
		Assert.assertEquals(false, test.isEmpty());

	}

/**
 * Tests last().
 */
	@Test
	public void testLast() {
		ArrayBasedList<String> test = new ArrayBasedList<String>();
		test.addFirst("HEY");
		test.addFirst("YOU");
		test.addFirst("WHAT");
		Assert.assertEquals("HEY", test.last());
	}

	/**
	 * Tests remove().
	 */
	@Test
	public void testRemove() {
		ArrayBasedList<String> test = new ArrayBasedList<String>();
		test.addFirst("HEY");
		test.addFirst("YOU");
		test.addFirst("WHAT");
		test.remove(2);
		Assert.assertEquals("YOU", test.last());	
		}

	/**
	 * Tests removeFirst().
	 */
	@Test
	public void testRemoveFirst() {
		ArrayBasedList<String> test = new ArrayBasedList<String>();
		test.addFirst("HEY");
		test.addFirst("YOU");
		test.addFirst("WHAT");
		test.removeFirst();
		Assert.assertEquals("YOU", test.first());	
		}

	/**
	 * Tests removeLast().
	 */
	@Test
	public void testRemoveLast() {
		ArrayBasedList<String> test = new ArrayBasedList<String>();
		test.addFirst("HEY");
		test.addFirst("YOU");
		test.addFirst("WHAT");
		test.removeLast();
		Assert.assertEquals("YOU", test.last());	
		}
	/**
	 * Tests set().
	 */
	@Test
	public void testSet() {
		ArrayBasedList<String> test = new ArrayBasedList<String>();
		test.addFirst("HEY");
		test.addFirst("YOU");
		test.addFirst("WHAT");
		test.set(0, "example");
		Assert.assertEquals("example", test.first());	
	}

	/**
	 * Tests size().
	 */
	@Test
	public void testSize() {
		ArrayBasedList<String> test = new ArrayBasedList<String>();
		test.addFirst("HEY");
		test.addFirst("YOU");
		test.addFirst("WHAT");
		Assert.assertEquals(3, test.size());	
	}

}
