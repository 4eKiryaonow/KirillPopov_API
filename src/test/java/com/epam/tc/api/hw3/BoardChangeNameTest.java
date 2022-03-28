package com.epam.tc.api.hw3;

import org.testng.annotations.Test;

public class BoardChangeNameTest extends BaseTest {

    @Test(dataProvider = "boardChangeName", dataProviderClass = TestData.class)
    public void checkChangeNameBoard(String name, String newName) {

        boardDTO = restBoardService.createBoard(name);
        boardDTO = restBoardService.changeNameOfBoard(boardDTO.getId(), newName);
        boardDTO = restBoardService.getBoard(boardDTO.getId());
        restBoardAssertion.assertBoardName(boardDTO, newName);

    }
}
