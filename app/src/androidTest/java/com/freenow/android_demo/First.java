package com.freenow.android_demo;
import com.freenow.android_demo.activities.MainActivity;
import android.support.test.rule.ActivityTestRule;
import com.freenow.android_demo.lib.pages;
import android.support.test.runner.AndroidJUnit4;
import org.junit.runner.RunWith;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class First {

    public static pages loginPageObj;
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @BeforeClass
    public static void pageObject()
    {
        First.loginPageObj = new pages();

    }

    @Before
    @After
    public void beforeFunction()
    {
        if(First.loginPageObj.SEARCH_DRIVER_FIELD.isPresent()) {
            First.loginPageObj.logout();
        }
    }
    @Test
    public void validLoginCredentials() throws InterruptedException {
        First.loginPageObj.login("crazydog335","venture");
        assertTrue("",First.loginPageObj.SEARCH_DRIVER_FIELD.isPresent());
    }

    @Test
    public void invalidLoginCredentials() throws InterruptedException {
        First.loginPageObj.login("crazydog33552","venturemax");
        assertFalse("",First.loginPageObj.SEARCH_DRIVER_FIELD.isPresent());
    }

    @Test
    public void validContactSearch() throws InterruptedException {
        First.loginPageObj.login("crazydog335","venture");
        First.loginPageObj.contact("sa","Sara Christensen");
        assertTrue("",First.loginPageObj.CONTACTIMAGE.isPresent());
    }

    @Test
    public void validRandomContactSearch() throws InterruptedException {
        First.loginPageObj.login("crazydog335","venture");
        First.loginPageObj.contact("sa","Sarah Scott");
        assertTrue("",First.loginPageObj.CONTACTIMAGE.isPresent());
    }

}