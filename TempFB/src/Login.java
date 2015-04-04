import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import com.google.code.facebookapi.FacebookException;
import com.google.code.facebookapi.FacebookXmlRestClient;
public class Login
{
public static String login(String API_KEY, String SECRET_KEY, final String email, final String password) throws FacebookException, HttpException, IOException
{
    //LOGIN (finally got this one working  )
//Creating an HttpClient instance used for requesting (GET and POST) to login
//The HttpClient should only be used for the login system
HttpClient http = new HttpClient(); //The host will be offcourse http://www.facebook.com
http.getHostConfiguration().setHost("www.facebook.com");
//Creating the client based on the public API_KEY and the private SECRET_KEY
FacebookXmlRestClient client = new FacebookXmlRestClient(API_KEY, SECRET_KEY);
//Is this application a desktop application?
// TODO Check what the meaning of “isDesktop” exactly is (is mobile application a desktop application?)
//When false the friendlist cannot be obtained :/
//client.setIsDesktop(false);
//Create the authentication token
String token = client.auth_createToken();
System.out.println("LOGIN – Authentication Token created upon login: " + token);
//Setting for the HttpClient instance
HttpClientParams params = new HttpClientParams();
HttpState initialState = new HttpState();
http.setParams(params);
http.setState(initialState);
//Getting the login page specific for this application
//Basically this will not change with a newer facebook version
GetMethod get = new GetMethod("/login.php?api_key=" + API_KEY + "&v=1.0&auth_token=" + token);
//Request the login page from the World Wide Web
int getStatus = http.executeMethod(get);
//System.out.println("LOGIN – Http status returned when executing GET: " + getStatus);
//Setting up POST method to actually do the login work
PostMethod post = new PostMethod("/login.php?login_attempt=1");
//Set the needed login parameters. These are the html elements on the
//applications login screen, requested with the GET-method, that
//will be submitted on login (”version” used to be “v” in old facebook)
post.addParameter("api_key", API_KEY);
post.addParameter("version", "1.0");
post.addParameter("auth_token", token);
post.addParameter("email", email);
post.addParameter("pass", password);
//Do the actually login on the World Wide Web
int postStatus = http.executeMethod(post);
System.out.println("LOGIN – Http status returned when executing POST: " + postStatus);
//Get the authentication session string, needed in the rest of the application
String session = client.auth_getSession(token);
System.out.println("LOGIN – The Authentication Session string: " + session);
//Request the userid of the currently logged in user, will be
//needed further on the application
long userid = client.users_getLoggedInUser();
System.out.println("LOGIN – Successfull login for user with id ‘" + userid + "");
return session; 
}
}