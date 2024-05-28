package com.example.meeting.meetingpost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MeetingPostService {

    @Autowired
    private MeetingPostRepository meetingPostRepository;

    public List<MeetingPost> getAllMeetingPosts() {
        return meetingPostRepository.findAll();
    }

    public Optional<MeetingPost> getMeetingPostById(Long id) {
        return meetingPostRepository.findById(id);
    }

    public MeetingPost createMeetingPost(MeetingPost meetingPost) {
        meetingPost.setTime(LocalDateTime.now());
        return meetingPostRepository.save(meetingPost);
    }

    public MeetingPost updateMeetingPost(Long id, MeetingPost meetingPostDetails) {
        MeetingPost meetingPost = meetingPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MeetingPost not found"));

        meetingPost.setTitle(meetingPostDetails.getTitle());
        meetingPost.setContent(meetingPostDetails.getContent());
        meetingPost.setCommentCount(meetingPostDetails.getCommentCount());
        meetingPost.setViewCount(meetingPostDetails.getViewCount());
        meetingPost.setAuthor(meetingPostDetails.getAuthor());

        return meetingPostRepository.save(meetingPost);
    }

    public void deleteMeetingPost(Long id) {
        MeetingPost meetingPost = meetingPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MeetingPost not found"));
        meetingPostRepository.delete(meetingPost);
    }
}

