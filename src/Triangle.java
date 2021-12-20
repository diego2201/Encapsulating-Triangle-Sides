import java.text.DecimalFormat;

public class Triangle 
{
	
	private double sideA;  
	private double sideB;
	private double sideC;
	public static final double DEFAULT_SIDE = 1.0;

	public Triangle() 
	{
		sideA = DEFAULT_SIDE;
		sideB = DEFAULT_SIDE;
		sideC = DEFAULT_SIDE;
	}
	
	public Triangle(double a, double b, double c) 
	{
		
		if (isTriangle(a, b, c))
		{
			this.sideA = a;
			this.sideB = b;
			this.sideC = c;
		}
		else
		{
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}

	public Triangle(double[] sides) 
	{
		if (sides != null && isTriangle(sides) && sides.length == 3)
		{
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];
		}
		else
		{
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}

	public Triangle(Triangle triangle) 
	{
		if (triangle != null && isTriangle(triangle.getSideA(), triangle.getSideB(), triangle.getSideC()))
		{
			sideA = triangle.getSideA();
			sideB = triangle.getSideB();
			sideC = triangle.getSideC();
		}
		else
		{
			sideA = DEFAULT_SIDE;
			sideB = DEFAULT_SIDE;
			sideC = DEFAULT_SIDE;
		}
	}

	public double getSideA() 
	{
		return sideA;
	}

	public double getSideB() 
	{
		return sideB;
	}

	public double getSideC() 
	{
		return sideC;
	}

	public double[] getSides() 
	{
		return new double[] {sideA, sideB, sideC};
	}

	public double getAngleA() 
	{ 
		return lawOfCosines(sideB, sideC, sideA);
	}

	public double getAngleB() 
	{
		return lawOfCosines(sideA, sideC, sideB);
	}

	public double getAngleC() 
	{
		return lawOfCosines(sideA, sideB, sideC);
	}

	public double[] getAngles() 
	{
		return new double[] {getAngleA(), getAngleB(), getAngleC()};
	}
	
	public boolean setSideA(double i) 
	{
		
		if (isTriangle(i, sideB, sideC))
		{
			this.sideA = i;
			return true;
		}
		else
			{
			return false;
			}
	}
	
	public boolean setSideB(double i) 
	{
		if (isTriangle(i, sideA, sideC))
		{
			this.sideB = i;
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean setSideC(double i) 
	{
		if (isTriangle(i, sideA, sideB))
		{
			this.sideC = i;
			return true;
		}
		else
		{
			return false; 
		}
	}

	public boolean setSides(double[] sides) 
	{
		if(isTriangle(sides))
		{
			sideA = sides[0];
			sideB = sides[1];
			sideC = sides[2];
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean isTriangle(double sideA, double sideB, double sideC) 
	{
		if ((sideA > 0 && sideB > 0 && sideC > 0)) 
		{
			if (((sideA + sideB) > sideC) && ((sideB + sideC) > sideA) && ((sideC + sideA) > sideB)) 
			{
				return true;
			} 
			else 
			{
				return false;
			}
		} 
		else 
		{
			return false;
		}
	}
	
	public String toString()
	{
		DecimalFormat x = new DecimalFormat("0.000");
		return "Triangle(" + x.format(sideA) + ", " + x.format(sideB) + ", " + x.format(sideC) + ")"; 
	}

	public static boolean isTriangle(double[] sides) 
	{
		if (sides == null || sides.length < 3)
		{
			return false;
		}
		if (isTriangle(sides[0], sides[1], sides[2]))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static double lawOfCosines(double a, double b, double c) 
	{
		double x = ((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2))/(2 * a * b));
		double y = Math.acos(x);
		double z = Math.toDegrees(y);
		//double z = y * (180 / Math.PI);
		
		return z;
	}
}