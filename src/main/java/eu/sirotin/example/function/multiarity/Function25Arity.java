package eu.sirotin.example.function.multiarity;

@FunctionalInterface
public interface Function25Arity<
	X1, 	X2, 	X3, 	X4, 	X5, 	X6, 	X7, 	X8, 	X9, 	X10, 
	X11, 	X12, 	X13, 	X14, 	X15, 	X16, 	X17, 	X18, 	X19, 	X20,
	X21, 	X22, 	X23, 	X24, 	X25,
	R>  {
		R apply(
				X1 x1, 		X2 x2, 		X3 x3, 		X4 x4, 		X5 x5, 		X6 x6, 		X7 x7, 		X8 x8, 		X9 x9, 		X10 x10, 
				X11 x11, 	X12 x12, 	X13 x13, 	X14 x14, 	X15 x15, 	X16 x16, 	X17 x17, 	X18 x18, 	X19 x19, 	X20 x20,
				X21 x21, 	X22 x22, 	X23 x23, 	X24 x24, 	X25 x25);
}