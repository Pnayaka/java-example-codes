class Conversion{
	public static void main(String args[]){
		byte b;
		int i=257;
		double d=323.142;
		
		System.out.println("\nConversion of int to byte.");
		b=(byte)i;
		System.out.println("i & b "+i+" "+b);

		System.out.println("\nConversion of double to int.");
		i=(int)d;
		System.out.println("d & i "+d+" "+i);		

		System.out.println("\nConversion of double to byte.");
		b=(byte)d;
		System.out.println("d & b "+d+" "+b);
	}
}