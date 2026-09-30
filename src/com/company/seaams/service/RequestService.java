package com.company.seaams.service;

import java.util.LinkedList;
import java.util.Queue;

public class RequestService {
    private final Queue<ServiceRequest> executionQueue = new LinkedList<>();

    public void raiseRequest(ServiceRequest request) {
        if (request == null) {
            System.out.println("[ERROR] Request payload is empty.");
            return;
        }

        executionQueue.offer(request);
        System.out.println("[SUCCESS] Service request ticket queued: " + request.getRequestId()
                + " for employee " + request.getEmployeeId());
    }

    public void processNextRequest() {
        ServiceRequest request = executionQueue.poll();
        if (request == null) {
            System.out.println("[INFO] No pending service requests in queue.");
            return;
        }

        request.setStatus("CLOSED");
        System.out.println("[PROCESSED] " + request);
    }

    public void listPendingRequests() {
        if (executionQueue.isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }

        for (ServiceRequest request : executionQueue) {
            System.out.println(request);
        }
    }
}
