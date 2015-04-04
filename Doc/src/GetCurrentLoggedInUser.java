public class GetCurrentLoggedInUser {

	public void getCurrentLoggedInUser() {

		String currentLoggedInUser = System.getProperty("user.name");
		System.out.println("The Current Logged In User Is: " + currentLoggedInUser);
	}

	public static void main(String[] args) {
		new GetCurrentLoggedInUser().getCurrentLoggedInUser();
	}
}
