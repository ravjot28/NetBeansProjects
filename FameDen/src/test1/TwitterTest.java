/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

/**
 *
 * @author Ravjot
 */
public class TwitterTest {

    public static void test() throws TwitterException {
        String token = "21573639-Mffsa0XkhsKEciIPUHVNWXVhw6reSo4R5aAWBLsbk";
        String secretToken = "ismiEb2d9foaRlOLwfdz5dztx6qbYJ1atL3Tz1fyY";
        long userId = 21573639;
        TwitterFactory factory = new TwitterFactory();
        AccessToken accessToken = new AccessToken(token, secretToken);
        Twitter twitter = factory.getInstance();
        
        twitter.setOAuthConsumer("QPrDwr29NEQCsS6ctjX6iQ", "LvwRGBUpzrg4pv2ELnKKXIefxIskj1XQd5wbcE");
        twitter.setOAuthAccessToken(accessToken);
        User user = twitter.showUser(userId);
        String biggerProfileImageURL = user.getBiggerProfileImageURL();
        String location = user.getLocation();
        String timeZon = user.getTimeZone();
        String screenName = user.getScreenName();
        String name = user.getName();
        String description = user.getDescription();

        String url = user.getProfileImageURL();
        System.out.println(biggerProfileImageURL);
        System.out.println(url);
        System.out.println(location);
        System.out.println(timeZon);
        System.out.println(screenName);
        System.out.println(name);
        System.out.println(description);
    }

    public static void main(String as[]) throws TwitterException {

        test();
        /*
        //4156089
        String token = "21573639-Mffsa0XkhsKEciIPUHVNWXVhw6reSo4R5aAWBLsbk";
        String secretToken = "ismiEb2d9foaRlOLwfdz5dztx6qbYJ1atL3Tz1fyY";
        long userId = 21573639;

        AccessToken acessToken = new AccessToken(token, secretToken);
        System.out.println("Creating twitter object");

        Twitter twitter = TwitterFactory.getSingleton();
        System.out.println("Setting keys in the object");
        twitter.setOAuthConsumer("QPrDwr29NEQCsS6ctjX6iQ", "LvwRGBUpzrg4pv2ELnKKXIefxIskj1XQd5wbcE");
        twitter.setOAuthAccessToken(acessToken);
        System.out.println("Creating token");
        User user = twitter.showUser(userId);
        String biggerProfileImageURL = user.getBiggerProfileImageURL();
        String location = user.getLocation();
        String timeZon = user.getTimeZone();
        String screenName = user.getScreenName();
        String name = user.getName();
        String description = user.getDescription();

        String url = user.getProfileImageURL();
        System.out.println(biggerProfileImageURL);
        System.out.println(url);
        System.out.println(location);
        System.out.println(timeZon);
        System.out.println(screenName);
        System.out.println(name);
        System.out.println(description);*/
    }
}
