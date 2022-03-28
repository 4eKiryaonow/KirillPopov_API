package com.epam.tc.api.hw3;

import org.testng.annotations.Test;

public class CreateListOnDeletingBoardTest extends BaseTest {

    @Test(dataProvider = "listName", dataProviderClass = TestData.class)
    public void checkListCreationOnDeletingBoard(String boardName, String listName) {

        boardDTO = restBoardService.createBoard(boardName);
        response = restBoardService.deleteBoard(boardDTO.getId());
        restBoardAssertion.assertBoardDeleted(response);
        response = restListService.createListResponse(listName, boardDTO);
        restListAssertion.assertCreateListOnDeletedBoard(boardDTO, response);
    }
}
