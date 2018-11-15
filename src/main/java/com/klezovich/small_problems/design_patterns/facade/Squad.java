package com.klezovich.small_problems.design_patterns.facade;

public class Squad {

	SquadMember m1;
	SquadMember m2;
	SquadMember m3;
	
	Squad(){
		m1=new Commander();
		m2=new Sniper();
		m3=new Demolitionist();
	}
	
	void sendOnMission(){
		m1.act();
		m2.act();
		m3.act();
	}
}
