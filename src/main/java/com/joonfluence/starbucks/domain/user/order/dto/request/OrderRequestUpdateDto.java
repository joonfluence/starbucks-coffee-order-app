<<<<<<< HEAD
<<<<<<<< HEAD:src/main/java/com/joonfluence/starbucks/domain/user/order/dto/request/OrderRequestUpdateDto.java
package com.joonfluence.starbucks.domain.user.order.dto.request;
========
package com.joonfluence.starbucks.domain.user.order.dto;
>>>>>>>> b8157fe ([CONFIG] Initial Order/Delivery/Admin domain setting):src/main/java/com/joonfluence/starbucks/domain/user/order/dto/OrderUpdateDto.java
=======
package com.joonfluence.starbucks.domain.user.order.dto.request;
>>>>>>> ac42eea (feat(Order): Create Order logic in Order Service Layer)

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestUpdateDto {
    private Long id;
    private String name;
    private int likeCount;
}
