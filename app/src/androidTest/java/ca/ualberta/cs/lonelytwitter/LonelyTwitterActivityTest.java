package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    @Override
    public void setUp() throws Exception {
        Log.d("TAG1", "setUp()");
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testTweet() {
        solo.clickOnButton("Clear");

        solo.assertCurrentActivity("Wrong Activity!", LonelyTwitterActivity.class);

        solo.enterText((EditText)solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");
        solo.clearEditText((EditText)solo.getView(R.id.body));

        assertTrue(solo.waitForText("Test Tweet!"));

        solo.clickOnButton("Clear");

        assertFalse(solo.waitForText("Test Tweet!"));
    }

    public void testClickTweetList() {
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();
        solo.clickOnButton("Clear");

        solo.assertCurrentActivity("Wrong Activity!", LonelyTwitterActivity.class);

        solo.enterText((EditText)solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");

        solo.clearEditText((EditText)solo.getView(R.id.body));
        solo.waitForText("Test Tweet!");

        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals("Test Tweet!", tweet.getMessage());

        solo.clickInList(0);

        assertTrue(solo.waitForActivity(EditTweetActivity.class));
        solo.assertCurrentActivity("Wrong Activity!", EditTweetActivity.class);

        solo.goBack();
        solo.assertCurrentActivity("Wront Activity", LonelyTwitterActivity.class);
    }

    public void testEditTweetActivity() {
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();
        solo.clickOnButton("Clear");

        solo.assertCurrentActivity("Wrong Activity!", LonelyTwitterActivity.class);

        solo.enterText((EditText)solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");

        solo.clearEditText((EditText)solo.getView(R.id.body));
        solo.waitForText("Test Tweet!");

        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals("Test Tweet!", tweet.getMessage());

        solo.clickInList(0);

        assertTrue(solo.waitForActivity(EditTweetActivity.class));
        solo.assertCurrentActivity("Wrong Activity!", EditTweetActivity.class);

        assertTrue(solo.waitForText("Test Tweet!"));

        solo.goBack();
        assertTrue(solo.waitForActivity(LonelyTwitterActivity.class));
        solo.assertCurrentActivity("Wrong Activity!", LonelyTwitterActivity.class);
    }

    /**
     * Instantiates a new Lonely twitter activity test.
     */
    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    /**
     * Test start.
     *
     * @throws Exception the exception
     */
    public void testStart() throws Exception {
        Activity activity = getActivity();

    }
}