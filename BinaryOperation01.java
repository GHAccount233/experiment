package expriment;

import java.util.Random;

public class BinaryOperation01 {
	static String[] Equation = new String[50];
	static int[] value = new int[50];
	static int index;

	static void printHeader() { // 简单说明本程序的作用和使用
		System.out.println("----------------------------------------");
		System.out.println("- 程序输出50道100以内的加减法算式的习题");
		System.out.println("- 每次运行程序可得到一套50道题的习题可答案");
		System.out.println("----------------------------------------");
	}

	static void generateEquations() { // 产生加法或减法算式的字符串并存入一个数组，并保存答案
		for (int i = 0; i < Equation.length; i++) {
			Equation[i] = generateEquation();
		}

	}

	static void printExercise() { // 打印输出所有算式
		for (int i = 0; i < Equation.length; i++) {
			if (i % 4 == 0)
				System.out.print("\n");
			System.out.printf("%-2d:%-7s= ___   ",i+1,Equation[i]);
		}
	}

	static void printCalculation() { // 打印输出每个算式的结果
		System.out.print("\n");
		System.out.println("----------------------------------------");
		System.out.println("- 下面是习题的参考答案");
		System.out.println("----------------------------------------");
		for (int i = 0; i < value.length; i++) {
			System.out.printf("\n");
			System.out.printf("%-2d:%d",i+1,value[i]);
		}
	}

	static boolean check(int anInteger, int low, int high) { // 检查一个数anInteger是否在范围[low,high]
		return anInteger >= low && anInteger <= high;
	}

	static int generateOperand() { // 随机生成一个[0,100]的整数
		int operand;
		Random random = new Random();
		operand = random.nextInt(101);
		return operand;
	}

	static String generateAdditionEquation() { // 生成加法算式，并将答案保存
		int n1;
		int n2;
		do { // 生成两个整数，使其结果满足约束条件
			n1 = generateOperand();
			n2 = generateOperand();
		} while (!check(n1 + n2, 0, 100));
		value[index] = n1 + n2;
		index++;
		return n1 + "+" + n2;
	}

	static String generateSubstractEquation() { // 生成减法算式，并将答案保存
		int n1;
		int n2;
		do { // 生成两个整数，使其结果满足约束条件
			n1 = generateOperand();
			n2 = generateOperand();
		} while (!check(n1 - n2, 0, 100));
		value[index] = n1 - n2;
		index++;
		return n1 + "-" + n2;
	}

	static String generateEquation() { // 随机生成加法算式或者减法算式
		int operator; // operator==0时生成加法，operator==1时是减法
		Random random = new Random();
		operator = random.nextInt(2);
		if (operator == 0)
			return generateAdditionEquation();
		else
			return generateSubstractEquation();
	}

	public static void main(String[] args) {
		printHeader();
		generateEquations();
		printExercise();
		printCalculation();
	}
}