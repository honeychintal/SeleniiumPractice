package com.banking.testCases;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.testng.annotations.Test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class S3BucketOperations {
    final String region = "ap-south-1";
    final String bucket_name = "aws-cloudtrail-logs-245505345735-2a4be5bf";
    final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(region).build();

    @Test
    public void gets3Buckets() {
        List<Bucket> buckets = s3.listBuckets();
        System.out.println("Your Amazon S3 buckets are:");
        for (Bucket b : buckets) {
            System.out.println("* " + b.getName());
        }
    }
    @Test
    public void getBucketObjectslist()
    {
        String bucket_name = "aws-cloudtrail-logs-245505345735-2a4be5bf";
        System.out.format("Objects in S3 bucket %s:\n", bucket_name);
        ListObjectsV2Result result = s3.listObjectsV2(bucket_name);
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        for (S3ObjectSummary os : objects) {
            System.out.println("* " + os.getKey());
        }
    }
    @Test
    public void downloadBucketObject()
    {
        String key_name = "schedule_response.json";
        String dir_location = System.getProperty("user.dir")+"\\AWSDownloads\\";
        System.out.format("Downloading %s from S3 bucket %s...\n", key_name, bucket_name);
        try {
            S3Object o = s3.getObject(bucket_name, key_name);
            S3ObjectInputStream s3is = o.getObjectContent();
            FileOutputStream fos = new FileOutputStream(dir_location+key_name);
            byte[] read_buf= s3is.readAllBytes();
            fos.write(read_buf);
            s3is.close();
            fos.close();
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Done!");
    }
}
