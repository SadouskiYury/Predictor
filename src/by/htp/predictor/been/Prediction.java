package by.htp.predictor.been;

public class Prediction {
	private String target;
	private int id;

	public Prediction() {
	}

	public Prediction(String target) {
		this.target = target;

	}

	public Prediction(int id, String target) {
		this.target = target;
		this.id = id;

	}

	@Override
	public String toString() {
		return "[" + this.id + "]" + ".Prediction on " + target;
	}

	public synchronized String getTarget() {
		return target;
	}

	public synchronized void setTarget(String target) {
		this.target = target;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prediction other = (Prediction) obj;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}

}
