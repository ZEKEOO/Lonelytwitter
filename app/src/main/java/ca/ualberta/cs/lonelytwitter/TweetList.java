package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by ZEKE_XU on 16/9/29.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Instantiates a new Tweet list.
     */
    public TweetList() {

    }

    /**
     * Has tweet boolean.
     *
     * @param tweet the tweet
     * @return the boolean
     */
    public Boolean hasTweet(Tweet tweet) {
        for (Tweet t : tweets) {
            if (t.equals(tweet)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * Add tweet.
     *
     * @param tweet the tweet
     */
    public void addTweet(Tweet tweet) {
        if (tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }

    public int getCount() {
        return tweets.size();
    }

    /**
     * Delete.
     *
     * @param tweet the tweet
     */
    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    /**
     * Gets tweets.
     *
     * @param index the index
     * @return the tweets
     */
    public Tweet getTweets(int index) {
        return tweets.get(index);
    }

    /**
     * Add.
     *
     * @param tweet the tweet
     */
    public void add(Tweet tweet) {
        tweets.add(tweet); 
    }
}
