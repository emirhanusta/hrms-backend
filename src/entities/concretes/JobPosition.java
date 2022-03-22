package entities.concretes;

public class JobPosition {
	private int id;
	private int jobTitle;
	
	public JobPosition() {}
	
	public JobPosition(int id, int jobTitle) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(int jobTitle) {
		this.jobTitle = jobTitle;
	}
}
