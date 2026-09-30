package com.company.seaams.model;




public class Mobile extends Asset {
	
	/* assetService.registerInventoryAsset(new Mobile("MOB2001","iPhone 15 Pro",1099.00));
	    assetService.registerInventoryAsset(new Mobile("MOB2002","Galaxy S24",899.99));*/

    public Mobile(String assetTag, String assetName, double assetCost) {
        super(assetTag, assetName, assetCost);
    }

    public void displayAsset() {
        System.out.format("TYPE:mobile|tag:%-8s|Model:%-15s|Cost:$%-8.2f|Status:%s%n", assetTag, assetName, assetCost,
                (isAllocated ? "allocated to id" + assignedEmployeeId : "available"));

    }
}