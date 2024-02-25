package com.ADD_S3_Bucket.service;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
@Service
public class S3BucketService {
    @Autowired
    private AmazonS3 s3Client;
    @Value("${aws.s3.bucketName}")
    private String bucketName;
    public String uploadFile(MultipartFile file) {
        try {
            File convertedFile = convertMultiPartFileToFile(file);
            s3Client.putObject(new PutObjectRequest(bucketName, file.getOriginalFilename(), convertedFile));
            return "File uploaded successfully: " + file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error uploading file: " + file.getOriginalFilename();
        }
    }

    public Resource downloadFile(String fileName) {
        S3Object object = s3Client.getObject(new GetObjectRequest(bucketName, fileName));
        S3ObjectInputStream inputStream = object.getObjectContent();
        return new InputStreamResource(inputStream);
    }
    public String deleteFile(String fileName) {
        try {
            s3Client.deleteObject(new DeleteObjectRequest(bucketName, fileName));
            return "File deleted successfully: " + fileName;
        } catch (AmazonServiceException e) {
            e.printStackTrace();
            return "Error deleting file: " + fileName;
        }
    }

    private File convertMultiPartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        }
        return convertedFile;
    }
}
