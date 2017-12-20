
class DataInClass{
	public static void main(String argv[]){
		MyClass mc1;
		MyClass mc2;
	
		mc1 = new MyClass();
		mc1.printMyMessage();
	
		mc1.sTitle = "Testing";
		mc1.printMyMessage();
	
		mc2 = new MyClass("Yo Dude");
		mc2.printMyMessage();
	}
}
	
class MyClass{
	String sTitle;

	MyClass(){
		sTitle = "Attention";
	}

	MyClass (String s){
		sTitle = s;
	}

	void printMyMessage(){
		System.out.println(sTitle + ":surf's Up");
	}
}
