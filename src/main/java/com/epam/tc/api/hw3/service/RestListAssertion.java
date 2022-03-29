package com.epam.tc.api.hw3.service;

import com.epam.tc.api.hw3.dto.BoardDTO;
import com.epam.tc.api.hw3.dto.ListDTO;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

public class RestListAssertion {

    public void assertIdBoard(BoardDTO boardDTO, ListDTO listDTO) {

        Assertions
            .assertThat(listDTO.getIdBoard())
            .as("Invalid Board id parameter in List")
            .isEqualTo(boardDTO.getId());
    }

    public void assertListName(ListDTO listDTO, String listName) {

        Assertions
            .assertThat(listDTO.getName())
            .as(String.format("The List name actual: %s \n The List name is expected: %s",
                listDTO.getName(), listName))
            .isEqualTo(listName);
    }

    public void assertCreateListOnDeletedBoard(BoardDTO boardDTO, Response response) {

        Assertions
            .assertThat(response.asString())
            .isEqualTo(String.format("unauthorized board list requested %s", boardDTO.getId()));
    }
}
