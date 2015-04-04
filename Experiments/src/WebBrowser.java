import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

public class WebBrowser
{
     public static void main(String [] args)
     {
          JFrame frame = new EditorPaneFrame();
          frame.show();
     }
}
class EditorPaneFrame extends JFrame
{

     private JTextField url;
     private JCheckBox editable;
     private JButton loadButton;
     private JButton backButton;
     private JEditorPane editorPane;
     private Stack urlStack = new Stack();


     public EditorPaneFrame()
     {
          setTitle("Java Web Browser");
          setSize(600,400);
          addWindowListener(new WindowAdapter()
          {
               public void windowClosing(WindowEvent e)
               {
                    System.exit(0);
               }
          } );

          // set up text field and load button for typing in URL

          url = new JTextField(30);

          loadButton = new JButton("Load");
          loadButton.addActionListener(new ActionListener()
          {
               public void actionPerformed(ActionEvent event)
               {
                    try
                    {
                         // remember URL for back button
                         urlStack.push(url.getText());
                         editorPane.setPage(url.getText());
                    }
                    catch(Exception e)
                    {
                         editorPane.setText("Error: " +e);
                    }
               }
          });

          // set up back button and button action

          backButton = new JButton("Back");
          backButton.addActionListener(new ActionListener()
          {
               public void actionPerformed(ActionEvent event)
               {
                    if(urlStack.size()<=1)
		    return;
                    try
                    {
                         urlStack.pop();
                         String urlString = (String)urlStack.peek();
                         url.setText(urlString);
                         editorPane.setPage(urlString);
                    }
                    catch(IOException e)
                    {
                         editorPane.setText("Error : " +e);
                    }
               }
          });

          editorPane = new JEditorPane();
          editorPane.setEditable(false);
          editorPane.addHyperlinkListener(new HyperlinkListener()
          {
               public void hyperlinkUpdate(HyperlinkEvent event)
               {
                    if(event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
                    {
                         try
                         {
                              urlStack.push(event.getURL().toString());
                              url.setText(event.getURL().toString());

                              editorPane.setPage(event.getURL());
                         }
                         catch(IOException e)
                         {
                              editorPane.setText("Error: " + e);
                         }
                    }
               }
          });

          editable = new JCheckBox();
          editable.addActionListener(new ActionListener()
          {
               public void actionPerformed(ActionEvent event)
               {
                    editorPane.setEditable(editable.isSelected());
               }
          });

          Container contentPane = getContentPane();
          contentPane.add(new JScrollPane(editorPane), "Center");

          JPanel panel = new JPanel();
          panel.add(new JLabel("URL"));
          panel.add(url);
          panel.add(loadButton);
          panel.add(backButton);
          panel.add(new JLabel("Editable"));
          panel.add(editable);

          contentPane.add(panel,"South");
     }

}
