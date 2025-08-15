package com.example.jmx.dto.response;

import java.util.List;

import com.example.jmx.aop.Profile;

@Profile
public record LotteryDTO(List<Integer> numbers) {

}
