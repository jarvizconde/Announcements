package com.example.jarviz.announcements;

import com.google.gson.annotations.SerializedName;

public class Announcements {





    @SerializedName("Announcement_Title")
    private String Title;


    @SerializedName("Announcement_Text")
    private String Text;

    @SerializedName("Announcement_DateTime_Created")
    private String Date;





    public String getTitle() {
        return Title;
    }

    public String getText() {
        return Text;
    }

    public String getDate() {
        return Date;
    }
}
