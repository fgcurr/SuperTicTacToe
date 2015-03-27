import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import boardElements.Quadrant;

public class QuadrantTest {
	
	public Quadrant q;
	
	@Before
	public void setUp() {
		q = new Quadrant();
		q.active = true;
		q.complete = true;
	}
	
	/**
	 * Test number 2
	 * Tests if a quadrant is finished when 3 Xs or Os are in a row.
	 */
	@Test
	public void testQuadrantComplete(){
		assertTrue("Quadrant not complete",q.isComplete());
	}
	
	/**
	 * Test number 5
	 * Tests the rejection of clicks on a quadrant that has been finished
	 */
	@Test
	public void testFinishedQuadrantRejectingClicks(){
		throw new RuntimeException();
	}
	
	/**
	 * Tests if the quadrant is playable
	 */
	@Test
	public void testPlayable(){
		assertTrue("Not playable", q.isActive());
	}
}
