/**
 * Design a class Marksheet, which reads in grades of n no of students. Assume n
 * as a positive integer and grades will be between 0 and 100 both inclusive.
 * 
 * @author kunal
 *
 */
public class Marksheet {
	/**
	 * @param grades , float type array
	 * @param arraySize ,int type
	 * @return average of the student , float type
	 * @throws Exception
	 */
	public float average(float[] grades, int arraySize) throws Exception {
		if (arraySize <= 0) {
			throw (new Exception("Exception : divide by zero"));
		}
		int sum = 0;
		for (int index = 0; index < grades.length; index++) {
			sum += grades[index];
		}
		return (sum / arraySize);
	}

	/**
	 * @param grades , float type array
	 * @return max ,float type
	 */
	public float maxGrade(float[] grades) {
		float max = Integer.MIN_VALUE;
		for (int index = 0; index < grades.length; index++) {
			if (grades[index] > max) {
				max = grades[index];
			}
		}
		return max;
	}

	/**
	 * @param grades , float type array
	 * @return min ,float type
	 */
	public float minGrade(float[] grades) {
		float min = Integer.MAX_VALUE;
		for (int index = 0; index < grades.length; index++) {
			if (grades[index] < min) {
				min = grades[index];
			}
		}
		return min;
	}

	/**
	 * @param grades , float type array
	 * @param arraySize , int type
	 * @return percentage of the students
	 */
	public float percentStudentPass(float[] grades, int arraySize) {
		float count = 0;
		for (int index = 0; index < grades.length; index++) {
			if (grades[index] >= 40)
				count++;
		}
		float per = ((count / arraySize) * 100);
		return per;
	}


}