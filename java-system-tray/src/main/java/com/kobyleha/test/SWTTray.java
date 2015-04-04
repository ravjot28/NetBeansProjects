package com.kobyleha.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;

public class SWTTray {

	private static final String MENU_ITEM_TEXT = "Menu Item";

	private static final String ICON_IMAGE = "icon.gif";


	public static void main(String[] args) {
		SWTTray test = new SWTTray();
		test.showTray();
	}

	public void showTray() {
		final Display display = new Display();

		Shell shell = new Shell(display);
		Tray tray = display.getSystemTray();
		if (tray != null) {
			initTray(display, shell, tray);
		}
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	private void initTray(final Display display, final Shell shell, Tray tray) {
		Image image = new Image(display, SWTTray.class.getClassLoader()
				.getResourceAsStream(ICON_IMAGE));
		TrayItem item = new TrayItem(tray, SWT.NONE);
		item.setImage(image);
		final Menu menu = new Menu(shell, SWT.POP_UP);
		MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText("menu item 1");
		menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText("menu item 2");
		menuItem = new MenuItem(menu, SWT.SEPARATOR);
		menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText("Quit");
		menuItem.addSelectionListener(new SelectionListener(){

			public void widgetSelected(SelectionEvent arg0) {
				System.exit(0);
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		item.addSelectionListener(getSelectionListener(display, menu));
		item.addMenuDetectListener(getMenuDetectListener(display, menu));
	}

	private MenuDetectListener getMenuDetectListener(final Display display,
			final Menu menu) {
		return new MenuDetectListener() {
			public void menuDetected(MenuDetectEvent event) {
				processEvent(display, menu);
			}

		};
	}

	private SelectionListener getSelectionListener(final Display display,
			final Menu menu) {
		return new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent event) {
				widgetSelected(event);
			}

			public void widgetSelected(SelectionEvent event) {
				processEvent(display, menu);

			}
		};
	}

	/**
	 * @param display
	 * @param menu
	 */
	private void processEvent(final Display display, final Menu menu) {
		Point cursorLocation = display.getCursorLocation();
		menu.setLocation(cursorLocation.x, cursorLocation.y);
		menu.setVisible(true);
	}
}