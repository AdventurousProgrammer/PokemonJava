package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import pokemongrid.Pokemon;
import pokemongrid.GameProgressor;

class TestController {

	@Test
	void testLocationChangeMoveRightInsideBoundaries() {
		ArrayList<Integer> expected1 = new ArrayList<Integer>();
		expected1.add(4);
		expected1.add(3);
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"R", 2);
		
		ArrayList<Integer> actual1 = new ArrayList<Integer>();
		actual1.add(tepig.getX_coord());
		actual1.add(tepig.getY_coord());
		
		
		checkCorrectness(actual1,expected1);
		
		//fail("Not yet implemented");
		
	}
	@Test
	void testLocationChangeMoveRightOutsideBoundaries() {
		
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"R", 3);
		ArrayList<Integer> actual2 = new ArrayList<Integer>();
        actual2.add(tepig.getX_coord());
        actual2.add(tepig.getY_coord());
		
		ArrayList<Integer> expected2 = new ArrayList<Integer>();
		expected2.add(0);
		expected2.add(3);
		
		
		
		checkCorrectness(actual2,expected2);
	}
	@Test
	void testLocationChangeLeftInsideBoundaries() {
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"L", 1);
		
		ArrayList<Integer> actual3 = new ArrayList<Integer>();
		actual3.add(tepig.getX_coord());
		actual3.add(tepig.getY_coord());
		
		ArrayList<Integer> expected3 = new ArrayList<Integer>();
		expected3.add(1);
		expected3.add(3);
		
		checkCorrectness(actual3,expected3);
	}
	@Test
	void testLocationChangeLeftOutsideBoundaries() {
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"L", 3);
		
		ArrayList<Integer> actual4 = new ArrayList<Integer>();
		actual4.add(tepig.getX_coord());
		actual4.add(tepig.getY_coord());
		
		ArrayList<Integer> expected4 = new ArrayList<Integer>();
		expected4.add(4);
		expected4.add(3);
		
		
		
		checkCorrectness(actual4,expected4);
	}
	@Test
	void testLocationChangeUpInsideBoundaries() {
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"U", 1);
		ArrayList<Integer> actual5 = new ArrayList<Integer>();
		actual5.add(tepig.getX_coord());
		actual5.add(tepig.getY_coord());
		
		ArrayList<Integer> expected5 = new ArrayList<Integer>();
		expected5.add(2);
		expected5.add(2);
		
		
		
		checkCorrectness(actual5,expected5);
	}
	@Test 
	void testLocationChangeUpOutsideBoundaries(){
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"U", 4);
		
		ArrayList<Integer> actual6 = new ArrayList<Integer>();

		ArrayList<Integer> expected6 = new ArrayList<Integer>();
		expected6.add(2);
		expected6.add(5);
		
		checkCorrectness(actual6,expected6);
	}
	@Test
	void testLocationChangeDownInsideBoundaries() {
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"D", 1);
		ArrayList<Integer> actual7 = new ArrayList<Integer>();
		actual7.add(tepig.getX_coord());
		actual7.add(tepig.getY_coord());

		
		ArrayList<Integer> expected7 = new ArrayList<Integer>();
		expected7.add(2);
		expected7.add(4);
		
		
		
		checkCorrectness(actual7,expected7);
	}
	@Test
	void testLocationChangeDownOutsideBoundaries() {
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"D", 3);
		
		ArrayList<Integer> actual8 = new ArrayList<Integer>();
		actual8.add(tepig.getX_coord());
		actual8.add(tepig.getY_coord());
		
		ArrayList<Integer> expected8 = new ArrayList<Integer>();
		expected8.add(2);
		expected8.add(0);
		
		
		
		checkCorrectness(actual8,expected8);
	}
	@Test
	void testLocationChangeURDInsideBoundaries() {
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"URD", 1);
		ArrayList<Integer> actual9 = new ArrayList<Integer>();
		actual9.add(tepig.getX_coord());
		actual9.add(tepig.getY_coord());
		
		ArrayList<Integer> expected9 = new ArrayList<Integer>();

		expected9.add(3);
		expected9.add(2);
		
		checkCorrectness(actual9,expected9);

	}
	@Test
	void testLocationChangeURDOutsideBoundaries() {
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"URD", 3);
		ArrayList<Integer> actual10 = new ArrayList<Integer>();
		actual10.add(tepig.getY_coord());
		actual10.add(tepig.getY_coord());
		
		ArrayList<Integer> expected10 = new ArrayList<Integer>();

		expected10.add(0);
		expected10.add(0);
		
		checkCorrectness(actual10,expected10);
	}
	@Test
	void testLocationChangeDRDInsideBoundaries() {
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"DRD", 1);
		ArrayList<Integer> actual11 = new ArrayList<Integer>();
		actual11.add(tepig.getX_coord());
		actual11.add(tepig.getY_coord());
		
		ArrayList<Integer> expected11 = new ArrayList<Integer>();

		expected11.add(3);
		expected11.add(4);
		
		checkCorrectness(actual11,expected11);
	}
	@Test
	void testLocationChangeDRDOutsideBoundaries() {
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"DRD", 3);
		ArrayList<Integer> actual12 = new ArrayList<Integer>();
		actual12.add(tepig.getX_coord());
		actual12.add(tepig.getY_coord());
		
		ArrayList<Integer> expected12 = new ArrayList<Integer>();

		expected12.add(0);
		expected12.add(0);
		
		checkCorrectness(actual12,expected12);
	}
	@Test
	void testLocationChangeDLDInsideBoundaries() {
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"DLD", 1);
		ArrayList<Integer> actual13 = new ArrayList<Integer>();
		actual13.add(tepig.getX_coord());
		actual13.add(tepig.getY_coord());
		ArrayList<Integer> expected13 = new ArrayList<Integer>();

		expected13.add(1);
		expected13.add(4);
		
		checkCorrectness(actual13,expected13);
	}
	@Test
	void testLocationChangeDLDOutsideBoundaries() {
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"DLD", 3);
		
		ArrayList<Integer> actual14 = new ArrayList<Integer>();
		actual14.add(tepig.getX_coord());
		actual14.add(tepig.getY_coord());
		
		ArrayList<Integer> expected13 = new ArrayList<Integer>();

		expected13.add(4);
		expected13.add(0);
		
		checkCorrectness(actual14,expected13);
	}
	@Test
	void testLocationChangeULDInsideBoundaries() {
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"ULD", 1);
		
		ArrayList<Integer> actual14 = new ArrayList<Integer>();
		actual14.add(tepig.getX_coord());
		actual14.add(tepig.getY_coord());
		
		ArrayList<Integer> expected14 = new ArrayList<Integer>();

		expected14.add(1);
		expected14.add(2);
		
		checkCorrectness(actual14,expected14);
	}
	@Test
	void testLocationChangeULDOutsideBoundaries() {
		Pokemon tepig = new Pokemon("Tepig");
		
		tepig.setX_coord(2);
		tepig.setY_coord(3);
		
		GameProgressor.locationChange(tepig,"ULD", 4);
		
		ArrayList<Integer> actual15 = new ArrayList<Integer>();
		actual15.add(tepig.getX_coord());
		actual15.add(tepig.getY_coord());
		
		ArrayList<Integer> expected15 = new ArrayList<Integer>();

		expected15.add(3);
		expected15.add(5);
		
		checkCorrectness(actual15,expected15);
	}


	private void checkCorrectness(ArrayList<Integer> actual, ArrayList<Integer> expected) {
		// TODO Auto-generated method stub
		for(int i = 0; i < actual.size(); i++) {
			assertEquals(expected.get(i),actual.get(i),"expected: " + expected.get(i) + " actual: " + actual.get(i));
		}
	}

}
