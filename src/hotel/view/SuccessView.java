package hotel.view;

import java.util.ArrayList;

public class SuccessView
{
	// 모든 (예약 or 회원) 출력
	public static void allListView(ArrayList allLists)
	{
		for(int index = 0; index < allLists.size(); index++)
		{			
			System.out.println("검색정보 : " + (index + 1) + " - " + allLists.get(index));
		}
	}	
}
