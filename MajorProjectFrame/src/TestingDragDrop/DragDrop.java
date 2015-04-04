/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingDragDrop;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
public class DragDrop implements DragGestureListener,DragSourceListener,DropTargetListener, Transferable
{
    static final DataFlavor[] supportedFlavors = {null};

    static {
        try {
            supportedFlavors[0] = new
            DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    Object object;
    // Transferable methods.
    public Object getTransferData(DataFlavor flavor)
    {
        if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType))
        {
            return object;
        } else
        {
            return null;
        }
    }
    public DataFlavor[] getTransferDataFlavors()
    {
        return supportedFlavors;
    }
    public boolean isDataFlavorSupported(DataFlavor flavor)
    {
        return flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType);
    }
    // DragGestureListener method.
    public void dragGestureRecognized(DragGestureEvent ev)
    {
        ev.startDrag(null, this, this);
    }
    // DragSourceListener methods.
    public void dragDropEnd(DragSourceDropEvent ev)
    {
    }
    public void dragEnter(DragSourceDragEvent ev)
    {
    }
    public void dragExit(DragSourceEvent ev)
    {
    }
    public void dragOver(DragSourceDragEvent ev)
    {
        object = ev.getSource();
    }
    public void dropActionChanged(DragSourceDragEvent ev)
    {
    }
    // DropTargetListener methods.
    public void dragEnter(DropTargetDragEvent ev)
    {
    }
    public void dragExit(DropTargetEvent ev)
    {
    }
    public void dragOver(DropTargetDragEvent ev)
    {
        dropTargetDrag(ev);
    }
    public void dropActionChanged(DropTargetDragEvent ev)
    {
        dropTargetDrag(ev);
    }
    void dropTargetDrag(DropTargetDragEvent ev)
    {
        ev.acceptDrag(ev.getDropAction());
    }
    public void drop(DropTargetDropEvent ev)
    {
        ev.acceptDrop(ev.getDropAction());
        try
        {
            Object target = ev.getSource();
            Object source = ev.getTransferable().getTransferData(supportedFlavors[0]);
            Component component = ((DragSourceContext)source).getComponent();
            Container oldContainer = component.getParent();
            Container container = (Container) ((DropTarget)target).getComponent();
            container.add(component);
            oldContainer.validate();
            oldContainer.repaint();
            container.validate();
            container.repaint();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        ev.dropComplete(true);
    }
    public static void main(String[] arg)
    {
        Button button = new Button("Drag this button");


        Frame source = new Frame("Source Frame");
        source.setLayout(new FlowLayout());
        source.add(button);


        Frame target = new Frame("Target Frame");
        target.setLayout(null);

        DragDrop dndListener = new DragDrop();
        DragSource dragSource = new DragSource();

        //DropTarget dropTarget1 = new DropTarget(source,DnDConstants.ACTION_MOVE, dndListener);
        DropTarget dropTarget2 = new DropTarget(target,DnDConstants.ACTION_MOVE,dndListener);
        DragGestureRecognizer dragRecognizer1 = dragSource.createDefaultDragGestureRecognizer(button,DnDConstants.ACTION_MOVE, dndListener);

        
        source.setBounds(0, 200, 200, 200);
        target.setBounds(220, 200, 200, 200);
        source.show();
        target.show();
    }
} 