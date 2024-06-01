package com.sparta.board.controller;

import com.sparta.board.dto.MeetingRequestDto;
import com.sparta.board.dto.MeetingResponseDto;
import com.sparta.board.entity.Meeting;
import com.sparta.board.service.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    @PostMapping
    public MeetingResponseDto createMeeting(@RequestBody MeetingRequestDto requestDto) {
        Meeting meeting = meetingService.createMeeting(requestDto.getHostId(), requestDto.getLocation(), requestDto.getMeetingTime());
        return convertToDto(meeting);
    }

    @GetMapping
    public List<MeetingResponseDto> getAllMeetings() {
        return meetingService.getAllMeetings().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MeetingResponseDto getMeetingById(@PathVariable Long id) {
        Meeting meeting = meetingService.getMeetingById(id);
        return convertToDto(meeting);
    }

    @DeleteMapping("/{id}")
    public void deleteMeeting(@PathVariable Long id) {
        meetingService.deleteMeeting(id);
    }

    private MeetingResponseDto convertToDto(Meeting meeting) {
        MeetingResponseDto dto = new MeetingResponseDto();
        dto.setId(meeting.getId());
        dto.setHost(meeting.getHost());
        dto.setParticipants(meeting.getParticipants());
        dto.setLocation(meeting.getLocation());
        dto.setMeetingTime(meeting.getMeetingTime());
        return dto;
    }
}
