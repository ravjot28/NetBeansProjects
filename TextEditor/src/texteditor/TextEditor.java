package texteditor;

import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import javax.swing.undo.*;
import java.util.Hashtable;
class UndoableTextArea extends TextArea implements StateEditable
 {
  private final static String KEY_STATE="UndoableTextAreaKey";
  private boolean textChanged=false;
  private UndoManager undoManager;
  private StateEdit currentEdit;

  public UndoableTextArea()
     {
      super();
      initUndoable();
     }
  public UndoableTextArea(String string)
      {
       super(string);
       initUndoable();
      }
  public UndoableTextArea(int rows,int columns)
      {
       super(rows,columns);
       initUndoable();
      }
  public UndoableTextArea(String string,int rows,int columns)
         {
          super(string,rows,columns);
          initUndoable();
         }
  public UndoableTextArea(String string,int rows,int columns,int
scrollbars)
      {
       super(string,rows,columns,scrollbars);
       initUndoable();
      }

   public boolean undo(){
    try{
        undoManager.undo();
        return true;
       }
     catch(CannotUndoException e)
        {
        System.out.println("cannot undo");
        return false;
        }
     }
    public boolean redo()
       {
       try{
         undoManager.redo();
         return true;
         }
      catch(CannotRedoException e)
          {
            System.out.println("cannot redo");
            return false;
         }
       }


    public void storeState(Hashtable state)
       {
        state.put(KEY_STATE,getText());
       }

    public void restoreState(Hashtable state)
        {
         Object data=state.get(KEY_STATE);
         if(data!=null){
          setText((String)data);
          }
        }

   private void takeSnapshot()
       {
        if(textChanged)
        {
         currentEdit.end();
         undoManager.addEdit(currentEdit);
         textChanged=false;
         currentEdit=new StateEdit(this);
         }
        }

     private void initUndoable()
       {
         undoManager =new UndoManager();
         currentEdit=new StateEdit(this);
         addKeyListener(new KeyAdapter(){
          public void keyPressed(KeyEvent event){
          if(event.isActionKey()){
          takeSnapshot();
          }
         }
        });

          addFocusListener(new FocusAdapter(){
         public void focusLost(FocusEvent fe){
          takeSnapshot();
          }
          });

         addTextListener(new TextListener(){
         public void textValueChanged(TextEvent e){
         textChanged=true;
         takeSnapshot();
         }
         });

      }
   }


public class TextEditor extends Frame
{
        boolean b=true;
        Frame fm;
         FileDialog fd;
         Font f;
         int style=Font.PLAIN;
         int fsize=12;
         UndoableTextArea txt;
         String filename,st,fn="untitled",dn;
         Clipboard clip=getToolkit().getSystemClipboard();
         TextEditor()
         {
                 f=new Font("Courier",style,fsize);
                 setLayout(new GridLayout(1,1));
                 txt=new UndoableTextArea(80,25);

                 txt.setFont(f);
                 add(txt);
                 MenuBar mb=new MenuBar();
                 Menu fonttype=new Menu("FontType");
                 MenuItem one,two,three,four,five,six;
                 one=new MenuItem("TimesRoman");
                 two=new MenuItem("Helvetica");
                 three=new MenuItem("Courier");
                 four=new MenuItem("Arial");
                 five=new MenuItem("Arial Black");
                 six=new MenuItem("Century");

                 fonttype.add(one);
                 fonttype.add(two);
                 fonttype.add(three);
                 fonttype.add(four);
                 fonttype.add(five);
                 fonttype.add(six);
                 one.addActionListener(new Type());
                 two.addActionListener(new Type());
                 three.addActionListener(new Type());
                 four.addActionListener(new Type());
                 five.addActionListener(new Type());
                 six.addActionListener(new Type());

                 Menu fontmenu=new Menu("Font");
                 MenuItem boldmenu=new MenuItem("Bold");
                 MenuItem plainmenu=new MenuItem("Plain");
                 MenuItem italicmenu=new MenuItem("Italic");
                 fontmenu.add(boldmenu);
                 fontmenu.add(plainmenu);
                 fontmenu.add(italicmenu);
                 boldmenu.addActionListener(new FM());
                 plainmenu.addActionListener(new FM());
                 italicmenu.addActionListener(new FM());
                 Menu size=new Menu("Size");
                 MenuItem s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
                 s1=new MenuItem("10");
                 s2=new MenuItem("12");
                 s3=new MenuItem("14");
                 s4=new MenuItem("16");
                 s5=new MenuItem("18");
                 s6=new MenuItem("20");
                 s7=new MenuItem("22");
                 s8=new MenuItem("24");
                 s9=new MenuItem("26");
                 s10=new MenuItem("28");
                 size.add(s1);
                 size.add(s2);
                 size.add(s3);
                 size.add(s4);
                 size.add(s5);
                 size.add(s6);
                 size.add(s7);
                 size.add(s8);
                 size.add(s9);
                 size.add(s10);

                 s1.addActionListener(new Size());
                 s2.addActionListener(new Size());
                 s3.addActionListener(new Size());
                 s4.addActionListener(new Size());
                 s5.addActionListener(new Size());
                 s6.addActionListener(new Size());
                 s7.addActionListener(new Size());
                 s8.addActionListener(new Size());
                 s9.addActionListener(new Size());
                 s10.addActionListener(new Size());
                 size.addActionListener(new FM());
                 fontmenu.add(size);
                 Menu file=new Menu("File");
                 MenuItem n=new MenuItem("New",new
MenuShortcut(KeyEvent.VK_N));
                 MenuItem o=new MenuItem("Open",new
MenuShortcut(KeyEvent.VK_O));
                 MenuItem s=new MenuItem("Save",new
MenuShortcut(KeyEvent.VK_S));
                 MenuItem e=new MenuItem("Exit",new
MenuShortcut(KeyEvent.VK_E));
                 n.addActionListener(new New());
                 file.add(n);
                 o.addActionListener(new Open());
                 file.add(o);
                 s.addActionListener(new Save());
                 file.add(s);
                 e.addActionListener(new Exit());
                 file.add(e);
                 mb.add(file);
                 addWindowListener(new Win());
                 Menu edit=new Menu("Edit");
                 MenuItem cut=new MenuItem("Cut",new
MenuShortcut(KeyEvent.VK_X));
                 MenuItem copy=new MenuItem("Copy",new
MenuShortcut(KeyEvent.VK_C));
                 MenuItem paste=new MenuItem("Paste",new
MenuShortcut(KeyEvent.VK_V));
                 cut.addActionListener(new Cut());
                 edit.add(cut);
                 copy.addActionListener(new Copy());
                 edit.add(copy);
                 paste.addActionListener(new Paste());
                 edit.add(paste);
                 Menu color =new Menu("Color");
                 MenuItem Bg=new MenuItem("Background");
                 MenuItem Fg=new MenuItem("Foreground");
                 Bg.addActionListener(new BC());
                 Fg.addActionListener(new BC());
                 Menu undo=new Menu("Undo&Redo");
             MenuItem un=new MenuItem("Undo");
             MenuItem re=new MenuItem("Redo");
             re.addActionListener(new WW());
             un.addActionListener(new WW());
             undo.add(un);
             undo.add(re);
                 color.add(Bg);
                 color.add(Fg);
                 mb.add(edit);
                 mb.add(fontmenu);
                 mb.add(fonttype);
             mb.add(color);
             mb.add(undo);
                 setMenuBar(mb);


                 mylistener mylist=new mylistener();
                 addWindowListener(mylist);
         }

     class WW implements ActionListener
          {
            public void actionPerformed(ActionEvent e)
            {
              String se=e.getActionCommand();
              if(se.equals("Undo"))
              txt.undo();
            if(se.equals("Redo"))
            txt.redo();

            }
        }
 class mylistener extends WindowAdapter
         {
         public void windowClosing(WindowEvent we)
                 {
                   if(!b)
                 System.exit(0);
                 }
         }
 class New implements ActionListener
        {
        public void actionPerformed(ActionEvent ae)
                  {
                  txt.setText(" ");
                  setTitle(filename);
                  fn="Untitled";
                  }
         }
 class Open implements ActionListener
         {
                  public void actionPerformed(ActionEvent ae)
                  {
                   FileDialog fd=new FileDialog(TextEditor.this,"Select File",FileDialog.LOAD);
                   fd.show();
                   if((fn=fd.getFile())!=null)
                    {
                    filename=fd.getDirectory()+fd.getFile();
                    dn=fd.getDirectory();
                    setTitle(filename);
                    readFile();
                    }
                    txt.requestFocus();
                  }
         }


 class Save implements ActionListener
          {
                  public void actionPerformed(ActionEvent ae)
                  {
                    FileDialog fd=new FileDialog(TextEditor.this,"Save File",FileDialog.SAVE);
                    fd.setFile(fn);
                    fd.setDirectory(dn);
                    fd.show();

                   if(fd.getFile()!=null)
                    {
                     filename=fd.getDirectory()+fd.getFile();
                     setTitle(filename);
                     writeFile();
                  txt.requestFocus();
                    }
              }
         }

  class Exit implements ActionListener
          {
                  public void actionPerformed(ActionEvent ae)
                  {
                   System.exit(0);
                  }
          }
  void readFile()
          {
                  BufferedReader d;
                  StringBuffer sb=new StringBuffer();
                  try{
                      d=new BufferedReader(new FileReader(filename));
                      String line;
                      while((line=d.readLine())!=null)
                       sb.append(line+" ");
                       txt.setText(sb.toString());
                       d.close();
                       }catch(FileNotFoundException e){
                         System.out.println("File not found");
                       }catch(IOException e){ }
          }

public void writeFile()
            {
             try{
                 DataOutputStream d=new DataOutputStream(new
FileOutputStream(filename));
                 String line=txt.getText();
                 BufferedReader br=new BufferedReader(new
StringReader(line));
                 while((line=br.readLine())!=null)
                    {
                     d.writeBytes(line+" ");
                    }d.close();
                 }catch(Exception e){
                   System.out.println("File not found");
                   }
          }
 class Cut implements ActionListener
         {
          public void actionPerformed(ActionEvent ae)
                  {
                   String sel=txt.getSelectedText();
                   StringSelection ss=new StringSelection(sel);
                   clip.setContents(ss,ss);
                   txt.replaceRange(" ",txt.getSelectionStart(),txt.getSelectionEnd());
                  }
         }
 class Copy implements ActionListener
         {
          public void actionPerformed(ActionEvent ae)
                  {
                   String sel=txt.getSelectedText();
                   StringSelection clipstring=new StringSelection(sel);
                   clip.setContents(clipstring,clipstring);
                  }
         }
 class Paste implements ActionListener
         {
          public void actionPerformed(ActionEvent ae)
                  {
                   Transferable
cliptran=clip.getContents(TextEditor.this);
                   try{
                   String
sel=(String)cliptran.getTransferData(DataFlavor.stringFlavor);

txt.replaceRange(sel,txt.getSelectionStart(),txt.getSelectionEnd());
                  }catch(Exception e){
                    System.out.println("not starting flavor");
                  }
                 }
         }
 class Win extends WindowAdapter
        {
         public void windowClosing(WindowEvent we)
                 {

               ConfirmDialog cd=new ConfirmDialog();
               if(!b)
               {
                System.exit(0);
               }
                 }
         }



 class ConfirmDialog extends JPanel
   {
     public ConfirmDialog()
       {
          int result;
          result=JOptionPane.showConfirmDialog(this,fn+" not saved do you want to save"/*,"Message Box",JOptionPane.QUESTION_MESSAGE*/);
           switch(result)
           {
           case JOptionPane.YES_OPTION:
                        FileDialog fd=new FileDialog(TextEditor.this,"Save File",FileDialog.SAVE);
               fd.setFile(fn);
               fd.setDirectory(dn);
               fd.show();
               if(fd.getFile()!=null)
                {
                 filename=fd.getDirectory()+fd.getFile();
                 setTitle(filename);
                 writeFile();
                 txt.requestFocus();
                }
               System.out.println("Yes button pressed");
               break;
           case JOptionPane.NO_OPTION:
                dispose();
            System.exit(0);
            System.out.println("NO button pressed");
              break;
           case JOptionPane.CANCEL_OPTION:
              setVisible(true);
            //b=false;
            repaint();
               System.out.println("Cancel button pressed");
               break;
          case JOptionPane.CLOSED_OPTION:
              System.out.println("Closed button pressed");
              break;
         }
      }
  }

 class Size implements ActionListener
 {
     public void actionPerformed(ActionEvent e)
         {
            int style=f.getStyle();
          String w=e.getActionCommand();
          if(w=="10")
           {
                f= new Font("Courier",style,10);
                txt.setFont(f);
                fsize=f.getSize();
                repaint();
           }
          if(w=="12")
           {
                 f= new Font("Courier",style,12);
                 fsize=f.getSize();
                 txt.setFont(f);
                 repaint();
           }
          if(w=="14")
           {
                 f= new Font("Courier",style,14);
                 fsize=f.getSize();
                 txt.setFont(f);
                 repaint();
           }
          if(w=="16")
           {
                f= new Font("Courier",style,16);
                txt. setFont(f);
                fsize=f.getSize();
                repaint();
           }
          if(w=="18")
            {
                 f= new Font("Courier",style,18);
                 txt.setFont(f);
                 fsize=f.getSize();
                 repaint();
            }
          if(w=="20")
            {
                 f= new Font("Courier",style,20);
                 txt.setFont(f);
                 fsize=f.getSize();
                 repaint();
            }
          if(w=="22")
            {
                 f= new Font("Courier",style,22);
                 txt.setFont(f);
                 fsize=f.getSize();
                 repaint();
            }
          if(w=="24")
            {
                 f= new Font("Courier",style,24);
                 txt.setFont(f);
                 fsize=f.getSize();
                 repaint();
            }
          if(w=="26")
            {
                 f= new Font("Courier",style,26);
                 txt.setFont(f);
                 fsize=f.getSize();
                 repaint();
            }

          if(w=="28")
            {
                 f= new Font("Courier",style,28);
                 txt.setFont(f);
                 fsize=f.getSize();
                 repaint();
            }


         }
 }
 class FM  extends Applet implements ActionListener
  {
       public void actionPerformed(ActionEvent e)
         {
              String b=e.getActionCommand();
               if(b=="Bold")
               {
                  f= new Font("Courier",Font.BOLD,fsize);
                 style=f.getStyle();
                 txt.setFont(f);
               }
              if(b=="Plain")
               {
                  f= new Font("Courier",Font.PLAIN,fsize);
                 style=f.getStyle();
                 txt.setFont(f);
               }

              if(b=="Italic")
               {
                 f= new Font("Courier",Font.ITALIC,fsize);
                txt.setFont(f);
               }
               repaint();
         }
  }

 class Type implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
      String lbl=e.getActionCommand();
      if(lbl=="TimesRoman")
       {
        f=new Font("TimesRoman",style,fsize);
        txt.setFont(f);
       }
      if(lbl=="Courier")
       {
        f=new Font("Courier",style,fsize);
        txt.setFont(f);
       }
      if(lbl=="Helvetica")
       {
        f=new Font("Helvetica",style,fsize);
        txt.setFont(f);
       }
      if(lbl=="Arial")
       {
        f=new Font("Arial",style,fsize);
        txt.setFont(f);
       }
      if(lbl=="Arial Black")
       {
        f=new Font("ArialBlack",style,fsize);
        txt.setFont(f);
       }
      if(lbl=="Century")
       {
        f=new Font("Century",style,fsize);
        txt.setFont(f);
       }

      repaint();
    }
  }


   class BC implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
            {
                st=e.getActionCommand();
                JFrame jf=new JFrame("JColorChooser");
                 colorChooser c=new colorChooser();
                 c.setSize(400,300);
                   c.setVisible(true);
            }
      }


    class colorChooser extends JFrame
      {
             Button ok;
             JColorChooser jcc;
             public colorChooser(){
             setTitle("JColorChooser");
             jcc=new JColorChooser();
             JPanel content=(JPanel)getContentPane();
             content.setLayout(new BorderLayout());
             content.add(jcc,"Center");
             ok=new Button("OK");
             content.add(ok,"South");
             ok.addActionListener(new B());
       }

    class B implements ActionListener
       {
         public void actionPerformed(ActionEvent e)
         {
         System.out.println("Color Is:"+jcc.getColor().toString());
         if(st.equals("Background"))
         txt.setBackground(jcc.getColor());
         if(st.equals("Foreground"))
         txt.setForeground(jcc.getColor());
         setVisible(false);
           }
      }
}

 public static void main(String args[])
         {
                 Frame fm=new TextEditor();
                 fm.setSize(800,600);
                 fm.setVisible(true);
                 fm.show();
         }
 }




