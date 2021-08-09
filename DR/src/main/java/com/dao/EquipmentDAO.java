package com.dao;

import com.povo.EquipmentEntity;
import java.util.List;

public interface EquipmentDAO {
    void save(EquipmentEntity equipmentEntity);
    void delete(EquipmentEntity equipmentEntity);
    EquipmentEntity findById(Integer id);
    EquipmentEntity findByEquimpent(EquipmentEntity equipmentEntity);
    List findByProperty(String propertyName, Object value);
}
