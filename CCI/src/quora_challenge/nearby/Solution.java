package quora_challenge.nearby;
/*
 * URL: http://www.quora.com/challenges
 * 
 * Topics on Quora have location data optionally associated with them, allowing the Quora Nearby feature for our iPhone app. Each question on Quora can have one or more topics associated with it. This feature allows us to display topics and questions near different locations, be it the user's current location, or a specified location on the map.

Your task will be to write a program that will be able to find topics or questions that are near to a given input location, up to a specified limit.

Input format (read from STDIN):
The first line of input will be 3 integers: number of topics T, number of questions Q, and number of queries N.

There will be T lines following that, each with a topic id integer, and two doubles representing that topic's location (you can consider the points to be located on a XY plane, location of a entity is in form of its x and y coordinate in the plane).

There will be Q lines following that, each with a question id integer and number of topics the question is associated with, Qn, followed by Qn number of topic ids associated with that question. These integers are guaranteed to be well-formed existing topics.  There may be 0 topics associated with a question, and in such cases, the question should never appear in the query results.

The next N lines will consist of a char, an integer and two doubles each, representing the type of results required ("t" for topic or "q" for question), the number of results required, and the location to be used as the query.

Sample Input:

3 6 2
0 0.0 0.0
1 1.0 1.0
2 2.0 2.0
0 1 0
1 2 0 1
2 3 0 1 2
3 0
4 0
5 2 1 2
t 2 0.0 0.0
q 5 100.0 100.0


Output format (write to STDOUT):
For each query line given in the input, you are to output the ids of the nearest entities in ascending order of distance from the query location, up to the specified number of results.  When there is a tie between different entities in the ordering due to equal distances (threshold of 0.001 for equality comparisons), the entity with the larger id should be ranked first.

Distance of a question from a point is the minimum of the distance of all topics associated with that question.

Sample Output:
0 1
5 2 1 0


Explanation:
There are 3 topics with ids 0, 1 and 2. There are also 6 questions, with ids 0 to 5. We first ask a nearest topic query. 
The closest 2 topics to (0.0, 0.0) are topics 0 and 1.
The next query asks for upto 5 closest questions to (100.0, 100.0). Since questions 5 and 2 are tagged with topic 2 located at (2.0, 2.0), they are closest to the query location.
Because of the tie in distance, we put question 5 before question 2.
The next closest question is question 1, followed by question 0.
We do not output questions 3 or 4 because there are no topics associated with them.

Constraints:
1 <= T <= 10000
1 <= Q <= 1000
1 <= N <= 10000
Integer ids are between 0 and 100000 inclusive.
Number of topics associated with a question is not more than 10.
The number of results required for a query is not more than 100.
0.0 <= x,y <= 1000000.0 (10^6)

For the large testcases, all topic x,y co-ordinates will be approximately uniformly distributed over the bounds.

You should aim to have your algorithm be fast enough to solve our largest test inputs in under 5 seconds, or be as close to that as possible.
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * @author Bolun
 *
 */
class Topic implements Comparable<Topic> {
	int topicId;
	double x = 0.0;
	double y = 0.0;
	double dist = 0.0; // distance to target co-ord
	Topic(int _id, double _x, double _y) {
		topicId = _id;
		x = _x;
		y = _y;
	}
	
	void distToTarget(double _tx, double _ty) {
		dist = Math.sqrt(Math.pow(x-_tx, 2)+Math.pow(y-_ty, 2));
	}
	
	int getId() {
		return topicId;
	}
	/**
	 * Comparable interface for sorting
	 */
	public int compareTo(Topic t) {
		if (dist > t.dist) return 1;
		else if (dist < t.dist) return -1;
		else return 0;
	}
}

class Question implements Comparable<Question> {
	int questionId;
	int topicCount = 0;
	double mindistance = Double.MAX_VALUE; // the minimum distance
	double tieDistance = 0.0; // the distance in tie <Avg. Dist. of all related topics>
	ArrayList<Topic> topicList = new ArrayList<Topic>();
	
	Question(int _id, int _count) {
		questionId = _id;
		topicCount = _count;
	}
	
	void addTopic(Topic t) {
		topicList.add(t);
	}
	
	int getId() {
		return questionId;
	}
	
	void DistanceToTarget(double _tx, double _ty) {
		double sum = 0.0;
		for (Topic t : topicList) {
			double dist = Math.sqrt(Math.pow(_tx-t.x, 2)+Math.pow(_ty-t.y, 2));
			if (dist < mindistance) {
				mindistance = dist;
			}
			sum += dist;
		}
		tieDistance = sum / topicList.size();
	}
	
	public int compareTo(Question q) {
		if (mindistance > q.mindistance) return 1;
		else if (mindistance < q.mindistance) return -1;
		else {
			if (tieDistance > q.tieDistance) return 1;
			else if (tieDistance < q.tieDistance) return -1;
			else return 0;
		}
	}
}

class Query {
	String type;
	int RequestNum;
	double tx; // target x coor
	double ty; // target y coor
	public Query(String _type, int _RequestNum, double _x, double _y) {
		type = _type;
		RequestNum = _RequestNum;
		tx = _x;
		ty = _y;
	}

}

public class Solution {
	
	public int numTopic; // number of topics
	public int numQuestion; // number of questions
	public int numQuery; // number of queries
	public Topic[] topicArray; // array of topics
	public Question[] questionArray; // array of questions
	public Query[] queryArray; // array of queries
	
	
	public void readFromFILE() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C://Users//Bolun//git//bolunCCI//CCI//src//quora_challenge//testcase1.txt"));
			String[] input;
			input = br.readLine().split(" ");
			for (int i = 0; i < input.length; i++) {
				if (i == 0) numTopic = Integer.parseInt(input[0]);
				if (i == 1) numQuestion = Integer.parseInt(input[1]);
				if (i == 2) numQuery = Integer.parseInt(input[2]);
				if (i > 2) break;
			}
			int count = 0;
			// read topics
			topicArray = new Topic[numTopic]; // **Array of topics**
			HashMap<Integer, Topic> topicMap = new HashMap<Integer, Topic>(); // **Map of topics**
			String line;
			while (count < numTopic) {
				line = br.readLine();
				String[] topic = line.split(" ");
				topicArray[count] = new Topic(Integer.parseInt(topic[0]), Double.parseDouble(topic[1]), Double.parseDouble(topic[2]));
				topicMap.put(Integer.parseInt(topic[0]), topicArray[count]);
				count++;
			}
			// read questions
			count = 0; // reset
			questionArray = new Question[numQuestion]; // **Array of questiones**
			while (count < numQuestion) {
				line = br.readLine();
				String[] question = line.split(" ");
				Question q = new Question(Integer.parseInt(question[0]), Integer.parseInt(question[1]));
				for (int i = 2; i < question.length; i++) {
					q.addTopic(topicMap.get(Integer.parseInt(question[i])));
				}
				questionArray[count] = q; // add to question array
				count++;
			}
			
			// read queries
			count = 0; // reset
			queryArray = new Query[numQuery]; // **Array of queries**
			while (count < numQuery) {
				line = br.readLine();
				String[] query = line.split(" ");
				queryArray[count] = new Query(query[0], Integer.parseInt(query[1]), Double.parseDouble(query[2]), Double.parseDouble(query[3]));
				count++;
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	
	/**
	 * @author Bolun
	 */
	public void readFromSTDIN() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input;
			input = br.readLine().split(" ");
			for (int i = 0; i < input.length; i++) {
				if (i == 0) numTopic = Integer.parseInt(input[0]);
				if (i == 1) numQuestion = Integer.parseInt(input[1]);
				if (i == 2) numQuery = Integer.parseInt(input[2]);
				if (i > 2) break;
			}
			int count = 0;
			// read topics
			topicArray = new Topic[numTopic]; // **Array of topics**
			HashMap<Integer, Topic> topicMap = new HashMap<Integer, Topic>(); // **Map of topics**
			String line;
			while (count < numTopic) {
				line = br.readLine();
				String[] topic = line.split(" ");
				topicArray[count] = new Topic(Integer.parseInt(topic[0]), Double.parseDouble(topic[1]), Double.parseDouble(topic[2]));
				topicMap.put(Integer.parseInt(topic[0]), topicArray[count]);
				count++;
			}
			// read questions
			count = 0; // reset
			questionArray = new Question[numQuestion]; // **Array of questiones**
			while (count < numQuestion) {
				line = br.readLine();
				String[] question = line.split(" ");
				Question q = new Question(Integer.parseInt(question[0]), Integer.parseInt(question[1]));
				for (int i = 2; i < question.length; i++) {
					q.addTopic(topicMap.get(Integer.parseInt(question[i])));
				}
				questionArray[count] = q; // add to question array
				count++;
			}
			
			// read queries
			count = 0; // reset
			queryArray = new Query[numQuery]; // **Array of queries**
			while (count < numQuery) {
				line = br.readLine();
				String[] query = line.split(" ");
				queryArray[count] = new Query(query[0], Integer.parseInt(query[1]), Double.parseDouble(query[2]), Double.parseDouble(query[3]));
				count++;
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	/**
	 * @author Bolun
	 * @param q query to be process
	 * @return array of result index
	 */
	public int[] processQuery(Query q) {
		int[] result = initializeResult(q.RequestNum);
		if (q.type.equals("t")) { // query for topics
			for (int i = 0; i < numTopic; i++) {
				topicArray[i].distToTarget(q.tx, q.ty);				
			}
			Arrays.sort(topicArray);
			for (int i = 0; i < Math.min(q.RequestNum, topicArray.length); i++) {
				result[i] = topicArray[i].getId();
			}
		} else if (q.type.equals("q")) { // query for questions
			for (int i = 0; i < numQuestion; i++) {
				questionArray[i].DistanceToTarget(q.tx, q.ty);				
			}
			Arrays.sort(questionArray);
			for (int i = 0; i < Math.min(q.RequestNum, questionArray.length) && questionArray[i].mindistance != Double.MAX_VALUE; i++) {
				result[i] = questionArray[i].getId();
			}
		}
		return result;
	}
	
	public int[] initializeResult(int c) {
		int[] result = new int[c];
		for (int i = 0; i < c; i++) result[i] = -1;
		return result;
	}
	
	public static void main(String[] args) {
		Solution nearBy = new Solution();
		nearBy.readFromSTDIN();
		for (int i = 0; i < nearBy.numQuery; i++) {
			int[] result = nearBy.processQuery(nearBy.queryArray[i]);
			for (int j = 0; j < result.length && result[j] != -1; j++) {
				if (j != 0)
					System.out.print(" "+result[j]);
				else System.out.print(result[j]);
			}
			System.out.println(); // new line
		}
	}
}