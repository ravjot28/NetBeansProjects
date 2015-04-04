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
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.model.InstanceType;
import com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient;
import com.amazonaws.services.elasticmapreduce.model.*;
import com.amazonaws.services.elasticmapreduce.util.StepFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: pascal Date: 22-07-13 Time: 20:45
 */
public class NewClass {

    private static final String HADOOP_VERSION = "1.0.3";
    private static int INSTANCE_COUNT = 5;
    private static String INSTANCE_TYPE = InstanceType.M1Small.toString();

    private static final String FLOW_NAME = "test-"+UUID.randomUUID();
    private static final String BUCKET_NAME = "parthfinance";
    private static final String S3N_HADOOP_JAR = "s3n://" + BUCKET_NAME + "/MapReduce-0.0.1-SNAPSHOT.jar";
    private static final String S3N_LOG_URI = "s3n://" + BUCKET_NAME;
    private static final String[] JOB_ARGS = new String[]{"s3n://" + BUCKET_NAME + "/input_twoval",
        "s3n://" + BUCKET_NAME + "/" + FLOW_NAME};
    private static final List<String> ARGS_AS_LIST = Arrays.asList(JOB_ARGS);
    private static final List<JobFlowExecutionState> DONE_STATES = Arrays.asList(new JobFlowExecutionState[]{
        JobFlowExecutionState.COMPLETED, JobFlowExecutionState.FAILED, JobFlowExecutionState.TERMINATED});
    static AmazonS3 s3;
    static AmazonElasticMapReduceClient emr;

    public static void init(String instanceType, String noOfinstances) throws Exception {
        INSTANCE_COUNT = Integer.parseInt(noOfinstances);
        switch (instanceType) {
            case "C1Medium":
                INSTANCE_TYPE = InstanceType.C1Medium.toString();
                break;
            case "C1Xlarge":
                INSTANCE_TYPE = InstanceType.C1Xlarge.toString();
                break;
            case "C32xlarge":
                INSTANCE_TYPE = InstanceType.C32xlarge.toString();
                break;
            case "C34xlarge":
                INSTANCE_TYPE = InstanceType.C34xlarge.toString();
                break;
            case "C38xlarge":
                INSTANCE_TYPE = InstanceType.C38xlarge.toString();
                break;
            case "C3Large":
                INSTANCE_TYPE = InstanceType.C3Large.toString();
                break;
            case "C3Xlarge":
                INSTANCE_TYPE = InstanceType.C3Xlarge.toString();
                break;
            case "Cc14xlarge":
                INSTANCE_TYPE = InstanceType.Cc14xlarge.toString();
                break;
            case "Cc28xlarge":
                INSTANCE_TYPE = InstanceType.Cc28xlarge.toString();
                break;
            case "Cg14xlarge":
                INSTANCE_TYPE = InstanceType.Cg14xlarge.toString();
                break;
            case "Cr18xlarge":
                INSTANCE_TYPE = InstanceType.Cr18xlarge.toString();
                break;
            case "G22xlarge":
                INSTANCE_TYPE = InstanceType.G22xlarge.toString();
                break;
            case "T1Micro":
                INSTANCE_TYPE = InstanceType.T1Micro.toString();
                break;

        }

        //AWSCredentials credentials = new PropertiesCredentials(NewClass.class.getClassLoader().getResourceAsStream(
        //   "AwsCredentials.properties"));
        // s3 = new AmazonS3Client(credentials);
        String secretKey = "kxDFnyETb02UrLr4YT3bRjiET+/FNGUMrE3DrU4j";
        String accessKey = "AKIAII3DXT3OYD5UV4WQ";

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey,
                secretKey);
        s3 = new AmazonS3Client(awsCreds);

        Region usWest2 = Region.getRegion(Regions.US_WEST_2);
        ((AmazonWebServiceClient) s3).setRegion(usWest2);
        emr = new AmazonElasticMapReduceClient(awsCreds);
        emr.setRegion(Region.getRegion(Regions.EU_WEST_1));
    }

    private static JobFlowInstancesConfig configInstance() throws Exception {

        // Configure instances to use
        JobFlowInstancesConfig instance = new JobFlowInstancesConfig();
        instance.setHadoopVersion(HADOOP_VERSION);
        instance.setInstanceCount(INSTANCE_COUNT);
        instance.setMasterInstanceType(INSTANCE_TYPE);
        instance.setSlaveInstanceType(INSTANCE_TYPE);
        //instance.setKeepJobFlowAliveWhenNoSteps(true);
        //instance.setEc2KeyName("parth");

        return instance;
    }

    public static String runCluster() throws Exception {
        long start = System.currentTimeMillis();
        String temp = "";
        // Configure the job flow
        //RunJobFlowRequest request = new RunJobFlowRequest().withName("parth");
       // if (request == null) {
          RunJobFlowRequest  request = new RunJobFlowRequest(FLOW_NAME, configInstance());
            request.setLogUri(S3N_LOG_URI);
       // }

        // Configure the Hadoop jar to use
        HadoopJarStepConfig jarConfig = new HadoopJarStepConfig(S3N_HADOOP_JAR);
        jarConfig.setArgs(ARGS_AS_LIST);

        try {

            StepConfig enableDebugging = new StepConfig().withName("Enable debugging")
                    .withActionOnFailure("TERMINATE_JOB_FLOW")
                    .withHadoopJarStep(new StepFactory().newEnableDebuggingStep());

            StepConfig runJar = new StepConfig(S3N_HADOOP_JAR.substring(S3N_HADOOP_JAR.indexOf('/') + 1), jarConfig);

            request.setSteps(Arrays.asList(new StepConfig[]{enableDebugging, runJar}));

            // Run the job flow
            RunJobFlowResult result = emr.runJobFlow(request);

            // Check the status of the running job
            String lastState = "";

            STATUS_LOOP:
            while (true) {
                DescribeJobFlowsRequest desc = new DescribeJobFlowsRequest(Arrays.asList(new String[]{result
                    .getJobFlowId()}));
                DescribeJobFlowsResult descResult = emr.describeJobFlows(desc);
                for (JobFlowDetail detail : descResult.getJobFlows()) {
                    String state = detail.getExecutionStatusDetail().getState();
                    if (isDone(state)) {
                        System.out.println("Job " + state + ": " + detail.toString());
                        break STATUS_LOOP;
                    } else if (!lastState.equals(state)) {
                        lastState = state;
                        System.out.println("Job " + state + " at " + new Date().toString());
                    }
                }
                Thread.sleep(10000);
            }
            temp = FLOW_NAME;
            long end = System.currentTimeMillis();
            System.out.println("Computation " + (end - start));
        } catch (AmazonServiceException ase) {
            System.out.println("Caught Exception: " + ase.getMessage());
            System.out.println("Reponse Status Code: " + ase.getStatusCode());
            System.out.println("Error Code: " + ase.getErrorCode());
            System.out.println("Request ID: " + ase.getRequestId());
        }
        return temp;
    }

    public static boolean isDone(String value) {
        JobFlowExecutionState state = JobFlowExecutionState.fromValue(value);
        return DONE_STATES.contains(state);
    }

}
