package com.sparta.board.controller;

import com.sparta.board.common.ApiResponseDto;
import com.sparta.board.common.SuccessResponse;
import com.sparta.board.dto.CommentRequestDto;
import com.sparta.board.dto.CommentResponseDto;
import com.sparta.board.entity.User;
import com.sparta.board.service.CommentService;
import com.sparta.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;

    // 댓글 작성
    @PostMapping("/comment/{id}")   // 여기서 ID는 게시글의 id
    public ApiResponseDto<CommentResponseDto> createComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto, @RequestParam Long userId) {
        User user = userService.getUserById(userId);
        return commentService.createComment(id, requestDto, user);
    }

    // 댓글 수정
    @PutMapping("/comment/{id}")    // 여기서 ID는 댓글의 id
    public ApiResponseDto<CommentResponseDto> updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto, @RequestParam Long userId) {
        User user = userService.getUserById(userId);
        return commentService.updateComment(id, requestDto, user);
    }

    // 댓글 삭제
    @DeleteMapping("/comment/{id}")     // 여기서 ID는 댓글의 id
    public ApiResponseDto<SuccessResponse> deleteComment(@PathVariable Long id, @RequestParam Long userId) {
        User user = userService.getUserById(userId);
        return commentService.deleteComment(id, user);
    }

}
