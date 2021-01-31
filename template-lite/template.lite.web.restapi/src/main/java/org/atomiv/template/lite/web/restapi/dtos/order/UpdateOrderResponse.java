package org.atomiv.template.lite.web.restapi.dtos.order;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.order_item.UpdateOrderItemResponse;

import java.util.List;

@Data
public class UpdateOrderResponse {
    private Long id;
    private String orderAddress;
    private Long customerId;
    private String customerFirstName;
    private List<UpdateOrderItemResponse> orderItems;
}