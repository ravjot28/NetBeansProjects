
/**
 *
 * @author Rav
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class MultiSpanCellTableMain extends JFrame {

    MultiSpanCellTableMain(String[][] cabinetInfo) {


        super("Multi-Span Cell Example");

        int tRows = 0;
        for (String[] totalRows : cabinetInfo) {
            int a = Integer.parseInt(totalRows[1]);
            tRows = tRows + a;
        }
        System.out.println(tRows);
        AttributiveCellTableModel ml = new AttributiveCellTableModel(tRows, 6);

        final CellSpan cellAtt = (CellSpan) ml.getCellAttribute();
        final MultiSpanCellTable table = new MultiSpanCellTable(ml);
        JScrollPane scroll = new JScrollPane(table);
        int start = 0;
        int cabins = 0;
        for (String[] cabinets : cabinetInfo) {
            int products = Integer.parseInt(cabinets[1]);
            int end = start + products - 1;
            int[] columns = {0};
            System.out.println(cabinets[0] + " " + cabinets[1]);
            //System.out.println(start + " " + end);
            int[] rows = new int[end - start + 1];
            int i = 0;
            for (int i1 = start; i1 <= end; i1++) {
                rows[i] = i1;
                i++;
            }
            cellAtt.combine(rows, columns);
            ml.setValueAt(cabinets[0], start, 0);
            System.out.println(start);
            cabins++;
            start = end + 1;
            table.clearSelection();
            table.revalidate();
            table.repaint();
        }

        Box box = new Box(BoxLayout.X_AXIS);
        box.add(scroll);
        getContentPane().add(box);
        setSize(400, 200);
        setVisible(true);
    }
}

class AttributiveCellTableModel extends DefaultTableModel {

    protected CellAttribute cellAtt;

    public AttributiveCellTableModel() {
        this((Vector) null, 0);
    }

    public AttributiveCellTableModel(int numRows, int numColumns) {
        Vector names = new Vector(numColumns);
        names.setSize(numColumns);
        setColumnIdentifiers(names);
        dataVector = new Vector();
        setNumRows(numRows);
        cellAtt = new DefaultCellAttribute(numRows, numColumns);
    }

    public AttributiveCellTableModel(Vector columnNames, int numRows) {
        setColumnIdentifiers(columnNames);
        dataVector = new Vector();
        setNumRows(numRows);
        cellAtt = new DefaultCellAttribute(numRows, columnNames.size());
    }

    public AttributiveCellTableModel(Object[] columnNames, int numRows) {
        this(convertToVector(columnNames), numRows);
    }

    public AttributiveCellTableModel(Vector data, Vector columnNames) {
        setDataVector(data, columnNames);
    }

    public AttributiveCellTableModel(Object[][] data, Object[] columnNames) {
        setDataVector(data, columnNames);
    }

    public void setDataVector(Vector newData, Vector columnNames) {
        if (newData == null) {
            throw new IllegalArgumentException("setDataVector() - Null parameter");
        }
        dataVector = new Vector(0);
        columnIdentifiers = columnNames;//setColumnIdentifiers(columnNames);
        dataVector = newData;

        cellAtt = new DefaultCellAttribute(dataVector.size(),
                columnIdentifiers.size());

        newRowsAdded(new TableModelEvent(this, 0, getRowCount() - 1,
                TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
    }

    public void addColumn(Object columnName, Vector columnData) {
        if (columnName == null) {
            throw new IllegalArgumentException("addColumn() - null parameter");
        }
        columnIdentifiers.addElement(columnName);
        int index = 0;
        Enumeration eeration = dataVector.elements();
        while (eeration.hasMoreElements()) {
            Object value;
            if ((columnData != null) && (index < columnData.size())) {
                value = columnData.elementAt(index);
            } else {
                value = null;
            }
            ((Vector) eeration.nextElement()).addElement(value);
            index++;
        }

        cellAtt.addColumn();

        fireTableStructureChanged();
    }

    public void addRow(Vector rowData) {
        Vector newData = null;
        if (rowData == null) {
            newData = new Vector(getColumnCount());
        } else {
            rowData.setSize(getColumnCount());
        }
        dataVector.addElement(newData);

        cellAtt.addRow();

        newRowsAdded(new TableModelEvent(this, getRowCount() - 1, getRowCount() - 1,
                TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
    }

    public void insertRow(int row, Vector rowData) {
        if (rowData == null) {
            rowData = new Vector(getColumnCount());
        } else {
            rowData.setSize(getColumnCount());
        }

        dataVector.insertElementAt(rowData, row);

        cellAtt.insertRow(row);

        newRowsAdded(new TableModelEvent(this, row, row,
                TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
    }

    public CellAttribute getCellAttribute() {
        return cellAtt;
    }

    public void setCellAttribute(CellAttribute newCellAtt) {
        int numColumns = getColumnCount();
        int numRows = getRowCount();
        if ((newCellAtt.getSize().width != numColumns)
                || (newCellAtt.getSize().height != numRows)) {
            newCellAtt.setSize(new Dimension(numRows, numColumns));
        }
        cellAtt = newCellAtt;
        fireTableDataChanged();
    }
}

class DefaultCellAttribute
        implements CellAttribute, CellSpan, ColoredCell, CellFont {

    protected int rowSize;
    protected int columnSize;
    protected int[][][] span;
    protected Color[][] foreground;
    protected Color[][] background;
    protected Font[][] font;

    public DefaultCellAttribute() {
        this(1, 1);
    }

    public DefaultCellAttribute(int numRows, int numColumns) {
        setSize(new Dimension(numColumns, numRows));
    }

    protected void initValue() {
        for (int i = 0; i < span.length; i++) {
            for (int j = 0; j < span[i].length; j++) {
                span[i][j][CellSpan.COLUMN] = 1;
                span[i][j][CellSpan.ROW] = 1;
            }
        }
    }

    public int[] getSpan(int row, int column) {
        if (isOutOfBounds(row, column)) {
            int[] ret_code = {1, 1};
            return ret_code;
        }
        return span[row][column];
    }

    public void setSpan(int[] span, int row, int column) {
        if (isOutOfBounds(row, column)) {
            return;
        }
        this.span[row][column] = span;
    }

    public boolean isVisible(int row, int column) {
        if (isOutOfBounds(row, column)) {
            return false;
        }
        if ((span[row][column][CellSpan.COLUMN] < 1)
                || (span[row][column][CellSpan.ROW] < 1)) {
            return false;
        }
        return true;
    }

    public void combine(int[] rows, int[] columns) {
        if (isOutOfBounds(rows, columns)) {
            return;
        }
        int rowSpan = rows.length;
        int columnSpan = columns.length;
        int startRow = rows[0];
        int startColumn = columns[0];
        for (int i = 0; i < rowSpan; i++) {
            for (int j = 0; j < columnSpan; j++) {
                if ((span[startRow + i][startColumn + j][CellSpan.COLUMN] != 1)
                        || (span[startRow + i][startColumn + j][CellSpan.ROW] != 1)) {
                    //System.out.println("can't combine");
                    return;
                }
            }
        }
        for (int i = 0, ii = 0; i < rowSpan; i++, ii--) {
            for (int j = 0, jj = 0; j < columnSpan; j++, jj--) {
                span[startRow + i][startColumn + j][CellSpan.COLUMN] = jj;
                span[startRow + i][startColumn + j][CellSpan.ROW] = ii;
            }
        }
        span[startRow][startColumn][CellSpan.COLUMN] = columnSpan;
        span[startRow][startColumn][CellSpan.ROW] = rowSpan;

    }

    public Color getForeground(int row, int column) {
        if (isOutOfBounds(row, column)) {
            return null;
        }
        return foreground[row][column];
    }

    public void setForeground(Color color, int row, int column) {
        if (isOutOfBounds(row, column)) {
            return;
        }
        foreground[row][column] = color;
    }

    public void setForeground(Color color, int[] rows, int[] columns) {
        if (isOutOfBounds(rows, columns)) {
            return;
        }
        setValues(foreground, color, rows, columns);
    }

    public Color getBackground(int row, int column) {
        if (isOutOfBounds(row, column)) {
            return null;
        }
        return background[row][column];
    }

    public void setBackground(Color color, int row, int column) {
        if (isOutOfBounds(row, column)) {
            return;
        }
        background[row][column] = color;
    }

    public void setBackground(Color color, int[] rows, int[] columns) {
        if (isOutOfBounds(rows, columns)) {
            return;
        }
        setValues(background, color, rows, columns);
    }

    public Font getFont(int row, int column) {
        if (isOutOfBounds(row, column)) {
            return null;
        }
        return font[row][column];
    }

    public void setFont(Font font, int row, int column) {
        if (isOutOfBounds(row, column)) {
            return;
        }
        this.font[row][column] = font;
    }

    public void setFont(Font font, int[] rows, int[] columns) {
        if (isOutOfBounds(rows, columns)) {
            return;
        }
        setValues(this.font, font, rows, columns);
    }

    public void addColumn() {
        int[][][] oldSpan = span;
        int numRows = oldSpan.length;
        int numColumns = oldSpan[0].length;
        span = new int[numRows][numColumns + 1][2];
        System.arraycopy(oldSpan, 0, span, 0, numRows);
        for (int i = 0; i < numRows; i++) {
            span[i][numColumns][CellSpan.COLUMN] = 1;
            span[i][numColumns][CellSpan.ROW] = 1;
        }
    }

    public void addRow() {
        int[][][] oldSpan = span;
        int numRows = oldSpan.length;
        int numColumns = oldSpan[0].length;
        span = new int[numRows + 1][numColumns][2];
        System.arraycopy(oldSpan, 0, span, 0, numRows);
        for (int i = 0; i < numColumns; i++) {
            span[numRows][i][CellSpan.COLUMN] = 1;
            span[numRows][i][CellSpan.ROW] = 1;
        }
    }

    public void insertRow(int row) {
        int[][][] oldSpan = span;
        int numRows = oldSpan.length;
        int numColumns = oldSpan[0].length;
        span = new int[numRows + 1][numColumns][2];
        if (0 < row) {
            System.arraycopy(oldSpan, 0, span, 0, row - 1);
        }
        System.arraycopy(oldSpan, 0, span, row, numRows - row);
        for (int i = 0; i < numColumns; i++) {
            span[row][i][CellSpan.COLUMN] = 1;
            span[row][i][CellSpan.ROW] = 1;
        }
    }

    public Dimension getSize() {
        return new Dimension(rowSize, columnSize);
    }

    public void setSize(Dimension size) {
        columnSize = size.width;
        rowSize = size.height;
        span = new int[rowSize][columnSize][2];
        foreground = new Color[rowSize][columnSize];
        background = new Color[rowSize][columnSize];
        font = new Font[rowSize][columnSize];
        initValue();
    }

    protected boolean isOutOfBounds(int row, int column) {
        if ((row < 0) || (rowSize <= row)
                || (column < 0) || (columnSize <= column)) {
            return true;
        }
        return false;
    }

    protected boolean isOutOfBounds(int[] rows, int[] columns) {
        for (int i = 0; i < rows.length; i++) {
            if ((rows[i] < 0) || (rowSize <= rows[i])) {
                return true;
            }
        }
        for (int i = 0; i < columns.length; i++) {
            if ((columns[i] < 0) || (columnSize <= columns[i])) {
                return true;
            }
        }
        return false;
    }

    protected void setValues(Object[][] target, Object value,
            int[] rows, int[] columns) {
        for (int i = 0; i < rows.length; i++) {
            int row = rows[i];
            for (int j = 0; j < columns.length; j++) {
                int column = columns[j];
                target[row][column] = value;
            }
        }
    }

    public void split(int row, int column) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

interface CellAttribute {

    public void addColumn();

    public void addRow();

    public void insertRow(int row);

    public Dimension getSize();

    public void setSize(Dimension size);
}

interface CellSpan {

    public final int ROW = 0;
    public final int COLUMN = 1;

    public int[] getSpan(int row, int column);

    public void setSpan(int[] span, int row, int column);

    public boolean isVisible(int row, int column);

    public void combine(int[] rows, int[] columns);

    public void split(int row, int column);
}

class MultiSpanCellTable extends JTable {

    public MultiSpanCellTable(TableModel model) {
        super(model);
        setUI(new MultiSpanCellTableUI());
        getTableHeader().setReorderingAllowed(false);
        setCellSelectionEnabled(true);
        setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    }

    public Rectangle getCellRect(int row, int column, boolean includeSpacing) {
        Rectangle sRect = super.getCellRect(row, column, includeSpacing);
        if ((row < 0) || (column < 0)
                || (getRowCount() <= row) || (getColumnCount() <= column)) {
            return sRect;
        }
        CellSpan cellAtt = (CellSpan) ((AttributiveCellTableModel) getModel()).getCellAttribute();
        if (!cellAtt.isVisible(row, column)) {
            int temp_row = row;
            int temp_column = column;
            row += cellAtt.getSpan(temp_row, temp_column)[CellSpan.ROW];
            column += cellAtt.getSpan(temp_row, temp_column)[CellSpan.COLUMN];
        }
        int[] n = cellAtt.getSpan(row, column);

        int index = 0;
        int columnMargin = getColumnModel().getColumnMargin();
        Rectangle cellFrame = new Rectangle();
        int aCellHeight = rowHeight + rowMargin;
        cellFrame.y = row * aCellHeight;
        cellFrame.height = n[CellSpan.ROW] * aCellHeight;

        Enumeration eeration = getColumnModel().getColumns();
        while (eeration.hasMoreElements()) {
            TableColumn aColumn = (TableColumn) eeration.nextElement();
            cellFrame.width = aColumn.getWidth() + columnMargin;
            if (index == column) {
                break;
            }
            cellFrame.x += cellFrame.width;
            index++;
        }
        for (int i = 0; i < n[CellSpan.COLUMN] - 1; i++) {
            TableColumn aColumn = (TableColumn) eeration.nextElement();
            cellFrame.width += aColumn.getWidth() + columnMargin;
        }



        if (!includeSpacing) {
            Dimension spacing = getIntercellSpacing();
            cellFrame.setBounds(cellFrame.x + spacing.width / 2,
                    cellFrame.y + spacing.height / 2,
                    cellFrame.width - spacing.width,
                    cellFrame.height - spacing.height);
        }
        return cellFrame;
    }

    private int[] rowColumnAtPoint(Point point) {
        int[] retValue = {-1, -1};
        int row = point.y / (rowHeight + rowMargin);
        if ((row < 0) || (getRowCount() <= row)) {
            return retValue;
        }
        int column = getColumnModel().getColumnIndexAtX(point.x);

        CellSpan cellAtt = (CellSpan) ((AttributiveCellTableModel) getModel()).getCellAttribute();

        if (cellAtt.isVisible(row, column)) {
            retValue[CellSpan.COLUMN] = column;
            retValue[CellSpan.ROW] = row;
            return retValue;
        }
        retValue[CellSpan.COLUMN] = column + cellAtt.getSpan(row, column)[CellSpan.COLUMN];
        retValue[CellSpan.ROW] = row + cellAtt.getSpan(row, column)[CellSpan.ROW];
        return retValue;
    }

    public int rowAtPoint(Point point) {
        return rowColumnAtPoint(point)[CellSpan.ROW];
    }

    public int columnAtPoint(Point point) {
        return rowColumnAtPoint(point)[CellSpan.COLUMN];
    }

    public void columnSelectionChanged(ListSelectionEvent e) {
        repaint();
    }

    public void valueChanged(ListSelectionEvent e) {
        int firstIndex = e.getFirstIndex();
        int lastIndex = e.getLastIndex();
        if (firstIndex == -1 && lastIndex == -1) { // Selection cleared.
            repaint();
        }
        Rectangle dirtyRegion = getCellRect(firstIndex, 0, false);
        int numCoumns = getColumnCount();
        int index = firstIndex;
        for (int i = 0; i < numCoumns; i++) {
            dirtyRegion.add(getCellRect(index, i, false));
        }
        index = lastIndex;
        for (int i = 0; i < numCoumns; i++) {
            dirtyRegion.add(getCellRect(index, i, false));
        }
        repaint(dirtyRegion.x, dirtyRegion.y, dirtyRegion.width, dirtyRegion.height);
    }
}

class MultiSpanCellTableUI extends BasicTableUI {

    public void paint(Graphics g, JComponent c) {
        Rectangle oldClipBounds = g.getClipBounds();
        Rectangle clipBounds = new Rectangle(oldClipBounds);
        int tableWidth = table.getColumnModel().getTotalColumnWidth();
        clipBounds.width = Math.min(clipBounds.width, tableWidth);
        g.setClip(clipBounds);

        int firstIndex = table.rowAtPoint(new Point(0, clipBounds.y));
        int lastIndex = table.getRowCount() - 1;

        Rectangle rowRect = new Rectangle(0, 0,
                tableWidth, table.getRowHeight() + table.getRowMargin());
        rowRect.y = firstIndex * rowRect.height;

        for (int index = firstIndex; index <= lastIndex; index++) {
            if (rowRect.intersects(clipBounds)) {
                paintRow(g, index);
            }
            rowRect.y += rowRect.height;
        }
        g.setClip(oldClipBounds);
    }

    private void paintRow(Graphics g, int row) {
        Rectangle rect = g.getClipBounds();
        boolean drawn = false;

        AttributiveCellTableModel tableModel = (AttributiveCellTableModel) table.getModel();
        CellSpan cellAtt = (CellSpan) tableModel.getCellAttribute();
        int numColumns = table.getColumnCount();

        for (int column = 0; column < numColumns; column++) {
            Rectangle cellRect = table.getCellRect(row, column, true);
            int cellRow, cellColumn;
            if (cellAtt.isVisible(row, column)) {
                cellRow = row;
                cellColumn = column;
            } else {
                cellRow = row + cellAtt.getSpan(row, column)[CellSpan.ROW];
                cellColumn = column + cellAtt.getSpan(row, column)[CellSpan.COLUMN];
            }
            if (cellRect.intersects(rect)) {
                drawn = true;
                paintCell(g, cellRect, cellRow, cellColumn);
            } else {
                if (drawn) {
                    break;
                }
            }
        }

    }

    private void paintCell(Graphics g, Rectangle cellRect, int row, int column) {
        int spacingHeight = table.getRowMargin();
        int spacingWidth = table.getColumnModel().getColumnMargin();

        Color c = g.getColor();
        g.setColor(table.getGridColor());
        g.drawRect(cellRect.x, cellRect.y, cellRect.width - 1, cellRect.height - 1);
        g.setColor(c);

        cellRect.setBounds(cellRect.x + spacingWidth / 2, cellRect.y + spacingHeight / 2,
                cellRect.width - spacingWidth, cellRect.height - spacingHeight);

        if (table.isEditing() && table.getEditingRow() == row
                && table.getEditingColumn() == column) {
            Component component = table.getEditorComponent();
            component.setBounds(cellRect);
            component.validate();
        } else {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            Component component = table.prepareRenderer(renderer, row, column);

            if (component.getParent() == null) {
                rendererPane.add(component);
            }
            rendererPane.paintComponent(g, component, table, cellRect.x, cellRect.y,
                    cellRect.width, cellRect.height, true);
        }
    }
}

interface CellFont {

    public Font getFont(int row, int column);

    public void setFont(Font font, int row, int column);

    public void setFont(Font font, int[] rows, int[] columns);
}

interface ColoredCell {

    public Color getForeground(int row, int column);

    public void setForeground(Color color, int row, int column);

    public void setForeground(Color color, int[] rows, int[] columns);

    public Color getBackground(int row, int column);

    public void setBackground(Color color, int row, int column);

    public void setBackground(Color color, int[] rows, int[] columns);
}
