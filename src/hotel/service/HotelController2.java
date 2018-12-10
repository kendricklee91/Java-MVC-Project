package hotel.service;

import java.sql.SQLException;
import java.util.ArrayList;

import hotel.model.HotelDAO;
import hotel.model.HotelService;
import hotel.model.MemberDAO;
import hotel.model.ReserveDAO;
import hotel.model.RoomDAO;
import hotel.model.RoomTypeDAO;
import hotel.model.dto.HotelDTO;
import hotel.model.dto.MemberDTO;
import hotel.model.dto.ReserveDTO;
import hotel.model.dto.RoomDTO;
import hotel.model.dto.RoomTypeDTO;
import hotel.view.FailView;
import hotel.view.SuccessView;

public class HotelController2
{
	static HotelService instance = HotelService.getInstance();
	
	/*
	// 모든 예약 검색
	public static ArrayList<ReserveDTO> getAllReserves()
	{
		ArrayList<ReserveDTO> allReserve = null;
		
		try
		{
			allReserve = ReserveDAO.getAllReserves();
			SuccessView.allListView(allReserve);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			FailView.showError("모든 예약 검색 시 오류 발생");
		}
		return allReserve;
	}
	
	// 모든 회원 검색
	public static ArrayList<MemberDTO> getAllMembers()
	{
		ArrayList<MemberDTO> allMember = null;
		
		try
		{
			allMember = MemberDAO.getAllMembers();
			SuccessView.allListView(allMember);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			FailView.showError("모든 예약 검색 시 오류 발생");
		}
		return allMember;
	}
	
	// 모든 객실 검색
	public static ArrayList<RoomDTO> getAllRooms()
	{
		ArrayList<RoomDTO> allRoom = null;
		
		try
		{
			allRoom = RoomDAO.getAllRooms();
			SuccessView.allListView(allRoom);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			FailView.showError("모든 예약 검색 시 오류 발생");
		}
		return allRoom;
	}
		
	// 예약 추가
	public static boolean addReserve(int reserveNo, String hotelId, int peopleCount,String stayPeriod, String reserveCheck,String reserveCost , int memberId, int roomId)
	{
		boolean result = false;
		
		try
		{
			result =  ReserveDAO.addReserve(new ReserveDTO(reserveNo, hotelId, peopleCount, stayPeriod, reserveCheck, reserveCost, memberId, roomId));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			FailView.showError("예약 추가 시 오류 발생");
		}
		return result;
	}
	
	// 예약 삭제
	public static int deleteReserve(int reserveNo)
	{
		int result = 0;
		
		try
		{
			result = ReserveDAO.deleteReserve(reserveNo);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			FailView.showError("예약건 삭제 오류 발생");
		}
		return result;
	}
	
	// 회원 수정
	public static boolean updateMember(int mid, String mobile)
	{
		boolean result = false;
		
		try
		{
			result = MemberDAO.updateMemberMobile(mid, mobile);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			FailView.showError("회원 정보의 수정 오류 발생");
		}
		return result;
	}
*/
	// 모든 예약 검색 로직
	public static ArrayList<ReserveDTO> getAllReserve()
	{
		ArrayList<ReserveDTO> getAllReserve = null;

		try
		{
			getAllReserve = ReserveDAO.getAllReserves();
			SuccessView.allListView(getAllReserve);
		}
		catch (SQLException s)
		{
			s.printStackTrace();
			FailView.showError("모든 프로젝트 검색시 에러 발생");
	    }
	    return getAllReserve;
	}

   // 새로운 예약 등록
   /*public static boolean addReserve(int reserveNo, String hotelId, int peopleCount,String stayPeriod, String reserveCheck, String reserveCost , int memberId, int roomId )
   {
	   boolean addReserve = false;
	   
	   try
	   {
		   addReserve = ReserveDAO.addReserve(new ReserveDTO(reserveNo, hotelId, peopleCount, stayPeriod, reserveCheck, reserveCost, memberId, roomId));
      
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("추가 예약시 에러 발생");
	   }
	   return addReserve;
   }*/

   // ID 로 예약 수정
   public static boolean updateReserve(int memberId, int peopleCount, String stayPeriod, String reserveCost)
   {
	   boolean updateReserve = false;
	   
	   try
	   {
		   updateReserve = ReserveDAO.updateReserve(memberId, peopleCount, stayPeriod, reserveCost);
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("예약 수정 오류");
	   }
	   return updateReserve;
   }

   // 예약 id로 삭제
   public static boolean deleteReserve(int reserveId) 
   {
	   boolean deleteReserve = false;

	   try
	   {
		   
		   deleteReserve = ReserveDAO.deleteReserve(reserveId);
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("프로젝트 삭제시 에러 발생");
	   }
	   return deleteReserve;
   }

	   
   ////////////////////////////////////////////객실
	   
   //모든 객실타입 검색
   public static ArrayList<RoomTypeDTO> getAllRoomType()
   {

      ArrayList<RoomTypeDTO> getAllRoomType = null;

      try
      {
    	  getAllRoomType = RoomTypeDAO.getAllRoomTypes();
         SuccessView.allListView(getAllRoomType);
      }
      catch (SQLException s)
      {
    	  s.printStackTrace();
    	  FailView.showError("모든 객실 유형 검색시 에러 발생");
      }
      return getAllRoomType;
   }

   //객식가격 체크인 수정
   public static boolean updateRoomPriceCheck(int roomId, String roomPrice, String roomCheck )
   {
	   boolean getAllRoomType = false;

	   try
	   {
		   getAllRoomType = RoomDAO.updateRoomPriceCheck(roomId, roomPrice, roomCheck );
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("객식가격 체크인 변경 오류");
	   }
	   return getAllRoomType;
   }

   //객실 id로 검색
   public static RoomDTO getRoom(int roomId)
   {
	   RoomDTO getRoom = null;
	   try
	   {
		   getRoom = RoomDAO.getRoom(roomId);
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("검색 에러 발생");
	   }
	   return getRoom;
   }
	   
   //모든 객실 검색
   public static ArrayList<RoomDTO> getAllRoom()
   {
	   ArrayList<RoomDTO> getAllRoom = null;

	   try
	   {
		   getAllRoom = RoomDAO.getAllRooms();
		   SuccessView.allListView(getAllRoom);
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("모든 객실 검색시 에러 발생");
	   }
	   return getAllRoom;
   }


   ////////////////////////////////////////////회원
   //회원등록
   public static boolean addMember(int memberId, String memberName,String memberMobile)
   {
	   boolean addMember = false;
	   
	   try
	   {
		   addMember = MemberDAO.addMember(new MemberDTO(memberId,memberName,memberMobile));
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("추가 회원 등록시 에러 발생");
	   }
	   return addMember;
   }

   //회원 폰번호 수정
   public static boolean updateMemberMoblie(int memberId, String memberMoblie)
   {
	   boolean updateMemberMoblie = false;

	   try
	   {
		   updateMemberMoblie = MemberDAO.updateMemberMobile(memberId, memberMoblie);
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("회원 폰번호 변경 오류");
	   }
	   return updateMemberMoblie;
   }

   //회원 삭제
   public static boolean deleteMember(int memberId)
   {
	   boolean deleteMember = false;
	   
	   try
	   {
		   deleteMember = MemberDAO.deleteMember(memberId);
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("회원 삭제시 에러 발생");
	   }
	   return deleteMember;
   }

   //회원 모두 검색
   public static ArrayList<MemberDTO> getAllMember()
   {
      ArrayList<MemberDTO> getAllMember = null;

      try
      {
         getAllMember = MemberDAO.getAllMembers();
         SuccessView.allListView(getAllMember);
      }
      catch (SQLException s)
      {
    	  s.printStackTrace();
    	  FailView.showError("모든 회원 검색시 에러 발생");
      }
      return getAllMember;
   }
	   
   //회원 id로 검색
   public static ReserveDTO getReserve(int memberId)
   {
      ReserveDTO getReserve = null;

      try
      {
    	  getReserve = ReserveDAO.getReserve(memberId);
      }
      catch (SQLException s)
      {
    	  s.printStackTrace();
    	  FailView.showError("검색 에러 발생");
      }
      return getReserve;
   }
   
   //////////////////////////////////////////// 호텔
	   
   //호텔 등급 수정
   public static boolean updateHotelGrade(String hotelId, int hotelGrade)
   {
	   boolean updateHotelGrade = false;

	   try 
	   {
         updateHotelGrade = HotelDAO.updateHotelGrade(hotelId, hotelGrade);
	   } 
	   catch (SQLException s) 
	   {
		   s.printStackTrace();
		   FailView.showError("회원 폰번호 변경 오류");
	   }
	   return updateHotelGrade;
   }

   //id로 호텔 검색
   public static HotelDTO getHotel(String hotelId)
   {
	   HotelDTO getHotel = null;

	   try 
	   {
		   getHotel = HotelDAO.getHotel(hotelId);
	   }
	   catch (SQLException s) 
	   {
		   s.printStackTrace();
		   FailView.showError("검색 에러 발생");
	   }
	   return getHotel;
   }

   //모든 호텔 검색
   public static ArrayList<HotelDTO> getAllHotel() 
   {
      ArrayList<HotelDTO> getAllHotel = null;

      try 
      {
         getAllHotel = HotelDAO.getAllHotels();
         SuccessView.allListView(getAllHotel);
      } 
      catch (SQLException s) 
      {
    	  s.printStackTrace();
    	  FailView.showError("모든 호텔 검색시 에러 발생");
      }
      return getAllHotel;
   }
}
