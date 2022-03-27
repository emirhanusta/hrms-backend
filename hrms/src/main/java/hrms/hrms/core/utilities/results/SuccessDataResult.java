package hrms.hrms.core.utilities.results;

public class SuccessDataResult<T> extends DataResult{

	public SuccessDataResult(T data, boolean success, String message) {
		super(data, true, message);
	}
	public SuccessDataResult(T data, boolean success) {
		super(data, true);
	}
	public SuccessDataResult(String message) {
		super(null, true,message);
	}
	public SuccessDataResult() {
		super(null, true);
	}
	

}
 