package searchtextcomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

public class IncrementalSearch implements DocumentListener,ActionListener
{
    protected JTextComponent content;
    protected Matcher matcher;

    public IncrementalSearch(JTextComponent comp)
    {
        this.content = comp;
    }

    public void insertUpdate(DocumentEvent e) {
        runNewSearch(e.getDocument());
    }

    public void removeUpdate(DocumentEvent e) {
        runNewSearch(e.getDocument());
    }

    public void changedUpdate(DocumentEvent e) {
        runNewSearch(e.getDocument());
    }

    public void actionPerformed(ActionEvent e) {
        continueSearch();
    }

    private void runNewSearch(Document query_doc)
    {
        try
        {
            String query = query_doc.getText(0,query_doc.getLength());

            Pattern pattern = Pattern.compile(query);
            Document content_doc = content.getDocument();
            String body = content_doc.getText(0,content_doc.getLength());
            matcher = pattern.matcher(body);
            continueSearch();
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    private void continueSearch()
    {
        if(matcher!=null)
        {
            if(matcher.find())
            {
                content.getCaret().setDot(matcher.start());
                content.getCaret().moveDot(matcher.end());
                content.getCaret().setSelectionVisible(true);
            }
        }
    }

}
