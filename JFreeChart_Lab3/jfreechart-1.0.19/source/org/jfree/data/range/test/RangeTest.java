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
     *
     */
    @Test // old
    public void testCombineWithBothRangesAsNull() {
        Range range1 = null;
        Range range2 = null;
        Range result = Range.combine( range1, range2);
        assertNull("We are combining two null ranges. Result should be null.", result);
    }


    /**
     *
     */
    @Test // old
    public void testCombineWithRange1AsNull() {
        Range range1 = null;
        Range range2 = new Range(0, 10);
        Range result = Range.combine(range1, range2);
        assertEquals("We are combining one null range and one non-null one. Result should be 0-10",range2, result);
    }

    /**
     *
     */
    @Test // old
    public void testCombineWithRange2AsNull() {
        Range range1 = new Range(0, 10);
        Range range2 = null;
        Range result = Range.combine(range1, range2);
        assertEquals("We are combining one null range and one non-null one. Result should be 0-10",range1, result);
    }

    /**
     *
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
     *
     */
    @Test // new
    public void constrainBetween() {
        assertEquals("Expected output: 2",
                2 , exampleRange.constrain(2), .000000001d);
    }

    /**
     *
     */
    @Test // new
    public void constrainUpperBound() {
        assertEquals("Expected output: 3",
                3 , exampleRange.constrain(4), .000000001d);
    }

    /**
     *
     */
    @Test // new
    public void constrainLowerBound() {
        assertEquals("Expected output: -2",
                -2 , exampleRange.constrain(-3), .000000001d);
    }

    // contains()--------------------------------
    @Test // old
    public void containsTest() {
        Range exampleRange;
        exampleRange = new Range(-2, 4);
        assertTrue("Expected output is True as 0.1 falls within the defined range.", exampleRange.contains(0.1));
    }


    // equals()---------------------------------

    /**
     *
     */
    @Test // old
    public void testEquals_withEqualObjects_returnsTrue() {
        java.lang.Object obj1 = new Object();
        java.lang.Object obj2 = new Object();
        assertTrue("The two object are equal, so we should receive True here.", obj1.equals(obj2));
    }

    /**
     *
     */
    @Test // old
    public void testEquals_withNonEqualObjects_returnsFalse() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertFalse("The two object aren't equal, so we should receive False here.", obj1.equals(obj2));
    }

    /**
     *
     */
    @Test // old
    public void testEquals_withNullObject_returnsFalse() {
        Object obj = new Object();
        assertFalse("We are comparing an object with null, so expectation is false", obj.equals(null));
    }

    /**
     *
     */
    @Test // new
    public void equalsIsLower() {
        Range newRange = new Range(1,2);
        assertFalse("The lower bound of R is not equal to exampleRange lower bound",
                exampleRange.equals(newRange));
    }

    /**
     *
     */
    @Test // new
    public void equalsIsNotInRange() {
        assertFalse("The Object is not a Range",
                exampleRange.equals("COVID-19"));
    }

    /**
     *
     */
    @Test // new
    public void equalsIsUpper() {
        Range newRange = new Range(-2,6);
        assertFalse("The upper bound of R is not equal to exampleRange upper bound",
                exampleRange.equals(newRange));
    }

    /**
     *
     */
    @Test // new
    public void equalsIsTrue() {
        Range newRange = new Range(-2,3);
        assertTrue("Both Ranges of exampleRange and R are equal",
                exampleRange.equals(newRange));
    }


    //expand()------------------------------------
    /**
     *
     */
    @Test // old
    public void testExpandWithValidInputs1() {
        Range range = new Range(2, 6);
        Range expandedRange = Range.expand(range, 0.25, 0.5);
        assertEquals("The current range is 2-6, and expanded range should be 1-8. Here we are testing the correctness of the lower bound after expansion", 1, expandedRange.getLowerBound(), .000000001d);
    }

    /**
     *
     */
    @Test // old
    public void testExpandWithValidInputs2() {
        Range range = new Range(2, 6);
        Range expandedRange = Range.expand(range, 0.25, 0.5);
        assertEquals("The current range is 2-6, and expanded range should be 1-8. Here we are testing the correctness of the lower bound after expansion.", 8, expandedRange.getUpperBound(), .000000001d);
    }


    //expandToInclude()----------------------------

    /**
     *
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
}
