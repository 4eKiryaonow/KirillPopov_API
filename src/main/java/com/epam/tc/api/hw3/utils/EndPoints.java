package com.epam.tc.api.hw3.utils;

public final class EndPoints {
    public static final String BASE_URL = PropertiesReader.getProperty("url");
    public static final String BOARDS = "boards/";
    public static final String GET_BOARD = "boards/%s";
    public static final String LISTS = "lists/";
    public static final String GET_LISTS = "lists/%s";
}
