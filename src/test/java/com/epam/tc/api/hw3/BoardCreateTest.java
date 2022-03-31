package com.epam.tc.api.hw3;

import static com.epam.tc.api.hw3.TestData.BOARD_NAME;

import org.testng.annotations.Test;

public class BoardCreateTest extends BaseTest {

    @Test
    public void checkCreationOfBoard() {

        boardDTO = restBoardService.createBoard(BOARD_NAME);
        boardDTO = restBoardService.getBoard(boardDTO.getId());
        restBoardAssertion.assertBoardName(boardDTO, BOARD_NAME);
        restBoardAssertion.assertBoardId(boardDTO);
    }
}
