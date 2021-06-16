package homework9;

/**
 * @author _britney_ 
 * @date 2021/6/7
 * @description Chapter12 �����嵥12-6
 */

public class TestException  {
	  public static void main(String[] args) {
	    try {
	      System.out.println(sum(new int[] {1, 2, 3, 4, 5}));
	    }
	    catch (Exception ex) {
	      ex.printStackTrace();
	      System.out.println("\n" + ex.getMessage());
	      System.out.println("\n" + ex.toString());

	      System.out.println("\nTrace Info Obtained from getStackTrace");
	      StackTraceElement[] traceElements = ex.getStackTrace();
	      for (int i = 0; i < traceElements.length; i++) {
	        System.out.print("method " + traceElements[i].getMethodName());
	        System.out.print("(" + traceElements[i].getClassName() + ":");
	        System.out.println(traceElements[i].getLineNumber() + ")");
	      }
	    }
	  }

	  private static int sum(int[] list) {
	    int result = 0;
	    for (int i = 0; i <= list.length; i++)
	      result += list[i];
	    return result;
	  }
	}