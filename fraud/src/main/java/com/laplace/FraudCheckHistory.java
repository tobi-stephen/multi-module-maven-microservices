package com.laplace;


import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "FraudCheckHistory")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FraudCheckHistory {

		@Id
		private String id;
		private Integer customerId;
		private Boolean isFraudSter;
		private LocalDateTime createdDate;
}