package com.epam.tc.api.hw3;

import static com.epam.tc.api.hw3.TestData.BOARD_NAME;
import static com.epam.tc.api.hw3.TestData.LIST_NAME;

import org.testng.annotations.Test;

public class CreateListOnDeletingBoardTest extends BaseTest {

    @Test
    public void checkListCreationOnDeletingBoard() {

        boardDTO = restBoardService.createBoard(BOARD_NAME);
        response = restBoardService.deleteBoard(boardDTO.getId());
        restBoardAssertion.assertBoardDeleted(response);
        response = restBoardService.getBoardResponse(boardDTO.getId());
        restBoardAssertion.assertBoardNotFound(response);
        response = restListService.createListResponse(LIST_NAME, boardDTO);
        restListAssertion.assertCreateListOnDeletedBoard(boardDTO, response);
    }
}
