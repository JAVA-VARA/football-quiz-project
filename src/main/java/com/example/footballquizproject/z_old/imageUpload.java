//package com.example.footballquizproject.util;
//
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.storage.Blob;
//import com.google.cloud.storage.BlobInfo;
//import com.google.cloud.storage.Storage;
//import com.google.cloud.storage.StorageOptions;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.util.ResourceUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.UUID;
//
//public class imageUpload {
//
//    @Value("${spring.cloud.gcp.storage.credentials.location}")
//    private String keyFileName;
//
//    @Value("${spring.cloud.gcp.storage.bucket}")
//    private String bucketName;
//
//
//    public String exec(MultipartFile multipartFile) throws IOException{
//        InputStream keyfile = ResourceUtils.getURL(keyFileName).openStream();
//
//        String uuid = UUID.randomUUID().toString();
//        String ext = multipartFile.getContentType();
//
//        //인증 자격 증명을 사용하여 Storage 객체 생성
//        Storage storage = StorageOptions.newBuilder()
//                .setCredentials(GoogleCredentials.fromStream(keyfile))
//                .build()
//                .getService();
//
//        String imageUrl = "https://storage.cloud.google.com/football_quiz_project_data/" + bucketName + "/" + uuid;
//
//        if(multipartFile.isEmpty()){
//            imageUrl = null;
//        }else {
//            BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, uuid)
//                    .setContentType(ext).build();
//
//            Blob blob = storage.create(blobInfo, multipartFile.getInputStream());
//        }
//        return imageUrl;
//
//    }
//
//
//
//}
