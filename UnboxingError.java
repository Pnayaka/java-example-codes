// An error produced by manual unboxing.
class UnboxingError {
	public static void main(String args[]) {
		Integer iOb = 1000; // autobox the value 1000
		int i = iOb.byteValue(); // manually unbox as byte !!!
		System.out.println(i); // does not display 1000 !
	}
}



// A bad use of autoboxing/unboxing!
Double a, b, c;
a = 10.0;
b = 4.0;
c = Math.sqrt(a*a + b*b);
System.out.println("Hypotenuse is " + c);