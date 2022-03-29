package com.epam.tc.api.hw3.service;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;

import com.epam.tc.api.hw3.dto.BoardDTO;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

public class RestBoardAssertion {

    public void assertBoardName(BoardDTO boardDTO, String boardName) {

        Assertions
            .assertThat(boardDTO.getName())
            .as(String.format("The Board name actual: %s \n The Board name is expected: %s",
                boardDTO.getName(), boardName))
            .isEqualTo(boardName);
    }

    public void assertBoardId(BoardDTO boardDTO) {

        Assertions
            .assertThat(boardDTO.getId())
            .as("Board id is not valid")
            .isNotNull();
    }

    public void assertBoardDeleted(Response response) {

        Assertions.assertThat(response.path("_value") == null).isEqualTo(true);
    }

    public void assertBoardNotFound(Response response) {

        Assertions.assertThat(response.statusCode()).isEqualTo(SC_NOT_FOUND);
        Assertions.assertThat(response.asPrettyString()).isEqualTo("The requested resource was not found.");
    }
}
