/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clouddrive.parth;

/**
 *
 * @author ravjotsingh
 */
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class AmazonOperations {

    private AmazonS3 s3;

    public AmazonOperations() {
        String secretKey = "kxDFnyETb02UrLr4YT3bRjiET+/FNGUMrE3DrU4j";
        String accessKey = "AKIAII3DXT3OYD5UV4WQ";

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey,
                secretKey);
        s3 = new AmazonS3Client(awsCreds);

        Region usWest2 = Region.getRegion(Regions.US_WEST_2);
        ((AmazonWebServiceClient) s3).setRegion(usWest2);
    }

    public static void main(String[] args) {
        InputStream is = new ByteArrayInputStream(
                ByteToArray.getByteFromFile(new File(
                                "C:\\Users\\Administrator\\Desktop\\Temp.txt")));
        AmazonOperations a = new AmazonOperations();
        System.out.println(a.isBucketPresent("samta123"));
        // a.s3.createBucket("samta123");
        a.uploadFile(is, "samta123", "samta123");
    }

    public List<String> getFiles(String userName) {
        List<String> list = null;
        if (isBucketPresent(userName)) {
            ObjectListing bucketList = s3.listObjects(new ListObjectsRequest()
                    .withBucketName(userName));
            if (bucketList != null) {
                list = new ArrayList<String>();
            }
            for (S3ObjectSummary objectSummary : bucketList
                    .getObjectSummaries()) {
                list.add(objectSummary.getKey());
            }
        }
        return list;
    }

    public void uploadFile(InputStream is, String fileName, String userName) {
        System.out.println("UploadFile " + userName + " " + fileName);
        if (!isBucketPresent(userName)) {
            s3.createBucket(userName);
        }
        s3.putObject(userName, fileName, is, null);
    }

    private boolean isBucketPresent(String bucketName) {
        boolean present = false;
        for (Bucket bucket : s3.listBuckets()) {
            System.out.println(bucket.getName());
            if (bucket.getName() != null && bucket.getName().equals(bucketName)) {
                present = true;
                break;
            }
        }

        return present;
    }

    public byte[] downloadFile(String fileName, String userName) {
        S3Object object = s3
                .getObject(new GetObjectRequest(userName, fileName));
        byte[] fileBytes = null;
        try {
            IOUtils.copy(object.getObjectContent(), new FileOutputStream(
                    userName + "" + fileName));

            File file = new File(userName + "" + fileName);

            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fis);
            fileBytes = new byte[(int) file.length()];
            inputStream.read(fileBytes);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileBytes;
    }

}
