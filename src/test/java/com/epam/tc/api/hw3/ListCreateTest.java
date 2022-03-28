package com.epam.tc.api.hw3;

import org.testng.annotations.Test;

public class ListCreateTest extends BaseTest {

    @Test(dataProvider = "listName", dataProviderClass = TestData.class)
    public void checkCreationOfList(String boardName, String listName) {

        boardDTO = restBoardService.createBoard(boardName);
        listDTO = restListService.createList(listName, boardDTO);
        listDTO = restListService.getList(listDTO.getId());
        restListAssertion.assertIdBoard(boardDTO, listDTO);
        restListAssertion.assertListName(listDTO, listName);
    }
}
