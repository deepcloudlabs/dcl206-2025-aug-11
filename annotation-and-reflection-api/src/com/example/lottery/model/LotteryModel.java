package com.example.lottery.model;

import java.util.List;

import com.example.lottery.annotation.RandomNumber;

public class LotteryModel {
	@RandomNumber(max = 60, size = 6)
	private List<Integer> numbers;

	public List<Integer> getNumbers() {
		return numbers;
	}

}
