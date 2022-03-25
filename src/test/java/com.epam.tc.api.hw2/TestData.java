package com.epam.tc.api.hw2;

public class TestData {

    //Data for preconditions
    public static final String FIRST_BOARD_NAME = "First board";
    public static final String FIRST_LIST_NAME = "TO DO";
    //Data for tests
    public static final String SECOND_BOARD_NAME = "Second board";
    public static final String NEW_FIRST_BOARD_NAME = "New first board";
    public static final String SECOND_LIST_NAME = "IN PROCESS";
    public static final String CARD_DESCRIPTION = "Second HW API";
    public static final String BASE_URL = PropertiesReader.getProperty("url");
    public static final String KEY = PropertiesReader.getProperty("key");
    public static final String TOKEN = PropertiesReader.getProperty("token");
}
