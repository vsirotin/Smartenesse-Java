package eu.sirotin.utils.result;

import java.util.function.Consumer;

/**
 * Class for representation results of actions with possible success or failure. 
 */
public abstract class Result<SUCCESS, FAILURE> {
	
	public abstract boolean isSuccess() ;
	
	public abstract SUCCESS getSuccess();
	
	public abstract FAILURE getFailure();
	
	public abstract Result<SUCCESS, FAILURE> ifSuccess(Consumer<SUCCESS> consumerSuccess);
	
	public abstract Result<SUCCESS, FAILURE> ifFailure(Consumer<FAILURE> consumerFailure);
	
	public  static class Success<SUCCESS, FAILURE> extends Result<SUCCESS, FAILURE>{
		
		private final SUCCESS _success;
		
		private Success(SUCCESS success) {
			_success = success;
		}

		@Override
		public boolean isSuccess() {
			return true;
		}

		@Override
		public SUCCESS getSuccess() {
			return _success;
		}

		@Override
		public FAILURE getFailure() {
			throw new IllegalStateException("getFailure called on Success");
		}

		@Override
		public String toString() {
			return "Success [_success=" + _success + "]";
		}

		@Override
		public Result<SUCCESS, FAILURE> ifSuccess(Consumer<SUCCESS> consumerSuccess) {
			consumerSuccess.accept(_success);
			return this;
		}

		@Override
		public Result<SUCCESS, FAILURE> ifFailure(Consumer<FAILURE> consumerFailure) {
			return this;
		}
		
	}
	
	public  static class Failure<SUCCESS, FAILURE> extends Result<SUCCESS, FAILURE>{
		
		private final FAILURE _failure;
		private Failure(FAILURE failure) {
			_failure = failure;
		}
		
		@Override
		public boolean isSuccess() {
			return false;
		}

		@Override
		public SUCCESS getSuccess() {
			throw new IllegalStateException("getSuccess called on Failure");
		}

		@Override
		public FAILURE getFailure() {
			return _failure;
		}

		@Override
		public String toString() {
			return "Failure [_failure=" + _failure + "]";
		}

		@Override
		public Result<SUCCESS, FAILURE> ifSuccess(Consumer<SUCCESS> consumerSuccess) {
			return this;
		}

		@Override
		public Result<SUCCESS, FAILURE> ifFailure(Consumer<FAILURE> consumerFailure) {
			consumerFailure.accept(_failure);
			return this;
		}
		
	}
	
	public static <SUCCESS, FAILURE> Result<SUCCESS, FAILURE> failure(FAILURE failure){ return new Failure<>(failure);}
	
	public static <SUCCESS, FAILURE> Result<SUCCESS, FAILURE> success(SUCCESS success){ return new Success<>(success);}

}
