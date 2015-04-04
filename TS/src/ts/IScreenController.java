/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ts;


/**
 *
 * @author Ravjot
 */
public interface IScreenController {

    public void setScreenParent(SceneNavigator screenPage);

    public Object populateDTO();

    public boolean validateRequest() throws Exception;

    public void success(String message,String title);

    public void error(String message,String title);

    public void genericError(String message,String title);

}
