package com.epam.tc.api.hw3;

import static com.epam.tc.api.hw3.TestData.BOARD_NAME;
import static com.epam.tc.api.hw3.TestData.NEW_BOARD_NAME;

import org.testng.annotations.Test;

public class BoardChangeNameTest extends BaseTest {
    @Test
    public void checkChangeNameBoard() {

        boardDTO = restBoardService.createBoard(BOARD_NAME);
        boardDTO = restBoardService.changeNameOfBoard(boardDTO.getId(), NEW_BOARD_NAME);
        boardDTO = restBoardService.getBoard(boardDTO.getId());
        restBoardAssertion.assertBoardName(boardDTO, NEW_BOARD_NAME);
    }
}
