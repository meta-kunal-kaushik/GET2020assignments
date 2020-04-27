
/**
 * Design a class Area to calculate areas for different shapes
 * @author Kunal
 *
 */
public class Area {

	/**
	 * @param width
	 * @param height
	 * @return area of triangle
	 * @throws Exception
	 */
	public double triangleArea(double base,double height)throws Exception{
		if(base < 0 || height < 0){
			throw (new Exception("negative dimension not allowed"));
		}
		double area = (base * height) / 2;
		return area;
	}
	/**
	 * @param width
	 * @param height
	 * @return area of rectangular
	 * @throws Exception
	 */
	public double rectangleArea(double width,double height) throws Exception{
		if( width < 0 || height < 0 ) {
			throw (new Exception("negative dimension not allowed"));
		}
		double area = width * height;
		return area;		
	}
	
	/**
	 * @param radius
	 * @return area of circle
	 * @throws Exception
	 */
	public double circleArea(double radius) throws Exception{
		if( radius < 0 ){
			throw (new Exception("negative dimension not allowed"));
		}
		double area = (3.14) * radius * radius;
		return area;
	}
	
	/**
	 * @param width
	 * @return area of square
	 * @throws Exception
	 */
	public double squareArea(double width) throws Exception{
		if( width < 0 ){
			throw (new Exception("negative dimension not allowed"));
		}
		double area = width * width;
		return area;
	}
	
	
}