package org.jfree.data.datautilities.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;


public class DataUtilitiesTest extends DataUtilities {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

    }

    //
    @Test // old
    public void calculateColumnTotalTest() {

        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount(); will(returnValue(2));

                one(values).getColumnCount(); will(returnValue(2));

                one(values).getValue(0, 0); will(returnValue(10));
                one(values).getValue(1, 0); will(returnValue(20));
                one(values).getValue(0, 1); will(returnValue(30));
                one(values).getValue(1, 1); will(returnValue(40));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("The sum of all elements in the column 0 should be 30", 30, result, .000000001d);
    }

    @Test // new
    public void calculateColumnTotalForFourValuesTest() {
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();will(returnValue(4));
                one(values).getValue(0, 0);will(returnValue(7.5));
                one(values).getValue(1, 0);will(returnValue(2.5));
                one(values).getValue(2, 0);will(returnValue(-3));
                one(values).getValue(3, 0);will(returnValue(-2));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(5.0, result, .000000001d);
    }

    @Test

    public void calculateColumnTotalWithInvalidInput() {

        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();will(returnValue(4));
                one(values).getValue(0, 0);will(returnValue(7.5));
                one(values).getValue(1, 0);will(returnValue(2.5));
                one(values).getValue(2, 0);will(returnValue(-3));
                one(values).getValue(3, 0);will(returnValue(-2));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, -1);
        assertEquals(0.0, result, .000000001d);
    }

    //-----------------------------------
    @Test // old
    public void calculateRowTotalTest() {
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount(); will(returnValue(2));
                one(values).getColumnCount(); will(returnValue(2));
                one(values).getValue(0, 0); will(returnValue(10));
                one(values).getValue(1, 0); will(returnValue(20));
                one(values).getValue(0, 1); will(returnValue(30));
                one(values).getValue(1, 1); will(returnValue(40));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0);
        double expected = 40;
        assertEquals("The sum of all elements in the row 0 should be 40", expected, result, .000000001d);
    }

    @Test // new
    public void calculateRowTotalWithInvalidInput() {

        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();will(returnValue(4));
                one(values).getValue(0, 0);will(returnValue(7.5));
                one(values).getValue(0, 1);will(returnValue(2.5));
                one(values).getValue(0, 2);will(returnValue(-3));
                one(values).getValue(0, 3);will(returnValue(-2));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, -1);
        assertEquals(0.0, result, .000000001d);
    }

    @Test // new
    public void calculateRowTotalForFourValues() {

        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();will(returnValue(4));
                one(values).getValue(0, 0);will(returnValue(7.5));
                one(values).getValue(0, 1);will(returnValue(2.5));
                one(values).getValue(0, 2);will(returnValue(-3));
                one(values).getValue(0, 3);will(returnValue(-2));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(5.0, result, .000000001d);
    }

    // ---------------------------------------------------
    @Test
    public void createNumberArrayTest() {
        java.lang.Number[] expected = new java.lang.Number[] {10.0, 20.0};
        double[] data = new double[] {10.0, 20.0};
        assertEquals("The converted double array data to array of Number objects.", expected, DataUtilities.createNumberArray(data));
    }

    @Test(expected = InvalidParameterException.class)

    public void testCreateNumberArrayWithInvalidData() throws InvalidParameterException {

        double[] input = null;

        DataUtilities.createNumberArray(input);

    }


    //--------------------------------------------------------
    @Test // old
    public void createNumberArray2DTest() {
        java.lang.Number[][] expected = new java.lang.Number[][] {{10.0, 20.0}, {30.0, 40.0}};;
        double[][] data = new double[][] {{10.0, 20.0}, {30.0, 40.0}};
        java.lang.Number[][] result = DataUtilities.createNumberArray2D(data);
        assertEquals("The converted 2D double array data to 2D array of Number objects.", expected, result);
    }

    @Test(expected = InvalidParameterException.class) // new
    public void testCreateNumberArray2DWithInvalidData() throws InvalidParameterException {
        double[][] input = null;
        DataUtilities.createNumberArray2D(input);
    }


    //--------------------------------------------------------
    @Test // old
    public void testGetCumulativePercentages() {
        Mockery context = new Mockery();
        final KeyedValues data = context.mock(KeyedValues.class, "data");
        final KeyedValues expectedResult = context.mock(KeyedValues.class, "expectedResult");

        context.checking(new Expectations() {
            {
                allowing(data).getItemCount(); will(returnValue(3));
                allowing(data).getValue(0); will(returnValue(5));
                allowing(data).getValue(1); will(returnValue(9));
                allowing(data).getValue(2); will(returnValue(2));
                allowing(data).getKey(0); will(returnValue(0));
                allowing(data).getKey(1); will(returnValue(1));
                allowing(data).getKey(2); will(returnValue(2));
                allowing(expectedResult).getItemCount(); will(returnValue(3));
                allowing(expectedResult).getValue(0); will(returnValue(0.3125));
                allowing(expectedResult).getValue(1); will(returnValue(0.875));
                allowing(expectedResult).getValue(2); will(returnValue(1.0));
                allowing(expectedResult).getKey(0); will(returnValue(0));
                allowing(expectedResult).getKey(1); will(returnValue(1));
                allowing(expectedResult).getKey(2); will(returnValue(2));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        assertEquals("Cumulative percentages failed and the new KeyValues object contains wrong values.", expectedResult, result);
        context.assertIsSatisfied();
    }
}

