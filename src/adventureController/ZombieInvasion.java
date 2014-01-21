package adventureController;

public class ZombieInvasion
{
	String zombieFriend1;
	String zombieFriend2;
	String zombieFriend3;
	int goodDecisions = 0;
	int goodEvent = 0;

	private int getGoodEvent()
	{
		
		return goodEvent;
	}
	
	
	private String getAFriend()
	{
		int friend = 0;
		double myRandom = Math.random();
		friend = (int) (3 * myRandom);

		if (friend == 0)
			return zombieFriend1;
		else if (friend == 1)
		{
			return zombieFriend2;
		}
		else if (friend == 2)
		{
			return zombieFriend3;
		}

		return zombieFriend1;
	}

	public void startAdventure(String userInput)
	{
		startZombieInvasion(userInput);

	}

	private void startZombieInvasion(String userInput)
	{
		zombieName1(userInput);
		zombieName2(userInput);
		zombieName3(userInput);

		zombieEvent(userInput);
	}

	private String promptName()
	{
		String prompt = "Name your friend.";

		return prompt;
	}

	private void zombieName1(String userInput)
	{
		String userNamed = "";
		promptName();
		zombieFriend1 = userInput;

	}

	private void zombieName2(String userInput)
	{
		String userNamed = "";
		promptName();
		zombieFriend2 = userInput;

	}

	private void zombieName3(String userInput)

	{
		String userNamed = "";
		promptName();
		zombieFriend3 = userInput;

	}

	private void zombieEvent(String userInput)
	{
		if(friendWound(userInput) == true)
			goodDecisions++;
		if(food(userInput) == true)
			goodDecisions++;
		if(zombieBroke(userInput) == true)
			goodDecisions++;
		
		if (goodDecisions >= 2)
			goodEvent++;
			
	}

	/**
	 * Event method. Event - friend is wounded return - persuade its not a bite,
	 * kill friend, or kick out friend.
	 */
	private Boolean friendWound(String userInput)
	{
		boolean goodDecision = false;

		friendWoundPrompt(userInput);

		if (getResponse(userInput).contains("persuade"))
			return goodDecision = true;
		else if (getResponse(userInput).contains("kill"))
			return goodDecision = false;
		else if (getResponse(userInput).contains("kick"))
			return goodDecision = false;

		return goodDecision;
	}

	private String friendWoundPrompt(String userInput)
	{
		String prompt = "Your friend "
				+ getAFriend()
				+ " is wounded, your friends think its a bite from a zombie. \n Do you persuade them its not a bite, kick him out, or put him down?";

		return prompt;
	}

	private String getResponse(String userInput)
	{

		return userInput;
	}

	/**
	 * Event method. Event - Your group needs food.
	 * 
	 * @return - if you go out for food, or if you send someone else.
	 */
	private Boolean food(String userInput)
	{
		boolean goodDecision = false;

		foodPrompt(userInput);

		if (getResponse(userInput).contains("I")
				|| getResponse(userInput).contains("myself"))
			return goodDecision = true;
		else if (getResponse(userInput).contains("him"))
			return goodDecision = false;

		return goodDecision;
	}

	private String foodPrompt(String userInput)
	{
		String prompt = "You ran out of food! "
				+ getAFriend()
				+ " wants to go get the food. \n Do you let him go out and risk his life for food or do you go yourself?";

		return prompt;
	}

	/**
	 * Event method. Event - Zombie breaks into your house, attacks a friend.
	 * 
	 * @return - Help friend, kill friend, kill zombie.
	 */
	private Boolean zombieBroke(String userInput)
	{
		boolean goodDecision = false;

		brokePrompt();

		if (getResponse(userInput).contains("Kill")
				&& !getResponse(userInput).contains("zombie"))
			return goodDecision = false;
		else if (getResponse(userInput).contains("help"))
			return goodDecision = true;
		else if (getResponse(userInput).contains("Kill")
				&& getResponse(userInput).contains("zombie"))
			return goodDecision = true;

		return goodDecision;
	}

	private String brokePrompt()
	{
		String prompt = "A zombie broke in your house and is attacking "
				+ getAFriend()
				+ ".\n Will you help your friend, Kill your friend, kill The Zombie?";

		return prompt;
	}
}
