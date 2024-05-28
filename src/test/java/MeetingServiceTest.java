import com.example.meeting.meetingpost.MeetingPost;
import com.example.meeting.meetingpost.MeetingPostService;
import com.example.meeting.meetings.Meeting;
import com.example.meeting.meetings.MeetingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetingServiceTest {

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private MeetingPostService meetingPostService;

    @Test
    public void testGetMeetingById() {
        Meeting meeting = meetingService.getMeetingById(1L);
        assertNotNull(meeting);
        assertEquals("Expected meeting title", "Example Meeting", meeting.getTitle());
    }

    @Test
    public void testCreateMeetingPost() {
        Meeting meeting = meetingService.getMeetingById(1L);
        MeetingPost meetingPost = new MeetingPost();
        meetingPost.setContent("Test content");
        meetingPost.setMeeting(meeting);

        MeetingPost savedMeetingPost = meetingPostService.createMeetingPost(meetingPost);
        assertNotNull(savedMeetingPost);
        assertNotNull(savedMeetingPost.getId());
        assertEquals(meeting.getId(), savedMeetingPost.getMeeting().getId());
    }
}
