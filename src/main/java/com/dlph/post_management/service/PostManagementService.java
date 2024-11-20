package com.dlph.post_management.service;

import com.dlph.post_management.dto.PostDTO;

import java.util.List;

public interface PostManagementService {
    List<PostDTO> list();
    Boolean add(PostDTO postDTO);
    Boolean edit(String id, PostDTO postDTO);
    Boolean delete(String id);
}
