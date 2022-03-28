package com.epam.tc.api.hw3.service;

import static com.epam.tc.api.hw3.utils.EndPoints.BOARDS;
import static com.epam.tc.api.hw3.utils.EndPoints.GET_BOARD;

import com.epam.tc.api.hw3.dto.BoardDTO;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class RestBoardService extends CommonService {

    public BoardDTO createBoard(String boardName) {

        Map<String, String> params = new HashMap<>();
        params.put("name", boardName);
        return postWithParams(BOARDS, params).as(BoardDTO.class);
    }

    public BoardDTO getBoard(String boardId) {

        return getNoParams(String.format(GET_BOARD, boardId))
            .getBody().as(BoardDTO.class);
    }

    public Response deleteBoard(String boardId) {

        return deleteNoParams(String.format(GET_BOARD, boardId));
    }

    public BoardDTO changeNameOfBoard(String boardId, String newBoardName) {

        Map<String, String> params = new HashMap<>();
        params.put("name", newBoardName);

        return new CommonService().putWithParams(String.format(GET_BOARD, boardId), params).as(BoardDTO.class);
    }
}
