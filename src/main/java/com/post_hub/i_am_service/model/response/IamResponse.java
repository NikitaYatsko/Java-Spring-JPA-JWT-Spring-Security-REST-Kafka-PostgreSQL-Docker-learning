package com.post_hub.i_am_service.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IamResponse<P> implements Serializable {
    private String message;
    private P payload;
    private boolean success;

    public static <P extends Serializable> IamResponse<P> createSuccesful(P payload) {
        return new IamResponse<>(StringUtils.EMPTY, payload, true);
    }
}
