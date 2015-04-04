package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * Defines methods to create COM objects
 */
public abstract class ClassFactory {
    private ClassFactory() {} // instanciation is not allowed


    /**
     * iTunesApp Class
     */
    public static IiTunes createiTunesApp() {
        return COM4J.createInstance( IiTunes.class, "{DC0C2640-1415-4644-875C-6F4D769839BA}" );
    }
}
