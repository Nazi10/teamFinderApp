package com.fullsecurity.fullsecurity.controllers;


import com.fullsecurity.fullsecurity.dto.FriendRequestDto;
import com.fullsecurity.fullsecurity.models.FriendRequest;
import com.fullsecurity.fullsecurity.payload.response.ApiResponse;
import com.fullsecurity.fullsecurity.services.FriendRequestService;
import com.google.api.Http;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/friend-request")
@SecurityRequirement(name = "bearerAuth")
public class FriendRequestController {

    private static final Logger logger = LoggerFactory.getLogger(FriendRequestController.class);

    private final FriendRequestService friendRequestService;

    public FriendRequestController(FriendRequestService friendRequestService) {
        this.friendRequestService = friendRequestService;
    }

    @PostMapping("/addFriendRequest")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ApiResponse> addFriendRequest(@RequestParam Long id) {
        logger.debug("Add friend request");
        try {
            this.friendRequestService.addFriendRequest(id);
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, "Kërkesa pë match u shtua me sukses"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Ka ndodhur një problem!"));
        }
    }

    @PostMapping("/acceptOrRejectRequest")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ApiResponse> acceptOrRejectRequest(@RequestParam Boolean status, @RequestParam Long requestId) {
        logger.debug("Accept/Reject friend request");
        try {
            this.friendRequestService.acceptOrRejectFriendRequest(status, requestId);
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, "Pergjigja u dergua me sukses!"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Ka ndodhur nje problem!"));
        }
    }

    @GetMapping("/getAllActiveRequests")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<FriendRequestDto>> getAllActiveRequests() {
        logger.debug("Requests to get all friend request");
        try {
            return ResponseEntity.ok(this.friendRequestService.getAllRequests());
        } catch (Exception e) {
            e.printStackTrace();;
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
