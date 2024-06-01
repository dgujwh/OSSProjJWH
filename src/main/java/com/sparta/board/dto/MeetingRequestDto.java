package com.sparta.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MeetingRequestDto {
    private Long hostId;
    private String location;
    private LocalDateTime meetingTime;
}
