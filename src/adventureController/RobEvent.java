package adventureController;

public class RobEvent
{

		int goodDecisions = 0;
		int goodEvent = 0;

		private int getGoodEvent()
		{
			return goodEvent;
		}
		

		public void startAdventure(String userInput)
		{
			startRobEvent(userInput);

		}

		private void startRobEvent(String userInput)
		{
			robEvent(userInput);
			
		}

		private String promptName()
		{
			String prompt = "Name your friend.";

			return prompt;
		}

		
		private void robEvent(String userInput)
		{
			if(armedRobber(userInput) == true)
				goodDecisions++;
			if(unarmedRobber(userInput) == true)
				goodDecisions++;
			if(homelessRobber(userInput) == true)
				goodDecisions++;
			
			if (goodDecisions >= 2)
				goodEvent++;
				
		}

		/**
		 * Event method. Event - friend is wounded return - persuade its not a bite,
		 * kill friend, or kick out friend.
		 */
		private Boolean armedRobber(String userInput)
		{
			boolean goodDecision = false;

			armedRobberPrompt(userInput);

			if (getResponse(userInput).contains("give"))
				return goodDecision = true;
			else if (getResponse(userInput).contains("suffocate") || getResponse(userInput).contains("kill"))
				return goodDecision = false;
			else if (getResponse(userInput).contains("throw"))
				return goodDecision = false;

			return goodDecision;
		}

		private String armedRobberPrompt (String userInput)
		{
			String prompt ="A robber breaks into your house and he's armed with a gun and he wants YOUR PUDDING"+"\n do you give him the pudding, suffocate him with pudding, or throw pudding at him";

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
		private Boolean unarmedRobber(String userInput)
		{
			boolean goodDecision = false;

			unarmedRobberPrompt(userInput);

			if (getResponse(userInput).contains("give"))
				return goodDecision = true;
			else if (getResponse(userInput).contains("beat"))
				return goodDecision = false;

			return goodDecision;
		}

		private String unarmedRobberPrompt(String userInput)
		{
			String prompt = "An unarmed robber breaks into your home looking for all your left socks. \n Will you give him your socks, beat him with a sock filled with frozen butter,";

			return prompt;
		}

		/**
		 * Event method. Event - Zombie breaks into your house, attacks a friend.
		 * 
		 * @return - Help friend, kill friend, kill zombie.
		 */
		private Boolean homelessRobber(String userInput)
		{
			boolean goodDecision = false;

			homelessRobberPrompt();

			if (getResponse(userInput).contains("give") || !getResponse(userInput).contains("ice"))
				return goodDecision = true;
			else if (getResponse(userInput).contains("no"))
				return goodDecision = false;
			else if (getResponse(userInput).contains("give") || getResponse(userInput).contains("ice"))
				return goodDecision = true;

			return goodDecision;
		}

		private String homelessRobberPrompt()
		{
			String prompt = "A homeless robber broke into your house and looking for love because he was the redheaded unwanted stepchild of the family. " +
					"\n Give him a long hug, tell him no, or give him chocolate ice cream?";

			return prompt;
		}
	

}
