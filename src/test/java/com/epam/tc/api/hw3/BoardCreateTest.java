package com.epam.tc.api.hw3;

import org.testng.annotations.Test;

public class BoardCreateTest extends BaseTest {

    @Test(dataProvider = "boardName", dataProviderClass = TestData.class)
    public void checkCreationOfBoard(String name) {

        boardDTO = restBoardService.createBoard(name);
        boardDTO = restBoardService.getBoard(boardDTO.getId());
        restBoardAssertion.assertBoardName(boardDTO, name);
        restBoardAssertion.assertBoardId(boardDTO);
    }


}
