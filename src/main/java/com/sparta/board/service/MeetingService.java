package com.sparta.board.service;

import com.sparta.board.entity.Meeting;
import com.sparta.board.entity.User;
import com.sparta.board.repository.MeetingRepository;
import com.sparta.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;
    private final UserRepository userRepository;

    public Meeting createMeeting(Long hostId, String location, LocalDateTime meetingTime) {
        User host = userRepository.findById(hostId)
                .orElseThrow(() -> new IllegalArgumentException("Host not found"));

        Meeting meeting = Meeting.builder()
                .host(host)
                .location(location)
                .meetingTime(meetingTime)
                .build();

        return meetingRepository.save(meeting);
    }

    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    public Meeting getMeetingById(Long id) {
        return meetingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Meeting not found"));
    }

    public void deleteMeeting(Long id) {
        meetingRepository.deleteById(id);
    }
}
