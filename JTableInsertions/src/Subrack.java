import java.util.ArrayList;


public class Subrack {
	ArrayList<Board> boards;
	public String Name;
	public String position;
	public String Type;
	@Override
	public String toString() {
		return "Subrack [boards=" + boards + ", Name=" + Name + ", position="
				+ position + ", Type=" + Type + "]";
	}

	public ArrayList<Board> getBoards() {
		return boards;
	}

	public void setBoards(ArrayList<Board> boards) {
		this.boards = boards;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	
}
