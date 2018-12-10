package hotel.view;

import java.util.Scanner;

import hotel.service.HotelController;

public class StartView
{
	private static Scanner in;
	static int i = 0;
	
	public static void main(String[] args)
	{
		 while (true)
		 {	 
			 System.out.println("***************************************");
	         System.out.println("******** Hotel Reserve Program ********");
	         System.out.println("***************************************");
	         System.out.println("\n 1. 프로그램 사용하기 | 2. 종료하기");
	
	         in = new Scanner(System.in);
	         System.out.println("\n번호를 입력해주세요.");
	         
	         int m1 = in.nextInt();
	         System.out.println("입력하신 번호 : " + m1);
	         
	         switch (m1)
	         {
		         case 1:
		        	i = 1;
		            break;
		         case 2:
		        	i = 2;
		        	break;
		         default:
		        	 System.out.println("\n번호를 잘 못 입력하셨습니다.");
		        	 break;
	         }
	         
	         while (true)
	         {
	        	 if (i == 1)
	        	 {
	        		System.out.println("\n");
	        		System.out.println("********************************************");
		   	        System.out.println("******** Hotel Reserve Program Menu ********");
		   	        System.out.println("********************************************");
	                System.out.println("\n 1. 정보 조회 하기 | 2. 종료 하기");
	        	 }
	        	 else if (i == 2)
	        	 {
	        		 break;
	        	 }
	        	 
	        	 System.out.println("\n번호를 입력해주세요.");  
	             int m2 = in.nextInt();
	             System.out.println("입력하신 번호 : " + m2);
	             
	             switch (m2)
	             {
	             	case 1:
	             		HotelController.selectHRPMenu();
	             		break;
	             		
	             	case 2:
	             		break;
	             	
	             	default:
	             		System.out.println("\n번호를 잘 못 입력하셨습니다.");
	             		break;
	             }
	             
	             if(m2 == 2)
	             {
	            	 break;
	             }
	         }
	         
	         if(m1 == 2)
	         {
	        	 System.out.println("\nHotel Reserve Program을 종료합니다.");
	        	 break;
	         }
		 }
	}
}
