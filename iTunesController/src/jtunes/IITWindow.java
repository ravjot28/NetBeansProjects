package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITWindow Interface
 */
@IID("{370D7BE0-3A89-4A42-B902-C75FC138BE09}")
public interface IITWindow extends Com4jObject {
    /**
     * The title of the window.
     */
    @VTID(7)
    java.lang.String name();

    /**
     * The window kind.
     */
    @VTID(8)
    ITWindowKind kind();

    /**
     * True if the window is visible. Note that the main browser window cannot be hidden.
     */
    @VTID(9)
    boolean visible();

    /**
     * True if the window is visible. Note that the main browser window cannot be hidden.
     */
    @VTID(10)
    void visible(
        boolean isVisible);

    /**
     * True if the window is resizable.
     */
    @VTID(11)
    boolean resizable();

    /**
     * True if the window is minimized.
     */
    @VTID(12)
    boolean minimized();

    /**
     * True if the window is minimized.
     */
    @VTID(13)
    void minimized(
        boolean isMinimized);

    /**
     * True if the window is maximizable.
     */
    @VTID(14)
    boolean maximizable();

    /**
     * True if the window is maximized.
     */
    @VTID(15)
    boolean maximized();

    /**
     * True if the window is maximized.
     */
    @VTID(16)
    void maximized(
        boolean isMaximized);

    /**
     * True if the window is zoomable.
     */
    @VTID(17)
    boolean zoomable();

    /**
     * True if the window is zoomed.
     */
    @VTID(18)
    boolean zoomed();

    /**
     * True if the window is zoomed.
     */
    @VTID(19)
    void zoomed(
        boolean isZoomed);

    /**
     * The screen coordinate of the top edge of the window.
     */
    @VTID(20)
    int top();

    /**
     * The screen coordinate of the top edge of the window.
     */
    @VTID(21)
    void top(
        int top);

    /**
     * The screen coordinate of the left edge of the window.
     */
    @VTID(22)
    int left();

    /**
     * The screen coordinate of the left edge of the window.
     */
    @VTID(23)
    void left(
        int left);

    /**
     * The screen coordinate of the bottom edge of the window.
     */
    @VTID(24)
    int bottom();

    /**
     * The screen coordinate of the bottom edge of the window.
     */
    @VTID(25)
    void bottom(
        int bottom);

    /**
     * The screen coordinate of the right edge of the window.
     */
    @VTID(26)
    int right();

    /**
     * The screen coordinate of the right edge of the window.
     */
    @VTID(27)
    void right(
        int right);

    /**
     * The width of the window.
     */
    @VTID(28)
    int width();

    /**
     * The width of the window.
     */
    @VTID(29)
    void width(
        int width);

    /**
     * The height of the window.
     */
    @VTID(30)
    int height();

    /**
     * The height of the window.
     */
    @VTID(31)
    void height(
        int height);

}
