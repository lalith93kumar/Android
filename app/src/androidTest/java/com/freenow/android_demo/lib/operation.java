package com.freenow.android_demo.lib;
import android.support.test.espresso.action.ViewActions;

import java.lang.reflect.Method;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
public class operation {

    public String how;
    public Object value;
    public Class ctype;

    public operation(String how, Object value,Class c)
    {
        this.how = how;
        this.value = value;
        this.ctype = c;
    }

    public org.hamcrest.Matcher<android.view.View> findElement()
    {

        Object b = null;
        try {
            b = android.support.test.espresso.matcher.ViewMatchers.class.getMethod(how,ctype).invoke(null,value);
        }
        catch (Exception e)
        {
            System.out.println("text alalith" + e.getMessage());
        }
        return (org.hamcrest.Matcher<android.view.View>)b;
    }

    public void sendKeys(String values)
    {
        org.hamcrest.Matcher<android.view.View> h = findElement();
        onView(findElement()).perform(typeText(values));
    }

    public boolean isPresent()
    {
        try {
            onView(findElement()).check(matches(isDisplayed()));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void select(String value)
    {
        onView(findElement()).inRoot(isPlatformPopup()).perform(ViewActions.click());
    }

    public void click()
    {
        onView(findElement()).perform(ViewActions.click());
    }

}
