package com.company.seaams.service;

import java.util.ArrayList;
import java.util.List;
import com.company.seaams.model.Asset;

public class AssetService {
    private final List<Asset> assetInventory = new ArrayList<Asset>();

    /*assetService.registerInventoryAsset(new Laptop("LAP1001","MacBook Pro",2499.00));
    assetService.registerInventoryAsset(new Laptop("LAP1002","ThinkPad T14",1350.50));
    assetService.registerInventoryAsset(new Mobile("MOB2001","iPhone 15 Pro",1099.00));
    assetService.registerInventoryAsset(new Mobile("MOB2002","Galaxy S24",899.99));*/

    public void registerInventoryAsset(Asset asset) {
        assetInventory.add(asset);
    }

    public boolean allocateAsset(String assetTag, int employeeId) {
        for (Asset asset : assetInventory) {
            if (asset.getAssetTag().equalsIgnoreCase(assetTag)) {
                if (asset.isAllocated()) {
                    System.out.println(
                            "[DENIED] Asset is already allocated to Employee ID " + asset.getAssignedEmployeeId());
                    return false;
                }
                asset.setAllocation(employeeId, true);
                System.out.println(
                        "[SUCCESS] Allocated " + asset.getAssetTag() + " directly to Employee ID " + employeeId);
                return true;
            }
        }
        System.out.println("[ERROR] Requested asset tag configuration not found in registry.");
        return false;
    }

    public boolean deallocateAsset(String assetTag) {
        for (Asset asset : assetInventory) {
            if (asset.getAssetTag().equalsIgnoreCase(assetTag)) {
                if (!asset.isAllocated()) {
                    System.out.println("[SKIPPED] Target asset is already unassigned.");
                    return false;
                }
                asset.setAllocation(-1, false);
                System.out
                        .println("[SUCCESS] Asset tag " + asset.getAssetTag() + " returned to available stock pools.");
                return true;
            }
        }
        System.out.println("[ERROR] Asset tag context trace not found.");
        return false;
    }

    public void displayAllAssets() {
        if (assetInventory.isEmpty()) {
            System.out.println("Inventory system empty.");
            return;
        }
        for (Asset asset : assetInventory) {
            asset.displayAsset();
        }
    }
}
