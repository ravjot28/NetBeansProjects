package support;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class DateChooser extends JDialog implements ActionListener {

  public static final int OK_OPTION = 1;
  public static final int CANCEL_OPTION = 2;

  private static final ArrayList monthNames;
  static {
    monthNames = new ArrayList(12);
    monthNames.add("January");
    monthNames.add("February");
    monthNames.add("March");
    monthNames.add("April");
    monthNames.add("May");
    monthNames.add("June");
    monthNames.add("July");
    monthNames.add("August");
    monthNames.add("September");
    monthNames.add("October ");
    monthNames.add("November");
    monthNames.add("December");
  };

  private GregorianCalendar date;
  private JLabel monthLabel;
  private JLabel yearLabel;
  private JPanel dayGrid;
  private boolean ready;

  public DateChooser (JFrame owner, GregorianCalendar d) {
    super(owner, "Date Chooser", true);
    date = d;

    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());

    JPanel yearPane = new JPanel();
    JPanel monthPane = new JPanel();
    yearPane.setLayout(new BoxLayout(yearPane, BoxLayout.X_AXIS));
    monthPane.setLayout(new BoxLayout(monthPane, BoxLayout.X_AXIS));

    JButton[] navButton = new JButton[4];

    // build the panel with month name and navigation buttons
    monthPane.add(navButton[0] = new JButton("<"));
    monthPane.add(monthLabel =
        new JLabel(String.valueOf(monthNames.get(
        date.get(GregorianCalendar.MONTH))), JLabel.CENTER));
    monthLabel.setMinimumSize(new Dimension(80, 17));
    monthLabel.setMaximumSize(new Dimension(80, 17));
    monthLabel.setPreferredSize(new Dimension(80, 17));
    monthPane.add(navButton[1] = new JButton(">"));

    // build the panel with year and navigation buttons
    yearPane.add(navButton[2] = new JButton("<<"));
    yearPane.add(yearLabel =
        new JLabel(String.valueOf(
        date.get(GregorianCalendar.YEAR)),
        JLabel.CENTER), BorderLayout.CENTER);
    yearLabel.setMinimumSize(new Dimension(50, 17));
    yearLabel.setMaximumSize(new Dimension(50, 17));
    yearLabel.setPreferredSize(new Dimension(50, 17));
    yearPane.add(navButton[3] = new JButton(">>"));

    // register a listener on the navigation buttons
    for (int i=0; i<4; i++) {
      navButton[i].addActionListener(this);
    }

    // set the tool tip text on the navigation buttons
    navButton[0].setToolTipText("Go to the previous month");
    navButton[1].setToolTipText("Go to tne next month");
    navButton[2].setToolTipText("Go to the previous year");
    navButton[3].setToolTipText("Go to the next year");

    // put the panel for months and years together and add some formatting
    JPanel topPane = new JPanel();
    topPane.setLayout(new BoxLayout(topPane, BoxLayout.X_AXIS));
    topPane.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));
    topPane.add(monthPane);
    topPane.add(Box.createRigidArea(new Dimension(20, 0)));
    topPane.add(yearPane);

    // create the panel that will hold the days of the months
    dayGrid = new JPanel(new GridLayout(7, 7));
    updateDayGrid();

    contentPane.add(topPane, BorderLayout.NORTH);
    contentPane.add(dayGrid, BorderLayout.CENTER);

    setResizable(false);
    ready = false;
    pack();

    // center this dialog over the owner
    int xPos = (int) (owner.getLocation().getX() +
      (owner.getWidth() / 2) - (getWidth() / 2));
    int yPos =  (int) (owner.getLocation().getY() +
      (owner.getHeight() / 2) - (getHeight() / 2));
    setLocation(xPos, yPos);
  }
  
  public GregorianCalendar getDate () {
    return date;
  }


  
  public int showDateChooser () {
    ready = false;
    setVisible(true);
    if (ready) {
      return(OK_OPTION);
    }
    else {
      return(CANCEL_OPTION);
    }
  }

  public void actionPerformed (ActionEvent evt) {
    String label = ((JButton) evt.getSource()).getText();

    if (label.equals("<")) {
      int m = monthNames.indexOf(monthLabel.getText());
      m = prevMonth(m);
      monthLabel.setText((String) monthNames.get(m));
      updateDayGrid();
    }
    else if (label.equals(">")) {
      int m = monthNames.indexOf(monthLabel.getText());
      m = nextMonth(m);
      monthLabel.setText((String) monthNames.get(m));
      updateDayGrid();
    }
    else if (label.equals("<<")) {
      int y = 0;
      try {
        y = Integer.parseInt(yearLabel.getText());
      }
      catch (NumberFormatException e) {
        System.err.println(e.toString());
      }
      yearLabel.setText(String.valueOf(--y));
      updateDayGrid();
    }
    else if (label.equals(">>")) {
      int y = 0;
      try {
        y = Integer.parseInt(yearLabel.getText());
      }
      catch (NumberFormatException e) {
        System.err.println(e.toString());
      }
      yearLabel.setText(String.valueOf(++y));
      updateDayGrid();
    }
    else {
      int m = monthNames.indexOf(monthLabel.getText());
      int y = 0;
      int d = 0;
      try {
        y = Integer.parseInt(yearLabel.getText());
        d = Integer.parseInt(label);
      }
      catch (NumberFormatException e) {
        System.err.println(e.toString());
      }
      date = new GregorianCalendar(y, m, d);
      date.setLenient(false);
      ready = true;
      dispose();
    }
  }
  
  private void updateDayGrid () {
    dayGrid.removeAll();

    // get the currently selected month and year
    int m = monthNames.indexOf(monthLabel.getText());
    int y = 0;
    try {
      y = Integer.parseInt(yearLabel.getText());
    }
    catch (NumberFormatException e) {
      System.err.println(e.toString());
    }

    // look at the first day of the month for this month
    GregorianCalendar temp = new GregorianCalendar(y, m, 1);
    temp.setLenient(false);
    int offset = 0;

    // decide what day of the week is the first day of this month
    switch(temp.get(GregorianCalendar.DAY_OF_WEEK)) {
      case GregorianCalendar.MONDAY  : offset = 0; break;
      case GregorianCalendar.TUESDAY   : offset = 1; break;
      case GregorianCalendar.WEDNESDAY : offset = 2; break;
      case GregorianCalendar.THURSDAY  : offset = 3; break;
      case GregorianCalendar.FRIDAY  : offset = 4; break;
      case GregorianCalendar.SATURDAY  : offset = 5; break;
      case GregorianCalendar.SUNDAY  : offset = 6; break;
    }

    // display 7 days of the week across the top
    dayGrid.add(new JLabel("Mon", JLabel.CENTER));
    dayGrid.add(new JLabel("Tue", JLabel.CENTER));
    dayGrid.add(new JLabel("Wed", JLabel.CENTER));
    dayGrid.add(new JLabel("Thu", JLabel.CENTER));
    dayGrid.add(new JLabel("Fri", JLabel.CENTER));
    dayGrid.add(new JLabel("Sat", JLabel.CENTER));
    dayGrid.add(new JLabel("Sun", JLabel.CENTER));

    // skip to the correct first day of the week for this month
    for (int i=1; i<=offset; i++) {
      dayGrid.add(new JLabel(""));
    }

    // display days of the month for this month
    JButton day;
    for (int i=1; i<=getLastDay(); i++) {
      dayGrid.add(day = new JButton(String.valueOf(i)));
      day.setToolTipText("Click on a day to choose it");
      day.addActionListener(this);

      // show the current day in bright red.
      if (i == date.get(Calendar.DATE) &&
        m == date.get(Calendar.MONTH) &&
        y == date.get(Calendar.YEAR)) {
          day.setForeground(Color.red);
      }
    }

    // display the remaining empty slots to preserve the structure
    for (int i=(offset+getLastDay()+1); i<=42; i++) {
      dayGrid.add(new JLabel(""));
    }

    repaint();
    validate();
  }
  
  private int nextMonth (int month) {
    if (month == 11) {
      return(0);
    }
    return(++month);
  }
  
  private int prevMonth (int month) {
    if (month == 0) {
      return(11);
    }
    return(--month);
  }
  
  private int getLastDay () {
    int m = (monthNames.indexOf(monthLabel.getText()) + 1);
    int y = 0;
    try {
      y = Integer.parseInt(yearLabel.getText());
    }
    catch (NumberFormatException e) {
      System.err.println(e.toString());
    }

    if ((m==4) || (m==6) || (m==9) || (m==11)) {
      return(30);
    }
    else if (m==2) {
      if (date.isLeapYear(y)) {
        return(29);
      }
      return(28);
    }
    return(31);
  }
}