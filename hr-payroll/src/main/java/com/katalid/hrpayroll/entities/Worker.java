package com.katalid.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker implements Serializable {
    public static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double dailyIncome;
}
