package com.seguro.polizas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class AwsConfig {

    @Value("${AWS_ACCESS_KEY}")
    private String awsAccessKey ;

    @Value("${AWS_SECRET_KEY}")
    private String awsSecretKey;

    @Bean
    public SnsClient snsClient() {
        String awsAcessKeySns = awsAccessKey;
        String awsSecretKeySns = awsSecretKey;
        return SnsClient.builder()
                .region(Region.of("us-east-1"))
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(
                        awsAcessKeySns,
                        awsSecretKeySns)))
                .build();
    }
}