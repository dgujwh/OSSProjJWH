package com.example.meeting.meetingpost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meetingPosts")
public class MeetingPostController {

    @Autowired
    private MeetingPostService meetingPostService;

    @GetMapping
    public List<MeetingPost> getAllMeetingPosts() {
        return meetingPostService.getAllMeetingPosts();
    }

    @GetMapping("/{id}")
    public MeetingPost getMeetingPostById(@PathVariable Long id) {
        return meetingPostService.getMeetingPostById(id)
                .orElseThrow(() -> new RuntimeException("MeetingPost not found"));
    }

    @PostMapping
    public MeetingPost createMeetingPost(@RequestBody MeetingPost meetingPost) {
        return meetingPostService.createMeetingPost(meetingPost);
    }

    @PutMapping("/{id}")
    public MeetingPost updateMeetingPost(@PathVariable Long id, @RequestBody MeetingPost meetingPostDetails) {
        return meetingPostService.updateMeetingPost(id, meetingPostDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMeetingPost(@PathVariable Long id) {
        meetingPostService.deleteMeetingPost(id);
    }
}

