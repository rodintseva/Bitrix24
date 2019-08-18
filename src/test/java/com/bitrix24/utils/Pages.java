package com.bitrix24.utils;

import com.bitrix24.pages.activityStream.*;

public class Pages {

    private LoginPage loginPage;
    private TaskPage taskPage;
    private MessagePage messagePage;
    private EventPage eventPage;
    private PollPage pollPage;



    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public TaskPage taskPage() {
        if (taskPage == null) {
            taskPage = new TaskPage();
        }
        return taskPage;
    }

}