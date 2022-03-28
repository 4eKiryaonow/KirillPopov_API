package com.epam.tc.api.hw3;

import org.testng.annotations.Test;

public class BoardDeleteTest extends BaseTest {

    @Test(dataProvider = "boardName", dataProviderClass = TestData.class)
    public void checkDeletingOfBoard(String name) {

        boardDTO = restBoardService.createBoard(name);
        response = restBoardService.deleteBoard(boardDTO.getId());
        restBoardAssertion.assertBoardDeleted(response);
    }
}
