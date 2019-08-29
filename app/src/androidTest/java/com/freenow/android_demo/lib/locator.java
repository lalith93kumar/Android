package com.freenow.android_demo.lib;
import com.freenow.android_demo.R;

public class locator {
    public operation USERNAME_FIELD = new operation("withId",R.id.edt_username,int.class);
    public operation PASSWORD_FIELD =  new operation("withId",R.id.edt_password,int.class);
    public operation LOGIN_BUTTON = new operation("withId",R.id.btn_login,int.class);
    public operation LOGOUT_BUTTON = new operation("withText","Logout",String.class);
    public operation SEARCH_DRIVER_FIELD = new operation("withId",R.id.textSearch,int.class);
    public operation SIDE = new operation("withContentDescription","Open navigation drawer",String.class);
    public operation CONTACTIMAGE = new operation("withId",R.id.imageViewDriverAvatar,int.class);
    public operation contactSuggestion(String value)
    {
       return new operation("withText",value,String.class);
    }
}
