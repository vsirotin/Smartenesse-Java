package eu.sirotin.example.function.multiarity;

@FunctionalInterface
public interface Function3Arity<A, B, C, R>  {
	R apply(A a, B b, C c);
}