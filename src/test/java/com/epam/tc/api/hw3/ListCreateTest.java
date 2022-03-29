package com.epam.tc.api.hw3;

import static com.epam.tc.api.hw3.TestData.BOARD_NAME;
import static com.epam.tc.api.hw3.TestData.LIST_NAME;

import org.testng.annotations.Test;

public class ListCreateTest extends BaseTest {

    @Test
    public void checkCreationOfList() {

        boardDTO = restBoardService.createBoard(BOARD_NAME);
        listDTO = restListService.createList(LIST_NAME, boardDTO);
        listDTO = restListService.getList(listDTO.getId());
        restListAssertion.assertIdBoard(boardDTO, listDTO);
        restListAssertion.assertListName(listDTO, LIST_NAME);
    }
}
