package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TrelloValidatorTest {

    @InjectMocks
    private TrelloValidator trelloValidator = new TrelloValidator();

    @Test
    public void validateTrelloBoardstest() {

        //Given
        TrelloBoard firstTrelloBoard = new TrelloBoard("1", "test", new ArrayList<>());
        TrelloBoard secondTrelloBoard = new TrelloBoard("2", "Board 2", new ArrayList<>());

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(firstTrelloBoard);
        trelloBoards.add(secondTrelloBoard);

        //When
        List<TrelloBoard> filteredBoard = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(1, filteredBoard.size());
    }
}
