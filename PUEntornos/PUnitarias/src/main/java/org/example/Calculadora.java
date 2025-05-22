package org.example;

	public class Calculadora {
		private int num1;
		private int num2;
		public Calculadora (int a , int b){
			num1=a;
			num2=b;
		}
		public int suma(){
			int res=num1+num2;
			return res;
		}
		public int resta(){
			int res=num1-num2;	//error intencionado
			return res;
		}
		public int multiplica(){
			int res=num1*num2;
			return res;
		}
		public int divide(){
			if (num2 != 0){
				return num1/num2;
			}else {
				throw new ArithmeticException("Division por 0");
			}
		}
}


