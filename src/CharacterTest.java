import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CharacterTest {

	boardElements.Character chara;
	
	@Before
	public void setUp() {
		chara = new boardElements.Character();
		chara.type = "X";
	}
	
	/**
	 * Tests if a Character loads successfully
	 */
	@Test
	public void testLoad() {
		assertTrue("Character did not load.", (chara.type != ""));
	}
	
	/**
	 * Tests if a character type exists
	 */
	@Test
	public void testCharType() {
		assertTrue("Character type does not exist.", chara.type != null);
	}
}
