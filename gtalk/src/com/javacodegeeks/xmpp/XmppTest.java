package com.javacodegeeks.xmpp;

public class XmppTest {
	
	public static void main(String[] args) throws Exception {
		
		String username = "ravjot28@gmail.com";
		String password = "docomo3401";
		
		XmppManager xmppManager = new XmppManager("talk.google.com", 5222);
		
		xmppManager.init();
		xmppManager.performLogin(username, password);
		xmppManager.setStatus(true, "Hello everyone");
		
		String buddyJID = "testuser2";
		String buddyName = "testuser2";
		xmppManager.createEntry(buddyJID, buddyName);
		
		xmppManager.sendMessage("Hello mate", "testuser2@myserver");
		
		xmppManager.printRoster();
		
		boolean isRunning = true;
		
		while (isRunning) {
			Thread.sleep(50);
		}
		
		xmppManager.destroy();
		
	}

}
