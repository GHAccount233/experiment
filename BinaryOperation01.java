package expriment;

import java.util.Random;

public class BinaryOperation01 {
	static String[] Equation = new String[50];
	static int[] value = new int[50];
	static int index;

	static void printHeader() { // ��˵������������ú�ʹ��
		System.out.println("----------------------------------------");
		System.out.println("- �������50��100���ڵļӼ�����ʽ��ϰ��");
		System.out.println("- ÿ�����г���ɵõ�һ��50�����ϰ��ɴ�");
		System.out.println("----------------------------------------");
	}

	static void generateEquations() { // �����ӷ��������ʽ���ַ���������һ�����飬�������
		for (int i = 0; i < Equation.length; i++) {
			Equation[i] = generateEquation();
		}

	}

	static void printExercise() { // ��ӡ���������ʽ
		for (int i = 0; i < Equation.length; i++) {
			if (i % 4 == 0)
				System.out.print("\n");
			System.out.printf("%-2d:%-7s= ___   ",i+1,Equation[i]);
		}
	}

	static void printCalculation() { // ��ӡ���ÿ����ʽ�Ľ��
		System.out.print("\n");
		System.out.println("----------------------------------------");
		System.out.println("- ������ϰ��Ĳο���");
		System.out.println("----------------------------------------");
		for (int i = 0; i < value.length; i++) {
			System.out.printf("\n");
			System.out.printf("%-2d:%d",i+1,value[i]);
		}
	}

	static boolean check(int anInteger, int low, int high) { // ���һ����anInteger�Ƿ��ڷ�Χ[low,high]
		return anInteger >= low && anInteger <= high;
	}

	static int generateOperand() { // �������һ��[0,100]������
		int operand;
		Random random = new Random();
		operand = random.nextInt(101);
		return operand;
	}

	static String generateAdditionEquation() { // ���ɼӷ���ʽ�������𰸱���
		int n1;
		int n2;
		do { // ��������������ʹ��������Լ������
			n1 = generateOperand();
			n2 = generateOperand();
		} while (!check(n1 + n2, 0, 100));
		value[index] = n1 + n2;
		index++;
		return n1 + "+" + n2;
	}

	static String generateSubstractEquation() { // ���ɼ�����ʽ�������𰸱���
		int n1;
		int n2;
		do { // ��������������ʹ��������Լ������
			n1 = generateOperand();
			n2 = generateOperand();
		} while (!check(n1 - n2, 0, 100));
		value[index] = n1 - n2;
		index++;
		return n1 + "-" + n2;
	}

	static String generateEquation() { // ������ɼӷ���ʽ���߼�����ʽ
		int operator; // operator==0ʱ���ɼӷ���operator==1ʱ�Ǽ���
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