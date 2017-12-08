package eu.sirotin.utils.tuple;

import java.util.Objects;

/**
 * Class-container for pairs with different types by both components.
 * Can be imagines as vector with different componebt types.
 * @param <A> Type for first component.
 * @param <B> Type fo second component.
 */
public class Tuple2<A, B> {
	public final A a1;
	public final B a2;
	
	public Tuple2(A t, B u) {
	    a1 = Objects.requireNonNull(t);
	    a2 = Objects.requireNonNull(u);
	}
	
	@Override
	public boolean equals(Object o) {
	    if (!(o instanceof Tuple2))
	      return false;
	    else {
	      @SuppressWarnings("rawtypes")
	      Tuple2 that = (Tuple2) o;
	      return a1.equals(that.a1) && a2.equals(that.a2);
	    }
	}
	  
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + a1.hashCode();
	    result = prime * result + a2.hashCode();
	    return result;
	}
}
