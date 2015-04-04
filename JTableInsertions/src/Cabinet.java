import java.util.ArrayList;


public class Cabinet {
	ArrayList<Subrack> subracks;
private String position;

	public String getPosition() {
	return position;
}

public void setPosition(String position) {
	this.position = position;
}

	public ArrayList<Subrack> getSubracks() {
		return subracks;
	}

	public void setSubracks(ArrayList<Subrack> subracks) {
		this.subracks = subracks;
	}
	@Override
	public String toString() {
		return "Cabinet [subracks=" + subracks + ", position=" + position + "]";
	}
}
