
package experiments;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PopupMenu extends JFrame implements ActionListener
 {
    JPanel topPanel;
    JPopupMenu popupMenu;


	public PopupMenu()
	{
		setTitle( "Popup Menu Application" );
		setSize( 310, 130 );
		setBackground( Color.gray );

		topPanel = new JPanel();
		topPanel.setLayout( null );
		getContentPane().add( topPanel );

		// Create some menu items for the popup
		JMenuItem menuFileNew = new JMenuItem( "New" );
		JMenuItem menuFileOpen = new JMenuItem( "Open..." );
		JMenuItem menuFileSave = new JMenuItem( "Save" );
		JMenuItem menuFileSaveAs = new JMenuItem( "Save As..." );
		JMenuItem menuFileExit = new JMenuItem( "Exit" );

		// Create a popup menu
		popupMenu = new JPopupMenu( "Menu" );
		popupMenu.add( menuFileNew );
		popupMenu.add( menuFileOpen );
		popupMenu.add( menuFileSave );
		popupMenu.add( menuFileSaveAs );
		popupMenu.add( menuFileExit );

		topPanel.add( popupMenu );

		// Action and mouse listener support
		enableEvents( AWTEvent.MOUSE_EVENT_MASK );
		menuFileNew.addActionListener( this );
		menuFileOpen.addActionListener( this );
		menuFileSave.addActionListener( this );
		menuFileSaveAs.addActionListener( this );
		menuFileExit.addActionListener( this );
	}

	public void processMouseEvent( MouseEvent event )
	{
		if( event.isPopupTrigger() )
		{
			popupMenu.show( event.getComponent(),event.getX(), event.getY() );
		}

		super.processMouseEvent( event );
	}

	public void actionPerformed( ActionEvent event )
	{
	}

	public static void main( String args[] )
	{
		// Create an instance of the test application
		PopupMenu mainFrame	= new PopupMenu();
		mainFrame.setVisible( true );
	}
}