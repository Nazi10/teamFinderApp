package com.fullsecurity.fullsecurity.controllers;

import com.fullsecurity.fullsecurity.models.FriendsList;
import com.fullsecurity.fullsecurity.services.FriendListService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/friend-list")
@SecurityRequirement(name = "bearerAuth")
public class FriendListController {

    private static final Logger logger = LoggerFactory.getLogger(FriendListController.class);

    private final FriendListService friendListService;

    public FriendListController(FriendListService friendListService) {
        this.friendListService = friendListService;
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<FriendsList>> getAllFriendsList() {
        logger.debug("Request to get all friends list");
        try {
            return ResponseEntity.ok(friendListService.friendsList());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
