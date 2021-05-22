package com.um.apitest.order.response;

public class CancelResponse {

    private int order_id;
    private String status;

    public CancelResponse(int order_id, String status) {
        this.order_id = order_id;
        this.status = status;
    }

    public CancelResponse() { }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
