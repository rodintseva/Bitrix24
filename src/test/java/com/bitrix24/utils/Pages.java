package com.bitrix24.utils;

import com.bitrix24.pages.activityStream.*;
import com.bitrix24.pages.loginNavigation.LoginPage;

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
    public MessagePage messagePage() {
        if (messagePage == null) {
            messagePage = new MessagePage();
        }
        return messagePage;
    }
}