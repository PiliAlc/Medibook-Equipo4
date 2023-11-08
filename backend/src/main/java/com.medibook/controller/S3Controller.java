package com.medibook.controller;/*package com.medibook.controller;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.security.SecureRandom;
import java.util.Date;

@RestController
public class S3Controller {
    private static final String REGION = "us-east-1";
    private static final String BUCKET_NAME = "1023c07-grupo4";
    private static final String ACCESS_KEY_ID = "AKIAY3PLHSUJMQAM2NK3";
    private static final String SECRET_ACCESS_KEY = "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";

    @GetMapping("/s3Url")
    public String getS3Url() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(ACCESS_KEY_ID, SECRET_ACCESS_KEY);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(REGION)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();

        try {
            String imageName = generateImageName();
            URL url = generateUploadURL(s3Client, imageName);
            System.out.println("URL de S3: " + url.toString());
            return url.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al generar la URL de S3: " + e.getMessage();
        }
    }

    private String generateImageName() throws Exception {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);
        return "roomImages/" + bytes.toString();
    }

    private URL generateUploadURL(AmazonS3 s3Client, String imageName) {
        Date expiration = new Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 60; // Add 1 hour.
        expiration.setTime(expTimeMillis);

        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(BUCKET_NAME, imageName)
                        .withMethod(com.amazonaws.HttpMethod.PUT)
                        .withExpiration(expiration);

        return s3Client.generatePresignedUrl(generatePresignedUrlRequest);
    }
}*/