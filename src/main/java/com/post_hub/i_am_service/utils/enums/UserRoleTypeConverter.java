package com.post_hub.i_am_service.utils.enums;

import com.post_hub.i_am_service.service.model.IamServiceUserRole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class UserRoleTypeConverter implements AttributeConverter<IamServiceUserRole, String> {

    @Override
    public String convertToDatabaseColumn(IamServiceUserRole iamServiceUserRole) {
        return iamServiceUserRole.name();
    }

    @Override
    public IamServiceUserRole convertToEntityAttribute(String s) {
        return IamServiceUserRole.valueOf(s);
    }
}
