package com.cloud.hybrid.ccp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputData implements Serializable {

    @JsonProperty("customerID")
    private String customerID;
    @JsonProperty(" State__")
    private String  State__;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("SeniorCitizen")
    private int SeniorCitizen;
    @JsonProperty("Partner")
    private boolean Partner;
    @JsonProperty("Dependents")
    private boolean Dependents;
    @JsonProperty("tenure")
    private int tenure;
    @JsonProperty("Tech_issue_repo_M1")
    private int Tech_issue_repo_M1;
    @JsonProperty("Tech_issue_repo_M2")
    private int Tech_issue_repo_M2;
    @JsonProperty("Tech_issue_repo_M3")
    private int Tech_issue_repo_M3;
    @JsonProperty("PhoneService")
    private boolean PhoneService;
    @JsonProperty("MultipleLines")
    private String MultipleLines;
    @JsonProperty("TypeOfInternetService")
    private String TypeOfInternetService;
    @JsonProperty("OnlineSecurity")
    private boolean OnlineSecurity;
    @JsonProperty("OnlineBackup")
    private boolean OnlineBackup;
    @JsonProperty("DeviceProtection")
    private boolean DeviceProtection;
    @JsonProperty("TechSupport")
    private boolean TechSupport;
    @JsonProperty("HDStreamingServc")
    private boolean HDStreamingServc;
    @JsonProperty("_4KStreamingServc")
    private boolean _4KStreamingServc;
    @JsonProperty("Contract")
    private String Contract;
    @JsonProperty("SeviceQualityFdback")
    private String SeviceQualityFdback;
    @JsonProperty("PaperlessBilling")
    private boolean PaperlessBilling;
    @JsonProperty("PaymentMethod")
    private String PaymentMethod;
    @JsonProperty("MonthlyCharges")
    private double MonthlyCharges;
    @JsonProperty("TotalCharges")
    private float TotalCharges;
    @JsonProperty("Churn")
    private boolean Churn;

    @JsonProperty("Billing_Erros_M1")
    private int Billing_Erros_M1;
    @JsonProperty("Billing_Errors_M2")
    private int Billing_Errors_M2;
    @JsonProperty("Billing_Errors_M3")
    private int Billing_Errors_M3;
}
