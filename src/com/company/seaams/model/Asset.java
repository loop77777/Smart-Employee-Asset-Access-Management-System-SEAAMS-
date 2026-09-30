package com.company.seaams.model;

public abstract class Asset {
    protected String assetTag;
    protected String assetName;
    protected double assetCost;
    protected int assignedEmployeeId;
    protected boolean isAllocated;

    public Asset(String assetTag, String assetName, double assetCost) {

        this.assetCost = assetCost;
        this.assetName = assetName;
        this.assetTag = assetTag;
        this.assignedEmployeeId = -1;
        this.isAllocated = false;

        // TODO Auto-generated constructor stub
    }

    public String getAssetTag() {
        return assetTag;

    }

    public String getAssetName() {
        return assetName;

    }

    public double getAssetCost() {
        return assetCost;

    }

    public int getAssignedEmployeeId() {
        return assignedEmployeeId;

    }

    public boolean isAllocated() {
        return isAllocated;

    }

    public void setAllocation(int employeeId, boolean state) {
        this.isAllocated = state;
        this.assignedEmployeeId = state ? employeeId : -1;
    }

    public abstract void displayAsset();

}