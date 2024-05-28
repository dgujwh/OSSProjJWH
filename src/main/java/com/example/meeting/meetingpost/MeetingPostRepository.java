package com.example.meeting.meetingpost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingPostRepository extends JpaRepository<MeetingPost, Long> {
}
