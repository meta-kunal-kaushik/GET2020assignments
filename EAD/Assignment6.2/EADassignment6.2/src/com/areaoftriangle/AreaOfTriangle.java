package com.areaoftriangle;

public class AreaOfTriangle {

    public double area(double side1,double side2,double side3) {
        double perimeter = (side1+side2+side3)/2;
        double area = (double)Math.sqrt((perimeter)*(perimeter-side1)*(perimeter-side2)*(perimeter-side3));
        return area;
    }
}
