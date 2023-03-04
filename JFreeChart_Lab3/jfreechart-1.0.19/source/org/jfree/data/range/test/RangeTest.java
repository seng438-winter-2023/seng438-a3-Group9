/**
 *
 */
package org.jfree.data.range.test;

import static org.junit.Assert.*;
import org.jmock.Expectations;
import org.jmock.Mockery;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Thevin Mahawatte
 *
 */
public class RangeTest  {

    private Range exampleRange;
    private class RangeTestClass extends Range {
        public RangeTestClass(double lower, double upper) {
            super(lower, upper);
        }
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        exampleRange = new Range(-2, 3);
    }

    // combine()--------------------------------
    /**
     * This method will be testing the coverage of the combine method
     * there will be a test of the combined range of two different ranges 
     */
    @Test // old
    public void testCombineWithBothRangesAsNull() {
        Range range1 = null;
        Range range2 = null;
        Range result = Range.combine( range1, range2);
        assertNull("We are combining two null ranges. Result should be null.", result);
    }


    /**
     * This method will test the combined range with the first range being null. 
     * The range will be tested within the whole program
     */
    @Test // old
    public void testCombineWithRange1AsNull() {
        Range range1 = null;
        Range range2 = new Range(0, 10);
        Range result = Range.combine(range1, range2);
        assertEquals("We are combining one null range and one non-null one. Result should be 0-10",range2, result);
    }

    /**
     * This method will be testing the combined range of two ranges where the second one will be null 
     */
    @Test 
    public void testCombineWithRange2AsNull() {
        Range range1 = new Range(0, 10);
        Range range2 = null;
        Range result = Range.combine(range1, range2);
        assertEquals("We are combining one null range and one non-null one. Result should be 0-10",range1, result);
    }

    /**
     * This test will be checking the combination of two ranges where they are both not null 
     */
    @Test // old
    public void testCombineWithBothRangesNotNull() {
        Range range1 = new Range(0, 5);
        Range range2 = new Range(5, 10);
        Range expectedResult = new Range(0, 10);
        Range result = Range.combine(range1, range2);
        assertEquals("We are combining two non-null ranges. Result should be 0-10", expectedResult, result);
    }

    // constrain()---------------------------------

    @Test // old
    public void constrainTest() {
        assertEquals("Expected output is equal to the input since 0.1 falls within the defined range.",0.1,exampleRange.constrain(0.1), .000000001d);
    }

    /**
     * The method will be used to check the constrain between two ranges.
     * 
     */
    @Test // new
    public void constrainBetween() {
        assertEquals("Expected output: 2",
                2 , exampleRange.constrain(2), .000000001d);
    }

    /**
     * This method will be testing the upper bounds of the ranges to be contstrained for a set number. 
     * in this case it will be 4. 
     *
     */
    @Test // new
    public void constrainUpperBound() {
        assertEquals("Expected output: 3",
                3 , exampleRange.constrain(4), .000000001d);
    }

    /**
     * This method will be checking the constrains of the lower bound of the range. 
     * There will be restricted to a lower bound specified in the constrain argument.  
     * 
     */
    @Test // new
    public void constrainLowerBound() {
        assertEquals("Expected output: -2",
                -2 , exampleRange.constrain(-3), .000000001d);
    }

    // contains()--------------------------------
    // this test will be used to check if the range contains a specified value that is set in the argument. in this case it is 0.1
    @Test // old
    public void containsTest() {
        Range exampleRange;
        exampleRange = new Range(-2, 4);
        assertTrue("Expected output is True as 0.1 falls within the defined range.", exampleRange.contains(0.1));
    }

    @Test // new
    public void containsShouldBeFalseLower() {
        assertFalse("The answer should be false",
                exampleRange.contains(-5));
    }

    @Test // new
    public void containsShouldBeFalseUpper() {
        assertFalse("The answer should be false",
                exampleRange.contains(6.3));
    }

    @Test // new
    public void containsShouldBeTrueLowerBound() {
        assertTrue("The answer should be true",
                exampleRange.contains(-2));
    }

    @Test // new
    public void containsShouldBeTrueUpperBound() {
        assertTrue("The answer should be true",
                exampleRange.contains(3));
    }

    @Test // new
    public void containsShouldBeTrueBetween() {
        assertTrue("The answer should be true",
                exampleRange.contains(0));
    }

    @Test // new
    public void containsCorrect() {
        assertTrue("The answer should be true",
                exampleRange.contains(1));
    }


    // equals()---------------------------------

    /**
     * This method will be used to test if the range equals a certain value 
     */
    @Test // old
    public void testEquals_withEqualObjects_returnsTrue() {
        java.lang.Object obj1 = new Object();
        java.lang.Object obj2 = new Object();
        assertTrue("The two object are equal, so we should receive True here.", obj1.equals(obj2));
    }

    /**
     * This method will be used to test if a false boolean is returned from two ranges that are not equal to eachother 
     */
    @Test // old
    public void testEquals_withNonEqualObjects_returnsFalse() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertFalse("The two object aren't equal, so we should receive False here.", obj1.equals(obj2));
    }

    /**
     * This method will be used to check for a false return between an object that is null 
     */
    @Test // old
    public void testEquals_withNullObject_returnsFalse() {
        Object obj = new Object();
        assertFalse("We are comparing an object with null, so expectation is false", obj.equals(null));
    }

    /**
     * This method will be used to check if one range is not equal to a lower bound of another range 
     */
    @Test // new
    public void equalsIsLower() {
        Range newRange = new Range(1,2);
        assertFalse("The lower bound of R is not equal to exampleRange lower bound",
                exampleRange.equals(newRange));
    }

    /**
     * This method will be used to check if there is a range that does not contain a specified value
     */
    @Test // new
    public void equalsIsNotInRange() {
        assertFalse("The Object is not a Range",
                exampleRange.equals("COVID-19"));
    }

    /**
     * This method will be used to check if there is a specific range that 
     */
    @Test // new
    public void equalsIsUpper() {
        Range newRange = new Range(-2,6);
        assertFalse("The upper bound of R is not equal to exampleRange upper bound",
                exampleRange.equals(newRange));
    }

    /**
     * This method will be used to check if there is a true return statement that is returned from 
     * two ranges that are equal. 
     */
    @Test // new
    public void equalsIsTrue() {
        Range newRange = new Range(-2,3);
        assertTrue("Both Ranges of exampleRange and R are equal",
                exampleRange.equals(newRange));
    }


    //expand()------------------------------------
    /**
     * This method will be used to test the expand method of the ranges. 
     * It should be returning the expanded ranges. 
     */
    @Test // old
    public void testExpandWithValidInputs1() {
        Range range = new Range(2, 6);
        Range expandedRange = Range.expand(range, 0.25, 0.5);
        assertEquals("The current range is 2-6, and expanded range should be 1-8. Here we are testing the correctness of the lower bound after expansion", 1, expandedRange.getLowerBound(), .000000001d);
    }

    /**
     * This method will be used to check if there are ranges that will be expanded 
     * with two inputs that are both valid 
     */
    @Test // old
    public void testExpandWithValidInputs2() {
        Range range = new Range(2, 6);
        Range expandedRange = Range.expand(range, 0.25, 0.5);
        assertEquals("The current range is 2-6, and expanded range should be 1-8. Here we are testing the correctness of the lower bound after expansion.", 8, expandedRange.getUpperBound(), .000000001d);
    }


    //expandToInclude()----------------------------

    /**
     * This method will be used to check if the ranges can be 
     */
    @Test // old
    public void testExpandToInclude() {
        Range range = new Range(0, 10);
        Range expandedRange = Range.expandToInclude(range, 12);
        assertTrue("Number 13 should be in the range now.", range.contains(12));
    }

    /**
     *
     */
    @Test // new
    public void expandToIncludeValueLessThanLower() {
        Range newRange = new Range(-4,3);
        assertEquals("The range should be -4 to 3",
                newRange, Range.expandToInclude(exampleRange, -4));
    }

    /**
     *
     */
    @Test // new
    public void expandToIncludeValueMoreThanUpper() {
        Range newRange = new Range(-2,4);
        assertEquals("The range should be -2 to 4",
                newRange, Range.expandToInclude(exampleRange, 4));
    }

    /**
     *
     */
    @Test // new
    public void expandToIncludeEqual() {
        assertEquals("The range should be -3 to 2",
                exampleRange, Range.expandToInclude(exampleRange, 2));
    }

    /**
     *
     */
    @Test // new
    public void expandToIncludeRangeNull() {
        Range newRange = new Range(2,2);
        assertEquals("The range should be 2 to 2",
                newRange, Range.expandToInclude(null, 2));
    }


    // getCentralValue()---------------------------

    /**
     *
     */
    @Test // old
    public void testGetCentralValue()
    {
        Range exampleRange;
        exampleRange = new Range(-2, 2);
        double actual = exampleRange.getCentralValue();
        assertEquals("The expected central value is 0",0,actual, .000000001d);
    }


    // getLength()---------------------------------

    /**
     *
     */
    @Test // old
    public void getLengthTest() {
        assertEquals("The expected length between lower-bound and upper-bound is 5",5,exampleRange.getLength(), .000000001d);
    }


    /**
     *
     */
    @Test // new
    public void getLengthShouldBeZero() {
        Range newRange = new Range(0,0);
        assertEquals("The expected length between lower-bound and upper-bound is 5",
                0, newRange.getLength(), .000000001d);
    }


    // getLowerBound()-------------------------------
    @Test // old
    public void getLowerBoundTest() {
        assertEquals("The expected upper bound of the range is 3",3,exampleRange.getLowerBound(), .000000001d);
    }

    @Test // new
    public void getLowerBoundShouldBeMinusTwo() {
        assertEquals("The lower bound value of -2 and 3 should be -2",
                -2, exampleRange.getLowerBound(), .000000001d);
    }

    @Test // new
    public void getLowerBoundShouldBeOne() {
        Range newRange = new Range(1,5);
        assertEquals("The lower bound value of 1 and 5 should be 1",
                1, newRange.getLowerBound(), .000000001d);
    }

    @Test // new
    public void LowerBiggerThanUpper() {
        try {
            Range newRange = new Range(3, 1);
            assertTrue("The value is bigger than the lower bound",
                    newRange.getUpperBound() > newRange.getLowerBound());
        } catch(Exception e) {
            throw e;
        }
    }


    // getUpperBound()-------------------------------
    @Test // old
    public void getUpperrBoundTest() {
        Range exampleRange;
        exampleRange = new Range(-2, 4);
        assertEquals("The expected lower bound of the range is -2",-2,exampleRange.getUpperBound(), .000000001d);
    }


    // hashCode()-------------------------------------
    @Test // old
    public void testRangeHashCode()
    {
        int returnHashCode = hashCode();
        assertEquals("HashCode for the range -2, 4 should be 1", 1, returnHashCode);
    }


    // intersect()-----------------------------------
    @Test // old
    public void testRangeIntersect() {
        Range exampleRange;
        exampleRange = new Range(-2, 4);
        assertTrue("The intersection between (-2, 4) and (3, 10) should be true.", exampleRange.intersects(3, 10));
    }

    @Test // new
    public void intersectsShouldBeTrueOnLower() {
        assertTrue("The lines intersect with each other",
                exampleRange.intersects(-3, 0));
    }

    @Test // new
    public void intersectsShouldBeTrueOnMiddle() {
        assertTrue("The lines intersect with each other",
                exampleRange.intersects(1, 2));
    }

    @Test // new
    public void intersectsShouldBeTrueOnUpper() {
        assertTrue("The lines intersect with each other",
                exampleRange.intersects(2, 6));
    }

    @Test // new
    public void intersectsShouldBeTrueLowerOnUpper() {
        assertTrue("The lines intersect with each other",
                exampleRange.intersects(-4, 4));
    }

    @Test // new
    public void intersectsShouldBeFalseOnLower() {
        assertFalse("The lines do not intersect with each other",
                exampleRange.intersects(-7, -4));
    }

    @Test // new
    public void intersectsShouldBeFalseOnUpper() {
        assertFalse("The lines do not intersect with each other",
                exampleRange.intersects(4, 6));
    }


    // shift()---------------------------------------
    @Test // old - Zero Crossing is not alowed
    public void testShiftNotAllowZeroCrossingLowerBound()
    {
        Range base;
        base = new Range(-5.0, 5.0);
        double delta = 2.1;
        Range returnRange = Range.shift(base, delta);
        assertEquals("Lower bound of range after shifted from -5.0 by 2.1 to the right should -2.9", returnRange.getLowerBound(), base.getLowerBound(), .000000001d);
    }

    @Test  // old - Zero Crossing is not alowed
    public void testShiftNotAllowZeroCrossingUpperBound()
    {
        Range base;
        base = new Range(-5.0, 5.0);
        double delta = 2.1;
        Range returnRange = Range.shift(base, delta);
        assertEquals("Upper bound of range after shifted from 5.0 by 2.1 to the right should 7.1", returnRange.getUpperBound(), base.getUpperBound(), .000000001d);
    }

    @Test  // old - Zero Crossing is alowed
    public void testShiftAllowZeroCrossingLowerBound()
    {
        Range base;
        base = new Range(-5.0, 5.0);
        double delta = 5.1;
        boolean allowZeroCrossing = true;
        Range returnRange = Range.shift(base, delta, allowZeroCrossing);
        assertEquals("Lower bound of range after shifted from -5.0 by 2.1 to the right should 0.1", returnRange.getLowerBound(), base.getLowerBound(), .000000001d);
    }

    @Test  // old - Zero Crossing is alowed
    public void testShiftAllowZeroCrossingUpperBound()
    {
        Range base;
        base = new Range(-5.0, 5.0);
        double delta = 5.1;
        boolean allowZeroCrossing = true;
        Range returnRange = Range.shift(base, delta, allowZeroCrossing);
        assertEquals("Upper bound of range after shifted from 5.0 by 2.1 to the right should 10.1", returnRange.getUpperBound(), base.getUpperBound(), .000000001d);
    }


    // toString()------------------------------------
    @Test // old
    public void testRangeToString()
    {
        Range exampleRange;
        exampleRange = new Range(-2.0, 3.0);
        String rangeString = "Range[-2.0,3.0]";
        assertEquals("Range using toString function should be Range[-2.0,3.0]", rangeString, exampleRange.toString());
    }

    @Test // new
    public void toStringNegativePositive() {
        assertEquals("The answer should be 'Range[-2.0,3.0]'",
                "Range[-2.0,3.0]" , exampleRange.toString());
    }

    @Test // new
    public void toStringPositivePositive() {
        Range R = new Range(2, 4.2);
        assertEquals("The answer should be 'Range[2.0,4.2]'",
                "Range[2.0,4.2]" , R.toString());
    }

    @Test // new
    public void toStringNegativeNegative() {
        Range R = new Range(-4.3, -1.2);
        assertEquals("The answer should be 'Range[-4.3,-1.2]'",
                "Range[-4.3,-1.2]" , R.toString());
    }

    // Test private












/**
    //--------------------------- getUpperBound()
    @Test
    public void getUpperBoundShouldBeThree() {
        assertEquals("The upper bound value of -2 and 3 should be 3",
                3, exampleRange.getUpperBound(), .000000001d);
    }

    //--------------------------- getLength()
    @Test
    public void getLengthShouldBeFive() {
        assertEquals("The central value of -2 and 3 should be 5",
                5, exampleRange.getLength(), .000000001d);
    }

    //--------------------------- getCentralValue()
    @Test
    public void getCentralValueShouldBeZeroPointFive() {
        assertEquals("The central value of -2 and 3 should be 0.5",
                0.5, exampleRange.getCentralValue(), .000000001d);
    }

    //--------------------------- contains(double value)

    //--------------------------- intersects(double b0, double b1)
    @Test
    public void intersectsShouldBeTrueLower() {
        assertTrue("The lines interesect",
                exampleRange.intersects(-3, 0));
    }

    @Test
    public void intersectsShouldBeTrueMiddle() {
        assertTrue("The lines interesect",
                exampleRange.intersects(1, 2));
    }

    @Test
    public void intersectsShouldBeTrueUpper() { // This test case is not working
        assertTrue("The lines interesect",
                exampleRange.intersects(2, 6));
    }

    @Test
    public void intersectsShouldBeTrueLowerUpper() {
        assertTrue("The lines interesect",
                exampleRange.intersects(-4, 4));
    }

    @Test
    public void intersectsShouldBeFalseLower() { // This test case is not working
        assertFalse("The lines do not interesect",
                exampleRange.intersects(-7, -4));
    }

    @Test
    public void intersectsShouldBeFalseUpper() {
        assertFalse("The lines do not interesect",
                exampleRange.intersects(4, 6));
    }

    //--------------------------- intersects(Range range)
    @Test
    public void intersectsBoolean() {
        Range R = new Range(0,1);
        assertTrue("The lines interesect",
                exampleRange.intersects(R));
    }

    @Test
    public void intersectsBoolean2() {
        Range R = new Range(0,1);
        assertTrue("The lines interesect",
                exampleRange.intersects(R));
    }

    //--------------------------- constrain()


    //--------------------------- combine(Range range1, Range range2)
    @Test
    public void combineRange1Null() {
        assertEquals("The range is -3 to 2",
                exampleRange, Range.combine(null, exampleRange));
    }

    @Test
    public void combineRange2Null() {
        assertEquals("The range is -3 to 2",
                exampleRange, Range.combine(exampleRange, null));
    }

    @Test
    public void combineRight() {
        Range R = new Range(1, 3);
        Range C = new Range(-2, 3);
        assertEquals("The range is -3 to 3",
                C, Range.combine(exampleRange, R));
    }



    //--------------------------- expandToInclude(Range range, double value)


    //--------------------------- expand(Range range, double lowerMargin, double upperMargin)
    @Test
    public void expandRange() {
        Range R = new Range(18,23);
        assertEquals("The range should be 18 to 23",
                R, Range.expand(exampleRange, -4, 4));
    }

    //--------------------------- shift(Range base, double delta)
    @Test
    public void shiftTwoArgs() {
        Range R = new Range(0, 5);
        assertEquals("The range should be -1 to 5",
                R, Range.shift(exampleRange, 2));
    }

    //--------------------------- shift(Range base, double delta, boolean allowZeroCrossing)
    @Test
    public void shiftTrue() {
        Range R = new Range(0, 5);
        assertEquals("The range should be 0 to 5",
                R, Range.shift(exampleRange, 2, true));
    }

    @Test
    public void shiftFalse() {
        Range R = new Range(0, 5);
        assertEquals("The range should be 0 to 5",
                R, Range.shift(exampleRange, 2, false));
    }

    //--------------------------- scale(Range base, double factor)
    @Test
    public void scalePositive() {
        Range R = new Range(-4,6);
        assertEquals("The range should be -4 to 6",
                R, Range.scale(exampleRange, 2));
    }

    @Test
    public void scaleNegative() {
        try {
            assertEquals("The factor is negative",
                    null, Range.scale(exampleRange, -2));
        } catch(Exception e) {
            throw e;
        }
    }

    //--------------------------- equals(Object obj)


    @Test
    public void equalsIsNotRange() {
        assertFalse("The Object is not a Range",
                exampleRange.equals("Fluminense"));
    }


    @Test
    public void equalsTrue() {
        Range R = new Range(-2,3);
        assertTrue("Both Ranges of exampleRange and R are equal",
                exampleRange.equals(R));
    }

    //--------------------------- isNaNRange()
    @Test
    public void isNaNRangeTrue() {
        assertFalse("The range is NaN",
                exampleRange.isNaNRange());
    }

    //--------------------------- hashCode()
    @Test
    public void hashCodeTest() {
        assertEquals("The hash code is 524288",
                524288 , exampleRange.hashCode());
    }

    //--------------------------- toString()
    */
}
