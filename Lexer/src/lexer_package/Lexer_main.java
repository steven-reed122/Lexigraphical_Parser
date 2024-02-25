package lexer_package;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lexer_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name of file to be parsed");
		String fileName = scanner.nextLine();
		scanner.close();
		fileReader(fileName);
		
	}
	
	public static void fileReader(String fileName) {
		File file = new File(fileName);
		try(Scanner fileScanner = new Scanner(file)) {
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				//System.out.println(line);
				tokenParser(line);
			}
			fileScanner.close();
			
		} catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
		}
	}
	
	public static void tokenParser(String line) {
		for(int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			switch (ch) {
				case ' ' :
					break;
				case 'i' : 
					if (checkIsIf(line,i) == true) {System.out.println("[IF]");i++;}
					else if (checkIsInt(line,i) == true) {System.out.println("[INT]"); i+=2;}
					else i = handleIdent(line, i);
					break;
				case 'w' :
					if (checkIsWhile(line,i) == true) {System.out.println("[WHILE]"); i+=4;}
					else i = handleIdent(line, i);
					break;
				case 'f' :
					if (checkIsFor(line,i) == true) {System.out.println("[FOR]"); i+=2;}
					else i = handleNum(line, i);
					break;
				case 'p' :
					if (checkIsProcedure(line,i) == true) {System.out.println("[PROCEDURE]"); i+=8;}
					else i = handleIdent(line, i);
					break;
				case 'r' :
					if (checkIsReturn(line,i) == true) {System.out.println("[RETURN]"); i+= 5;}
					else i = handleIdent(line, i);
					break;
				case 'e' :
					if (checkIsElse(line,i) == true) {System.out.println("[ELSE]"); i+=3;}
					else if (checkIsEnd(line,i) == true) {System.out.println("[END]"); i+=2;}
					else i = handleIdent(line, i);
					break;
				case 'd' :
					if (checkIsDo(line,i) == true) {System.out.println("[DO]"); i++;}
					else i = handleIdent(line, i);
					break;
				case 'b' :
					if (checkIsBreak(line,i) == true) {System.out.println("[BREAK]"); i+=4;}
					else i = handleIdent(line, i);
					break; 
				case '=' : 
					if(checkIsEEGEOrLE(line,i) == true) {System.out.println("[EE]"); i+=1;}
					else {System.out.println("[ASSIGN]");}
					break;
				case '+' : 
					if(checkIsInc(line,i) == true) {System.out.println("[INC]"); i+=1;}
					else {System.out.println("[ADD_OP]");}
					break;
				case '>' : 
					if(checkIsEEGEOrLE(line,i) == true) {System.out.println("[GE]"); i+=1;}
					else {System.out.println("[GT]");}
					break;
				case '<' : 
					if(checkIsEEGEOrLE(line,i) == true) {System.out.println("[LE]"); i+=1;}
					else {System.out.println("[LT]");}
					break;
				case '-' : System.out.println("[SUB_OP]"); break;
				case '*' : System.out.println("[MUL_OP]"); break;
				case '/' : System.out.println("[DIV_OP]"); break;
				case '%' : System.out.println("[MOD_OP]"); break;
				case '(' : System.out.println("[LP]"); break;
				case ')' : System.out.println("[RP]"); break;
				case '{' : System.out.println("[LB]"); break;
				case '}' : System.out.println("[RB]"); break;
				case '|' : System.out.println("[OR]"); break;
				case '&' : System.out.println("[AND]"); break;
				case '!' : System.out.println("[NEG]"); break;
				case ',' : System.out.println("[COMMA]"); break;
				case ';' : System.out.println("[SEMI]"); break;
				case '\t' : break;
				default :
					if (Character.isDigit(ch)) {
						i = handleNum(line, i);
						break;
	                } else if (Character.isLetter(ch)) {
	                	i = handleIdent(line, i);
	                	break;
	                }
	                else {
	                	System.err.println("Invalid Character");
	                	break;
	                }
			}
		}
	}
	
	public static boolean checkIsEEGEOrLE(String line, int i) {
		if(line.length() > i + 1)
		{
			char chNext = line.charAt(i+1);
			if(chNext == '=') {
				return true;
			}
		}
		return false;
	}
	public static boolean checkIsInc(String line, int i) {
		if(line.length() > i + 1)
		{
			char chNext = line.charAt(i+1);
			if(chNext == '+') {
				return true;
			}
		}
		return false;
	}
	public static boolean checkIsIf(String line, int i) {
		if(line.length() > i + 1)
		{
			char chNext = line.charAt(i+1);
			if(chNext == 'f') {
				return true;
			}
		}
		return false;
	}
	public static boolean checkIsFor(String line, int i) {
		if(line.length() > i + 2)
		{
			char chNext = line.charAt(i+1);
			char chNextNext = line.charAt(i+2);
			if(chNext == 'o' && chNextNext == 'r') {
				return true;
			}
		}
		return false;
	}
	public static boolean checkIsWhile(String line, int i) {
		if(line.length() > i + 4)
		{
			char ch2 = line.charAt(i+1);
			char ch3 = line.charAt(i+2);
			char ch4 = line.charAt(i+3);
			char ch5 = line.charAt(i+4);
			if(ch2 == 'h' && ch3 == 'i' && ch4 == 'l' && ch5 == 'e') {
				return true;
			}
		}
		return false;
	}
	public static boolean checkIsProcedure(String line, int i) {
		if(line.length() > i + 8)
		{
			char ch2 = line.charAt(i+1);
			char ch3 = line.charAt(i+2);
			char ch4 = line.charAt(i+3);
			char ch5 = line.charAt(i+4);
			char ch6 = line.charAt(i+5);
			char ch7 = line.charAt(i+6);
			char ch8 = line.charAt(i+7);
			char ch9 = line.charAt(i+8);
			if(ch2 == 'r' && ch3 == 'o' && ch4 == 'c' && ch5 == 'e'
					&& ch6 == 'd' && ch7 == 'u' && ch8 == 'r' && ch9 =='e') {
				return true;
			}
		}
		return false;
	}
	public static boolean checkIsReturn(String line, int i) {
		if(line.length() > i + 5)
		{
			char ch2 = line.charAt(i+1);
			char ch3 = line.charAt(i+2);
			char ch4 = line.charAt(i+3);
			char ch5 = line.charAt(i+4);
			char ch6 = line.charAt(i+5);
			if(ch2 == 'e' && ch3 == 't' && ch4 == 'u' && ch5 == 'r' && ch6 == 'n') {
				return true;
			}
		}
		return false;
	}
	public static boolean checkIsInt(String line, int i) {
		if(line.length() > i + 2)
		{
			char chNext = line.charAt(i+1);
			char chNextNext = line.charAt(i+2);
			if(chNext == 'n' && chNextNext == 't') {
				return true;
			}
		}
		return false;
	}
	public static boolean checkIsElse(String line, int i) {
		if(line.length() > i + 3)
		{
			char ch2 = line.charAt(i+1);
			char ch3 = line.charAt(i+2);
			char ch4 = line.charAt(i+3);
			if(ch2 == 'l' && ch3 == 's' && ch4 == 'e') {
				return true;
			}
		}
		return false;
	}
	public static boolean checkIsDo(String line, int i) {
		if(line.length() > i + 1)
		{
			char ch2 = line.charAt(i+1);
			if(ch2 == 'o') {
				return true;
			}
		}
		return false;
	}
	public static boolean checkIsBreak(String line, int i) {
		if(line.length() > i + 4)
		{
			char ch2 = line.charAt(i+1);
			char ch3 = line.charAt(i+2);
			char ch4 = line.charAt(i+3);
			char ch5 = line.charAt(i+4);
			if(ch2 == 'r' && ch3 == 'e' && ch4 == 'a' && ch5 == 'k') {
				return true;
			}
		}
		return false;
	}
	public static boolean checkIsEnd(String line, int i) {
		if(line.length() > i + 2)
		{
			char ch2 = line.charAt(i+1);
			char ch3 = line.charAt(i+2);
			if(ch2 == 'n' && ch3 == 'd') {
				return true;
			}
		}
		return false;
	}
	public static int handleNum(String line, int i) {
	    System.out.println("[INT_CONST]");
	    if (i >= line.length()) {
	        return i; // Check if index is out of bounds
	    }

	    char chNext = line.charAt(i+1);
	    while (i < line.length() && Character.isDigit(line.charAt(i))) {
	        i++;
	    }
	    if (Character.isLetter(chNext)) {
	    	System.out.println("[IDENT] must begin with a letter");
	        return i-1;
	    }
	    return i-1;
	}
	public static int handleIdent(String line, int i) {
		System.out.println("[IDENT]");
	    if (i >= line.length()) {
	        return i; // Check if index is out of bounds
	    }
	    
	    while (i < line.length() && 
	    		(Character.isDigit(line.charAt(i)) || (Character.isLetter(line.charAt(i))))) {
	        i++;
	    }
	    return i-1; // Return i even if an error is found to prevent endless loop
	}
	
}



