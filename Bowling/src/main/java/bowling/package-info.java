/**
 * //TODO consider design, and tackle these challenges!
 * Whenever you set out to write code for a project, you need to think though your design.
 * A major question you need to ask yourself is how complex your design really needs to be.
 * Keep in mind, simpler is always better. You only move away from simple when your features require it.
 * That said, the traditional solution for the Bowling Kata is usually a single class (the game), with players and frames
 * existing as fields within the game.
 * Your solution here might be called too "heavy" given the objective of the kata (just scoring a game), but could be
 * justified if additional features are anticipated in the near future. I wouldn't think to really require a real
 * multi-object solution unless we had more complexity in the rules, but if we did, there are a few things I would expect
 * to see which we don't currently have (e.g. interfaces).
 * If you want to practice your object oriented design, I suggest you build on what you have now and try and tackle
 * these challenges:
 * 1. Your software needs to be able to run a variety of scoring-rule variants that is chosen by the players at the
 * start of the game. Refactor your code to make the normal scoring rules the default. Players can recall the current
 * game type in between rolls, which should display to console the name "Classic".
 * 2. Add a rule variant called "Consistency is Key". If this rule mode is selected at the start of the game, then a new
 * rule is added to the scoring: if a player ends the frame having knocked down less than 10 pins, they have an opportunity
 * for bonus points on their next frame. If they end their next frame having knocked down the exact same number of pins, the first frame counts for double.
 * This effect continues as long as the players knocks down the same number of pins. For example, in the first frame a
 * player rolls twice and knocks down 1 and 3 pins, for a total of 4. On their next frame, they knock down 2 and 2, again
 * for a total of four. At the end of the second frame, the player would earn 4 * 2, 8 points. Gutters, spares, and strikes
 * all still apply, but are not affected by this rule.
 * 3. Add a rule variant called "Consecutive Craze". If this rule mode is selected at the start of the game, then a new rule
 * is added to the scoring: if a player rolls and knocks down less than 10 pins, they have an opportunity for bonus points on their next
 * roll. If their next roll knocks down a number of pins equal to the number of pins knocked down this roll plus one, then the player
 * will multiply the score for the current frame by the number of consecutive rolls achieved. For example, a player rolls
 * a gutter (0), and a 1. The frame ends and is scored as 1 * 2, since there are two consecutive numbers in the frame.
 * If the player goes on in the next frame and rolls a 2 and a 3, that frame is scored as 5 * 4, because there are now
 * four consecutive numbers across the frames. This can apply across frames as well. For example, a set of rolls:
 * 0, 3, 4, 5; would result in a score of 3 for the first frame, and 9 * 3 for the second frame.
 * 4. Allow players to switch the scoring rules during the game. Rules can only be changed between rounds.
 * A round starts with all players on the same frame, and no rolls made for any player. A round ends when all players
 * have completed their roll(s) for the current frame. Changing the scoring rules does not re-score the current frame, or any
 * previous frames (it only affects the scores of future frames).
 * 5. Allow game length to be configurable, separate from the scoring-rules. Players can decide to play a game which has
 * between 4 and 20 Rounds.
 *
 * Adding even one or two of these rule variants would introduce a considerable amount of complexity, which would almost
 * certainly be clearest to implement in an object oriented fashion. In that situation, it would be foolish to try
 * to stuff all of that logic into a single class. But if all you ever need is the default rules outlined in the kata,
 * then you might want to consider just keeping things simple and call it a day with one class.
 */
package bowling;