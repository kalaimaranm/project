package com.bassure.ims.productservice.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssetExcel {

    private Integer empCode;
    private String userName;
    private String batch;
    private String hostName;
    private String office365Licence;
    private String item;
    private String makeManufacturer;
    private String model;
    private String laptopTypeNumber;
    private String serialNumber;
    private String operatingSystem;
    private String processor;
    private String systemName;
    private String hardDiskType;
    private String hardDiskCapacity;
    private Integer totalRamSlots;
    private Integer slotsAvailable;
    private String slot1Capacity;
    private String slot2Capacity;
    private String slot3Capacity;
    private String slot4Capacity;
    private String ddr;
    private String speed;
    private String updatedRamSpeed;
    private String purchasedDate;
    private String soldBy;
    private Long vendorContactsNumber;
    private String vendorMailID;
    private String vendorGST;
    private String billingAddress;
    private String shippingAddress;
    private String warrantyStatus;
    private String warrantyFrom;
    private String  warrantyTo;
    private Double totalAmount;
}