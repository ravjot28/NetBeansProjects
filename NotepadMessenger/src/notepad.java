import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;
import java.io.*;
import javax.print.attribute.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.undo.*;
import java.awt.datatransfer.*;

public class notepad extends JFrame implements ActionListener
{
	
	JMenuItem disconnectItem;
	JMenuItem serverItem;
	JMenuItem clientItem;
	JMenuItem aboutItem;
	JMenuItem exitItem;	
	public JTextArea notepadArea;
	JTextArea ta;	
	final Color colorValues[]={Color.black,Color.blue,Color.red,Color.green};

	Container c;
	public JScrollPane sc;
	//public JTextArea t;
	Clipboard clip=getToolkit().getSystemClipboard();

	JMenuBar menubar;

	JMenu file;
	JMenuItem file_new;
	JMenuItem file_open;
	JSeparator file_sep1;
	JMenuItem file_save;
	JMenuItem file_save_as;
	JSeparator file_sep2;
	JMenuItem file_print;
	JSeparator file_sep3;
	JMenuItem file_close;
	JMenuItem file_exit;

	JMenu edit;
	JMenuItem edit_undo;
	JMenuItem edit_redo;
	JSeparator edit_sep1;
	JMenuItem edit_copy;
	JMenuItem edit_cut;
	JMenuItem edit_paste;
	JMenuItem edit_delete;
	JSeparator edit_sep2;
	JMenuItem edit_find;
	JMenuItem edit_find_next;
	JMenuItem edit_replace;
	JSeparator edit_sep3;
	JMenuItem edit_selectall;
	JMenuItem edit_timedate;

	JMenu format;
	JMenuItem format_font;
	JCheckBoxMenuItem format_wordwrap;	

	JMenu convert;
	JMenuItem str2uppr;
	JMenuItem str2lwr;	
	
	JMenu help;
	JMenuItem help_about;

	JMenu others;
	JMenuItem others_chat;
	JMenuItem others_activateserver;
	JMenuItem others_activateclient;
	JMenuItem others_disconnect_clientserver;
	JMenuItem others_aboutus;
	JMenuItem others_exit;

	UndoManager undo=new UndoManager();
	UIManager.LookAndFeelInfo Inf[];

	find finder;
	font_chooser fc;
	about abt;

	String path,content;

	Socket communicationSocket=null;
	PrintWriter outStream=null;
	BufferedReader inStream=null;
	Boolean communicationContinue=true;
	String disconnectString="disconnect";
	JTextField displayLabel;
	String data;
	String filename;

	ServerThread st;
	
	public notepad()
	{
	
		super("Untitled - Notepad");
		try
		{
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage("Notepadicon.png"));

		Container c=getContentPane();
		sc=new JScrollPane(notepadArea,sc.VERTICAL_SCROLLBAR_AS_NEEDED,sc.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		c.add(sc);

		menubar=new JMenuBar();

		file=new JMenu("File");
		file_new=new JMenuItem("New");
		file_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		file_new.addActionListener(this);
		file.add(file_new);
		file_open=new JMenuItem("Open");
		file_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		file_open.addActionListener(this);
		file.add(file_open);
		file_sep1=new JSeparator();
		file.add(file_sep1);
		file_save=new JMenuItem("Save");
		file_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		file_save.addActionListener(this);
		file.add(file_save);
		file_save_as=new JMenuItem("Save As");
		file_save_as.addActionListener(this);
		file.add(file_save_as);
		file_sep2=new JSeparator();
		file.add(file_sep2);
		file_print=new JMenuItem("Print");
		file_print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK));
		file_print.addActionListener(this);
		file.add(file_print);
		file_sep3=new JSeparator();
		file.add(file_sep3);
		file_close=new JMenuItem("Close");
		file_close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,InputEvent.CTRL_MASK));
		file_close.addActionListener(this);
		file.add(file_close);
		file_exit=new JMenuItem("Exit");
		file_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,InputEvent.ALT_MASK));
		file_exit.addActionListener(this);
		file.add(file_exit);
		menubar.add(file);

		edit=new JMenu("Edit");
		edit_undo=new JMenuItem("Undo");
		edit_undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));
		edit_undo.addActionListener(this);
		edit.add(edit_undo);
		edit_redo=new JMenuItem("Redo");
		edit_redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,InputEvent.CTRL_MASK));
		edit_redo.addActionListener(this);
		edit.add(edit_redo);
		edit_sep1=new JSeparator();
		edit.add(edit_sep1);
		edit_copy=new JMenuItem("Copy");
		edit_copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		edit_copy.addActionListener(this);
		edit.add(edit_copy);
		edit_cut=new JMenuItem("Cut");
		edit_cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
		edit_cut.addActionListener(this);
		edit.add(edit_cut);
		edit_paste=new JMenuItem("Paste");
		edit_paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
		edit_paste.addActionListener(this);
		edit.add(edit_paste);
		edit_delete=new JMenuItem("Delete");
		edit_delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));
		edit_delete.addActionListener(this);
		edit.add(edit_delete);
		edit_sep2=new JSeparator();
		edit.add(edit_sep2);
		edit_find=new JMenuItem("Find");
		edit_find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
		edit_find.addActionListener(this);
		edit.add(edit_find);
		edit_find_next=new JMenuItem("Find Next");
		edit_find_next.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3,0));
		edit_find_next.addActionListener(this);
		edit.add(edit_find_next);
		edit_replace=new JMenuItem("Replace");
		edit_replace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.CTRL_MASK));
		edit_replace.addActionListener(this);
		edit.add(edit_replace);
		edit_sep3=new JSeparator();
		edit.add(edit_sep3);
		edit_selectall=new JMenuItem("Select All");
		edit_selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		edit_selectall.addActionListener(this);
		edit.add(edit_selectall);
		edit_timedate=new JMenuItem("Time/Date");
		edit_timedate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,0));
		edit_timedate.addActionListener(this);
		edit.add(edit_timedate);
		menubar.add(edit);

		format=new JMenu("Format");
		format_wordwrap=new JCheckBoxMenuItem("Word Wrap");
		format_wordwrap.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,InputEvent.CTRL_MASK));
		format_wordwrap.addActionListener(this);
		format.add(format_wordwrap);
		format_font=new JMenuItem("Font");
		format_font.addActionListener(this);
		format.add(format_font);

		convert=new JMenu("Convert");
		str2uppr=new JMenuItem("To Uppercase...");
		str2uppr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UP,InputEvent.CTRL_MASK));
		str2uppr.addActionListener(this);
		convert.add(str2uppr);
		str2lwr=new JMenuItem("To Lowercase...");
		str2lwr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,InputEvent.CTRL_MASK));
		str2lwr.addActionListener(this);
		convert.add(str2lwr);
		format.add(convert);
		menubar.add(format);

		help=new JMenu("Help");
		help_about=new JMenuItem("About");
		help_about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));
		help_about.addActionListener(this);
		help.add(help_about);
		menubar.add(help);		
	
		
		
		
		
		
		
		
					
		JMenu others=new JMenu("Others");
		others.setMnemonic('o');		

		JMenuItem chat=new JMenuItem("Chat");
		others.add(chat);
		chat.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				serverItem.setEnabled(true);
				clientItem.setEnabled(true);
				aboutItem.setEnabled(true);
				exitItem.setEnabled(true);
				displayLabel.setVisible(true);
				ta.setVisible(true);				
			}
		});		
		
		serverItem=new JMenuItem("Activate Server");
		serverItem.setMnemonic('s');
		serverItem.setEnabled(false);
		others.add(serverItem);
		serverItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				setUpServer();																
			}
		});
		
		clientItem=new JMenuItem("Activate Client");
		clientItem.setMnemonic('c');
		clientItem.setEnabled(false);
		others.add(clientItem);
		clientItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				setUpClient();
			}	
		});
	
		disconnectItem=new JMenuItem("Disconnect Client/Server");
		disconnectItem.setMnemonic('d');
		disconnectItem.setEnabled(false);
		others.add(disconnectItem);
		disconnectItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				disconnectClientServer(true);
			}
		});
		
		aboutItem=new JMenuItem("About Us");
		aboutItem.setMnemonic('a');
		aboutItem.setEnabled(false);
		others.add(aboutItem);
		aboutItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				JOptionPane.showMessageDialog(notepad.this,"This is an example\nof using Menus","About",JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		exitItem=new JMenuItem("Exit");
		exitItem.setMnemonic('x');
		exitItem.setEnabled(false);
		others.add(exitItem);
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				disconnectClientServer(true);
				displayLabel.setVisible(false);
				ta.setVisible(false);
			}
		});
		
		
		setJMenuBar(menubar);
		
		
		
		
				
		menubar.add(others);
	
		setLayout(new BorderLayout());
		
		notepadArea=new JTextArea("",5,5);
		ta=new JTextArea();

		notepadArea.setFont(new Font("Verdana",Font.PLAIN,12));
		sc=new JScrollPane(notepadArea,sc.VERTICAL_SCROLLBAR_AS_NEEDED,sc.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		c.add(sc);
				
		displayLabel=new JTextField();						
		displayLabel.setForeground(colorValues[0]);
		displayLabel.setVisible(false);
		displayLabel.setFont(new Font("Serif",Font.PLAIN,25));
		displayLabel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				sendData();
			}
		});
		
		add(notepadArea,BorderLayout.CENTER);
		add(ta,BorderLayout.EAST);
		ta.setVisible(false);
		add(displayLabel,BorderLayout.SOUTH);
		
		
		Document doc=notepadArea.getDocument();
		doc.addUndoableEditListener(new UndoableEditListener()
		{
			public void undoableEditHappened(UndoableEditEvent event)
			{
				undo.addEdit(event.getEdit());
			}
		});
		
		finder=new find(this);
		finder.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		fc=new font_chooser(this);
		abt=new about(this);

		int w=400;
		int h=500;
		setSize(h,w);

		Point center=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		setLocation(center.x-w/2,center.y-h/2);
		this.setVisible(true);
		path="";	
			
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==file_new)
		{
			file_new();
		}
		else if(ae.getSource()==file_open)
		{
			file_open();
		}
		else if(ae.getSource()==file_save)
		{
			file_save();
		}
		else if(ae.getSource()==file_save_as)
		{
			file_save_as();
		}
		else if(ae.getSource()==file_print)
		{
			file_print();
		}
		else if(ae.getSource()==file_close)
		{
			file_close();
		}
		else if(ae.getSource()==file_exit)
		{
			file_exit();
		}

		else if(ae.getSource()==edit_undo)
		{
			edit_undo();
		}
		else if(ae.getSource()==edit_redo)
		{
			edit_redo();
		}
		else if(ae.getSource()==edit_cut)
		{
			edit_cut();
		}
		else if(ae.getSource()==edit_copy)
		{
			edit_copy();
		}
		else if(ae.getSource()==edit_paste)
		{
			edit_paste();
		}
		else if(ae.getSource()==edit_delete)
		{
			edit_delete();
		}
		else if(ae.getSource()==edit_find)
		{
			edit_find();
		}
		else if(ae.getSource()==edit_find_next)
		{
			edit_find_next();
		}
		else if(ae.getSource()==edit_replace)
		{
			edit_replace();
		}
		else if(ae.getSource()==edit_selectall)
		{
			edit_selectall();
		}
		else if(ae.getSource()==edit_timedate)
		{
			edit_timedate();
		}

		else if(ae.getSource()==format_wordwrap)
		{
			format_wordwrap();
		}
		else if(ae.getSource()==format_font)
		{
			format_font();
		}
		else if(ae.getSource()==str2uppr)
		{
			str2uppr();
		}
		else if(ae.getSource()==str2lwr)
		{
			str2lwr();
		}

		else if(ae.getSource()==help_about)
		{
			help_about();
		}		
	}	
	

	public void file_new()
	{
		if(notepadArea.getText().equals("")||notepadArea.getText().equals(content))
		{
			notepadArea.setText("");
			content="";
			path="";
			setTitle("Untitled - Notepad");
		}
		else
		{
			int a=JOptionPane.showConfirmDialog(null,"The text has been changd\nDo you want to save the changes?");
			if(a==0)
			{
				file_save();
			}
			else if(a==1)
			{
				notepadArea.setText("");
				path="";
				setTitle("Untitled - Notepad");
			}
			else if(a==2)
			{
				return;
			}
		}
	}

	public void file_open()
	{
		JFileChooser fc=new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int r=fc.showOpenDialog(this);

		if(r==fc.CANCEL_OPTION)
		{
			return;
		}

		File myfile=fc.getSelectedFile();

		if(myfile==null||myfile.getName().equals(""))
		{
			JOptionPane.showMessageDialog(this,"Select a file!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		try
		{
			BufferedReader input=new BufferedReader(new FileReader(myfile));
			StringBuffer str=new StringBuffer();
			String line;
			while((line=input.readLine())!=null)
			{
				str.append(line+"\n");			
			}
			notepadArea.setText(str.toString());
			content=notepadArea.getText();
			path=myfile.toString();
			setTitle(myfile.getName()+" - Notepad");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"File not found: "+e);	
		}
	}

	public void file_save()
	{
		if(path.equals(""))
		{
			file_save_as();
			return;
		}
		try
		{
			FileWriter fw=new FileWriter(path);
			fw.write(notepadArea.getText());
			content=notepadArea.getText();
			fw.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Failed to save the file","Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void file_save_as()
	{
		JFileChooser fc=new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int r=fc.showSaveDialog(this);
		if(r==fc.CANCEL_OPTION)
		{
			return;
		}
		File myfile=fc.getSelectedFile();
		if(myfile==null||myfile.getName().equals(""))
		{
			JOptionPane.showMessageDialog(this,"Please enter a file name!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(myfile.exists())
		{
			r=JOptionPane.showConfirmDialog(this,"A file with same name already exists!\nAre you sure want to overwrite?");
			if(r!=0)
			{
				return;
			}
		}
		try
		{
			FileWriter fw=new FileWriter(myfile);
			fw.write(notepadArea.getText());
			content=notepadArea.getText();
			setTitle(myfile.getName()+" - Notepad");
			fw.close();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(this,"Failed to save the file","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void file_print()
	{
		PrinterJob printer=PrinterJob.getPrinterJob();
		HashPrintRequestAttributeSet printAttr = new HashPrintRequestAttributeSet();
		if(printer.printDialog(printAttr))
		{
			try
			{
				printer.print(printAttr);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"Failed to print the file: "+e,"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void file_close()
	{
		if(notepadArea.getText().equals("")||notepadArea.getText().equals(content))
		{
			notepadArea.setText("");
			path="";
			setTitle("Untitled - Notepad");
		}
		else
		{
			int a=JOptionPane.showConfirmDialog(null,"The text has been changed\nDo you want to save the changes?");
			if(a==0)		
			{
				file_save();
			}
			else if(a==1)
			{
				notepadArea.setText("");
				path="";
				setTitle("Untitled - Notepad");
			}
			else if(a==2)
			{
				return;
			}
		}
	}

	public void file_exit()
	{
		if(notepadArea.getText().equals("")||notepadArea.getText().equals(content))	
		{
			System.exit(0);
		}
		else
		{
			int b=JOptionPane.showConfirmDialog(null,"The text has been changed.\nDo you want to save the changes?");
			if(b==0)
			{
				file_save();
			}
			else if(b==1)
			{
				System.exit(0);
			}
			else if(b==2)
			{
				return;
			}
		}
	}

	public void edit_undo()
	{
		if(undo.canUndo())
		{
			try
			{
				undo.undo();
			}
			catch(Exception e)
			{				
			}
		}
	}

	public void edit_redo()
	{
		if(undo.canRedo())
		{
			try
			{
				undo.redo();
			}
			catch(Exception e)
			{
			}
		}
	}

	public void edit_cut()
	{
		notepadArea.cut();
	}

	public void edit_copy()
	{
		notepadArea.copy();
	}

	public void edit_paste()
	{
		notepadArea.paste();
	}

	public void edit_delete()
	{
		String temp=notepadArea.getText();
		notepadArea.setText(temp.substring(0,notepadArea.getSelectionStart())+temp.substring(notepadArea.getSelectionEnd()));
	}
	
	public void edit_find()
	{
		finder.setVisible(true);
	}

	public void edit_find_next()
	{
		finder.find_next();
	}

	public void edit_replace()
	{
		finder.setVisible(true);
	}

	public void edit_selectall()
	{
		notepadArea.selectAll();
	}

	public void edit_timedate()
	{
		try
		{
			int start=notepadArea.getSelectionStart();
			int end=notepadArea.getSelectionEnd();
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy h:m a");
			String now=sdf.format(cal.getTime());
			String temp1=notepadArea.getText().substring(0,start);
			String temp2=notepadArea.getText().substring(end);
			notepadArea.setText(temp1+" "+now+" "+temp2);
			notepadArea.select(start+1,start+1+now.length());
		}
		catch(Exception e)
		{
		}
	}

	public void format_font()
	{		
		fc.window.setVisible(true);
	}

	public void format_wordwrap()
	{
		if(notepadArea.getLineWrap()==false)
		{
			notepadArea.setLineWrap(true);
		}
		else
		{
			notepadArea.setLineWrap(false);
		}
	}

	public void str2uppr()
	{
		try
		{
			int start=notepadArea.getSelectionStart();
			int end=notepadArea.getSelectionEnd();
			String temp1=notepadArea.getText().substring(0,start);
			String temp2=notepadArea.getText().substring(end);
			String conv=notepadArea.getSelectedText().toUpperCase();
			notepadArea.setText(temp1+conv+temp2);
			notepadArea.select(start,end);
		}
		catch(Exception e)
		{
		}
	}

	public void str2lwr()
	{
		try
		{
			int start=notepadArea.getSelectionStart();
			int end=notepadArea.getSelectionEnd();
			String temp1=notepadArea.getText().substring(0,start);
			String temp2=notepadArea.getText().substring(end);
			String conv=notepadArea.getSelectedText().toLowerCase();
			notepadArea.setText(temp1+conv+temp2);
			notepadArea.select(start,end);
		}
		catch(Exception e)
		{
		}
	}

	public void help_about()
	{
		abt.window.setVisible(true);
	}
	
	public void setCommunicationSocket(Socket sock)
	{
		communicationSocket=sock;
		communicationContinue=true;
		disconnectItem.setEnabled(true);
	}
	
	public void setOutStream(PrintWriter out)
	{
		outStream=out;
	}
	
	public void setInStream(BufferedReader in)
	{
		inStream=in;
	}
	
	public void setUpServer()
	{
		ServerThread st=new ServerThread(this);
		st.start();
	}
	
	public void setUpClient()
	{
		ClientThread st=new ClientThread(this);
		st.start();
	}
	
	public void disconnectClientServer(Boolean sendMessage)
	{
		if(communicationSocket==null)
		{
			return;
		}
		
		try
		{
			communicationContinue=false;
			disconnectItem.setEnabled(false);
			
			if(sendMessage==true)
			{
				outStream.println(disconnectString);
			}
			
			Thread t=Thread.currentThread();
			
			try
			{
				t.sleep(500);
			}catch(Exception e){return;}
			
			outStream.close();
			inStream.close();
			communicationSocket.close();
		}catch(Exception e){JOptionPane.showMessageDialog(notepad.this,"Disconnection Failed","NotepadMessenger",JOptionPane.PLAIN_MESSAGE);return;}
		
		finally
		{
			communicationSocket=null;
		}
	}
	
	public void sendData()
	{
		
		if(communicationSocket!=null)
		{
			data=displayLabel.getText();
			outStream.println(data);
			displayLabel.setText("");
			ta.append(data+"\n");
		}
		
	}
	
	public void getData()
	{
		String inputLine;
		String msg;
		try
		{
			while(communicationContinue==true)
			{
				communicationSocket.setSoTimeout(100);
				
				try
				{
					while(((inputLine=inStream.readLine())!=null))
					{
						System.out.println("From socket: "+inputLine);
							
						if(inputLine.equals(disconnectString))
						{
							disconnectClientServer(false);
							return;
						}						
						displayLabel.setText("");
						msg=inputLine;
						ta.append(inputLine+"\n");						
					}					
				}catch(Exception e){}
			}		
			
			System.out.println("Communication is false");		
		}catch(Exception e){JOptionPane.showMessageDialog(notepad.this,"Input Stream Read Failed","NotepadMessenger",JOptionPane.PLAIN_MESSAGE);return;}
	}	
}