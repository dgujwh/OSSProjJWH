package com.sparta.board.dto;

import com.sparta.board.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class MeetingResponseDto {
    private Long id;
    private User host;
    private List<User> participants;
    private String location;
    private LocalDateTime meetingTime;
}
