package com.bharath.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.bharath.entity.Player;
import com.bharath.service.PlayerService;

public class PlayerServiceImpl implements PlayerService{

	@Override
	public void SortByName(List<Player> playerList) {
		Collections.sort(playerList,new Comparator<Player>() {

			@Override
			public int compare(Player o1, Player o2) {
				
				return o1.getAge()-o2.getAge();
			}
			
		});
	}

}
