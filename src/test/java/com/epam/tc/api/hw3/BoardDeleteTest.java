package com.epam.tc.api.hw3;

import static com.epam.tc.api.hw3.TestData.BOARD_NAME;

import org.testng.annotations.Test;

public class BoardDeleteTest extends BaseTest {

    @Test
    public void checkDeletingOfBoard() {

        boardDTO = restBoardService.createBoard(BOARD_NAME);
        response = restBoardService.deleteBoard(boardDTO.getId());
        restBoardAssertion.assertBoardDeleted(response);
        response = restBoardService.getBoardResponse(boardDTO.getId());
        restBoardAssertion.assertBoardNotFound(response);
    }
}
