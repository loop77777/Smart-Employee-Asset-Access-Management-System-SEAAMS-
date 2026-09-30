package com.company.seaams.model;


public class Laptop extends Asset {

	 /*assetService.registerInventoryAsset(new Laptop("LAP1001","MacBook Pro",2499.00));
    assetService.registerInventoryAsset(new Laptop("LAP1002","ThinkPad T14",1350.50));*/

    public Laptop(String assetTag, String assetName, double assetCost) {

        super(assetTag, assetName, assetCost);

    }

    public void displayAsset() {
        System.out.format("TYPE:LAPTOP|Tag:%-8s|Model:%-15s|Cost:$%-8.2f|Status:%s%n", assetTag, assetName, assetCost,
                (isAllocated ? "ALLOCATED TO ID" + assignedEmployeeId : "AVailable"));

    }
}
