package com.orange.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Member {

	private Long memberId;
	@NonNull private String name;
	@NonNull private String city;
	@NonNull private String Street;
	@NonNull private String zipcode;
	private int point;
}
