/**
 * Design a class Marksheet, which reads in grades of n no of students. Assume n
 * as a positive integer and grades will be between 0 and 100 both inclusive.
 * 
 * @author kunal
 *
 */
public class Marksheet {
	/**
	 * @param grades
	 * @param n
	 * @return average of the student
	 * @throws Exception
	 */
	public float average(float[] grades, int n) throws Exception {
		if (n <= 0) {
			throw (new Exception("Exception : divide by zero"));
		}
		int sum = 0;
		for (int i = 0; i < grades.length; i++) {
			sum += grades[i];
		}
		return (sum / n);
	}

	/**
	 * @param grades
	 * @return max_grade
	 */
	public float maxGrade(float[] grades) {
		float max = Integer.MIN_VALUE;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] > max) {
				max = grades[i];
			}
		}
		return max;
	}

	/**
	 * @param grades
	 * @return min grade
	 */
	public float minGrade(float[] grades) {
		float min = Integer.MAX_VALUE;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] < min) {
				min = grades[i];
			}
		}
		return min;
	}

	/**
	 * @param grades
	 * @param n
	 * @return percentage of the students
	 */
	public float percentStudentPass(float[] grades, int n) {
		float count = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= 40)
				count++;
		}
		float per = ((count / n) * 100);
		return per;
	}


}