package org.atomiv.template.lite.web.restapi.dtos.order;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.order_item.GetAllOrderItemsRecordResponse;

import java.util.List;

// TODO this is the same as GetOrderResponse, why have it?
@Data
public class GetAllOrdersRecordResponse {
    private Long id;
    private String orderAddress;
    private Long customerId;
    private String customerFirstName;
    private List<GetAllOrderItemsRecordResponse> orderItems;
}
