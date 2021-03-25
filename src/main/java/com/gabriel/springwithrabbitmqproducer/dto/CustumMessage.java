package com.gabriel.springwithrabbitmqproducer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustumMessage {

    private String messageId;
    private String message;
    private Date messageDate;

}
