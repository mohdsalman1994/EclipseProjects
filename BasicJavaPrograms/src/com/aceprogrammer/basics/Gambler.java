package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.aceprogrammer.basics.Utilities.MyUtilities;

public class Gambler {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		System.out.println("We are going to play Gambling!");
		System.out.println("The rules are simple");
		System.out.println("You start with x$ stake and a goal of y$");
		System.out.println("Until you are broke you can keep on betting!");
		System.out.println("What are you waiting for? Let's rumble");
		System.out.println("Enter the beggining stake");
		int stake = Integer.parseInt(br.readLine());
		while(stake < 1)
		{
			System.out.println("Hey you can't start empty handed!");
			System.out.println("Please enter an amount greater than 0");
			stake = Integer.parseInt(br.readLine());
		}
		System.out.println("Enter you goal to be a millionare!");
		int goal = Integer.parseInt(br.readLine());
		while( goal < stake)
		{
			System.out.println("Dear to be millionare, your here to win! So enter an amount greater than your stake!");
			goal = Integer.parseInt(br.readLine());
		}
		MyUtilities.gamble(stake, goal);
		
	}
}
