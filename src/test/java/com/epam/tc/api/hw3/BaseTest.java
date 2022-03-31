package com.epam.tc.api.hw3;

import com.epam.tc.api.hw3.dto.BoardDTO;
import com.epam.tc.api.hw3.dto.ListDTO;
import com.epam.tc.api.hw3.service.RestBoardAssertion;
import com.epam.tc.api.hw3.service.RestBoardService;
import com.epam.tc.api.hw3.service.RestListAssertion;
import com.epam.tc.api.hw3.service.RestListService;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected BoardDTO boardDTO;
    protected ListDTO listDTO;
    protected Response response;
    protected RestBoardService restBoardService;
    protected RestBoardAssertion restBoardAssertion;
    protected RestListService restListService;
    protected RestListAssertion restListAssertion;

    @BeforeMethod
    public void setUp() {
        boardDTO = new BoardDTO();
        listDTO = new ListDTO();
        restBoardService = new RestBoardService();
        restBoardAssertion = new RestBoardAssertion();
        restListService = new RestListService();
        restListAssertion = new RestListAssertion();
    }

    @AfterMethod
    public void tearDown() {

        restBoardService.deleteBoard(boardDTO.getId());

    }
}
