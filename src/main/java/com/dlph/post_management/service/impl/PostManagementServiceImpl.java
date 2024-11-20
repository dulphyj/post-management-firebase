package com.dlph.post_management.service.impl;

import com.dlph.post_management.dto.PostDTO;
import com.dlph.post_management.firebase.FirebaseInitializer;
import com.dlph.post_management.service.PostManagementService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firestore.v1.TransactionOptions;
import lombok.Locked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
public class PostManagementServiceImpl implements PostManagementService {
    @Autowired
    private FirebaseInitializer firebaseInitializer;

    @Override
    public List<PostDTO> list() {
        List<PostDTO> response = new ArrayList<>();
        PostDTO post;
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for(DocumentSnapshot doc: querySnapshotApiFuture.get().getDocuments()){
                post = doc.toObject(PostDTO.class);
                post.setId(doc.getId());
                response.add(post);
            }
            return response;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Boolean add(PostDTO postDTO) {
        Map<String, Object> docData = getObjectMap(postDTO);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);
        try{
            if(writeResultApiFuture.get() != null){
                return Boolean.TRUE;
            } return  Boolean.FALSE;
        } catch (Exception e){
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean edit(String id, PostDTO postDTO) {
        Map<String, Object> docData = getObjectMap(postDTO);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).set(docData);
        try{
            if(writeResultApiFuture.get() != null){
                return Boolean.TRUE;
            } return  Boolean.FALSE;
        } catch (Exception e){
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean delete(String id) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).delete();
        try{
            if(writeResultApiFuture.get() != null){
                return Boolean.TRUE;
            } return  Boolean.FALSE;
        } catch (Exception e){
            return Boolean.FALSE;
        }
    }

    private CollectionReference getCollection() {
        return firebaseInitializer.getFirestore().collection("post");
    }

    private static Map<String, Object> getObjectMap(PostDTO postDTO) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("title", postDTO.getTitle());
        docData.put("content", postDTO.getContent());
        return docData;
    }
}
