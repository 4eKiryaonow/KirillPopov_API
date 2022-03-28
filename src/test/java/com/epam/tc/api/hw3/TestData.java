package com.epam.tc.api.hw3;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider
    public static Object[][] boardName() {

        return new Object[][] {{"First name"}, {"Second name"}, {"Third name"}};
    }

    @DataProvider
    public static Object[][] boardChangeName() {

        return new Object[][] {{"First name", "1st name", }, {"Second name", "2nd name", }, {"Third name", "3rd name"}};
    }

    @DataProvider
    public static Object[][] listName() {

        return new Object[][] {{"First name", "TO DO", }, {"Second name", "IN PROCESS", }, {"Third name", "DONE"}};
    }
}
