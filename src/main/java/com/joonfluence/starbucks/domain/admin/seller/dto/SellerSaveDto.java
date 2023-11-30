<<<<<<<< HEAD:src/main/java/com/joonfluence/starbucks/domain/admin/seller/dto/SellerSaveDto.java
package com.joonfluence.starbucks.domain.admin.seller.dto;
========
package com.joonfluence.starbucks.domain.user.order.dto;
>>>>>>>> b8157fe ([CONFIG] Initial Order/Delivery/Admin domain setting):src/main/java/com/joonfluence/starbucks/domain/user/order/dto/OrderSaveDto.java

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
<<<<<<<< HEAD:src/main/java/com/joonfluence/starbucks/domain/admin/seller/dto/SellerSaveDto.java
public class SellerSaveDto {
========
public class OrderSaveDto {
    private Long customerId;
>>>>>>>> b8157fe ([CONFIG] Initial Order/Delivery/Admin domain setting):src/main/java/com/joonfluence/starbucks/domain/user/order/dto/OrderSaveDto.java
    private String name;
}
