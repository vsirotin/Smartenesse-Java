package eu.sirotin.example.function.multiarity;

import eu.sirotin.utils.tuple.Tuple2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMultiArity {

	private static Function3Arity<Integer, String, Integer, String> f3 = 
			(a, op, b) ->{return "" + a + op + b + "=" + (a+b);}; 		
			
	private static Function3Arity<Integer, String, Integer, Tuple2<Integer, String>> f3And2 =
			(a, op, b) ->{
				int intValue = a + b;
				String sValue = "" + a + op + b + "=" + (a+b);
				return new Tuple2<>(intValue, sValue);
				}; 	
					
	private static Function25Arity<
		Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, 
		Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer,
		Integer, Integer, Integer, Integer, Integer, 
		Integer> 
		f25 = (
				x1, 	x2, 	x3, 	x4, 	x5, 	x6, 	x7, 	x8, 	x9, 	x10,
				x11, 	x12, 	x13, 	x14, 	x15, 	x16, 	x17, 	x18, 	x19, 	x20,
				x21, 	x22, 	x23, 	x24, 	x25) 
		->
			{return x1 + 	x2 + 	x3 + 	x4 + 	x5 + 	x6 + 	x7 + 	x8 + 	x9 + 	x10 +
					x11 + 	x12 + 	x13 + 	x14 + 	x15 + 	x16 + 	x17 + 	x18 + 	x19 + 	x20 +
					x21 + 	x22 + 	x23 + 	x24 + 	x25;
		};

	private static Function3Arity<Integer, Integer, Integer, String> f2And2 =
			(a, b, c) ->{
				c =  a + b;
				return "" + a + "+" + b + "=" + c;
			};

	@Test
	public void testFunction3Arity() {
		String result = f3.apply(2, "+", 3);
		assertEquals("2+3=5", result);
	}
	
	@Test
	public void testFunction3And2Arity() {
		Tuple2<?,?> result = f3And2.apply(2, "+", 3);
		assertEquals(5, result.a1);
		assertEquals("2+3=5", result.a2);
	}
	
	@Test
	public void testFunction25Arity() {
		int result = f25.apply(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25);
		assertEquals(325, result);
	}
}
