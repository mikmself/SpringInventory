package com.example.inventoryspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usagehistory")
public class UsageHistory {
    @Id
    @GeneratedValue
    private int id;
    private int inventory_id;
    private Date usage_date;
    private int usage_quantity;
}
