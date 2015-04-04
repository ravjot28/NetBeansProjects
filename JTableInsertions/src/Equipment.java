import java.util.ArrayList;


public class Equipment 
	{
		ArrayList<Cabinet> cabinet;
		private String BuildingPractice;
	
		public String getBuildingPractice() {
		return BuildingPractice;
	}
		
		public void setBuildingPractice(String buildingPractice) {
			BuildingPractice = buildingPractice;
}
		@Override
		public String toString() {
			return "Equipment [cabinet=" + cabinet + ", BuildingPractice="
					+ BuildingPractice + "]";
		}


	public ArrayList<Cabinet> getCabinet() {
		return cabinet;
	}

	public void setCabinet(ArrayList<Cabinet> cabinet) {
		this.cabinet = cabinet;
	}
	
	
}
