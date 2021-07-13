# Search-Algorithm
# Problem description:
	A group of K persons (K > 1) want to cross a bridge from East to West during the
	night. The persons that are crossing the bridge must use a flashlight. There is only
	one flashlight. The bridge is very narrow and allows two persons to cross
	it at the same time at most. Two persons go from east to west and one person returns with
	the flashlight from west to east. If the two persons are crossing the bridge together,
	they are crossing it at the speed of the slower one. These people are trying to cross
	the bridge as quickly as possible.
	Use 3 search strategies (UCS, IDS and A*) to find the best order for these persons to cross the bridge.
# Input file:
	For each test case:
	a. K, number of people
	b. A list of K numbers, showing the time required by each person to pass to the other side.
# Output:
	Your program should printout the following information for each search strategy:
	1) Sequence of trips taken by the group along with direction of each trip for each strategy (solution)
	2) Total time required to have all K people crossing using each strategy (solution cost).
	3) Total number of generated nodes (Search time) for each strategy
	4) Maximum number of nodes concurrently stored in the system (Space requirement) for each strategy.
