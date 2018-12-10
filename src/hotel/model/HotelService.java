package hotel.model;

import java.sql.SQLException;
import java.util.ArrayList;

import hotel.exception.NotExistException;
import hotel.model.dto.MemberDTO;
import hotel.model.dto.RoomDTO;
import hotel.model.dto.RoomTypeDTO;
import hotel.model.dto.HotelDTO;
import hotel.model.dto.ReserveDTO;

public class HotelService
{
	private static HotelService instance = new HotelService();
	
	private HotelService(){}	
	public static HotelService getInstance()
	{
		return instance;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 예약(Reserve) - CRUD
	public static void notExistReserve(int reserveId) throws NotExistException, SQLException
	{
		ReserveDTO reserve = ReserveDAO.getReserve(reserveId);
		if(reserve == null)
		{
			throw new NotExistException("검색하신 예약 번호가 없습니다.");
		}
	}
	
	// 모든 예약 정보 반환
	public static ArrayList<ReserveDTO> getAllReserves() throws SQLException
	{
		return ReserveDAO.getAllReserves();
	}
		
	// 예약 특정 id로 예약 검색
	public static ReserveDTO getReserve(int reserveNo) throws NotExistException, SQLException
	{
		ReserveDTO reserve = ReserveDAO.getReserve(reserveNo);
		if(reserve == null)
		{
			throw new NotExistException("검색하신 예약번호 정보가 없습니다.");
		}
		return reserve;
	}
	
	//새로운 예약 저장 (기존 코드)
	public static boolean addReserve(ReserveDTO reserve) throws SQLException // 제일 기존 코드
	{
		return ReserveDAO.addReserve(reserve);
	}
	
	/*public static void addReserve(int reserveNo, String hotelId, int peopleCount,String stayPeriod, String reserveCheck, String reserveCost , int memberId, int roomId) throws SQLException
	{
		try
		{
			ReserveDAO.addReserve(reserveNo, hotelId, peopleCount, stayPeriod, reserveCheck, reserveCost, memberId, roomId);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}*/
	
	// 기존 예약에서 특정 예약 ID에 해당하는 '인원, 기간, 비용' 수정
	//public static boolean updateReserve(int reserveNo, int peopleCount, String stayPeriod, String reserveCost) throws SQLException, NotExistException 기존
	public static boolean updateReserve(ReserveDTO reserve) throws SQLException, NotExistException
	{
		//notExistReserve(reserveNo);
		//return ReserveDAO.updateReserve(reserveNo, peopleCount, stayPeriod, reserveCost);
		return ReserveDAO.updateReserve(reserve);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 객실(Room) - CRUD
	public static void notExistRoom(int roomId) throws NotExistException, SQLException
	{
		RoomDTO room = RoomDAO.getRoom(roomId);
		if(room == null)
		{
			throw new NotExistException("검색하는 객실 ID번호가 미존재합니다.");
		}
	}
	
	// 모든 객실 정보 반환
	public static ArrayList<RoomDTO> getAllRooms() throws SQLException
	{
		return RoomDAO.getAllRooms();
	}
	
	// 객실 특정 id로 객실 검색
	public static RoomDTO getRoom(int roomId) throws NotExistException, SQLException
	{
		RoomDTO room = RoomDAO.getRoom(roomId);
		if(room == null)
		{
			throw new NotExistException("검색하신 객실 ID 정보가 없습니다.");
		}
		return room;
	}
	
	// 특정 객실 ID에 해당하는 '객실의 가격', '예약 여부' 수정
	//public static boolean updateRoom(int roomId, String roomPrice, String roomCheck) throws SQLException, NotExistException
	public static boolean updateReserve(RoomDTO room) throws SQLException, NotExistException
	{
		//notExistRoom(roomId);
		//return RoomDAO.updateRoomPriceCheck(roomId, roomPrice, roomCheck);
		return RoomDAO.updateRoomPriceCheck(room);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 호텔(Hotel) - CRUD
	public static void notExistHotel(String hotelId) throws NotExistException, SQLException
	{
		HotelDTO hotel = HotelDAO.getHotel(hotelId);
		if(hotel == null)
		{
			throw new NotExistException("검색하는 호텔 ID가 미존재합니다.");
		}
	}
	
	// 모든 호텔 정보 반환
	public static ArrayList<HotelDTO> getAllHotels() throws SQLException
	{
		return HotelDAO.getAllHotels();
	}
	
	// 호텔 특정 id로 호텔 검색
	public static HotelDTO getHotel(String hotelId) throws NotExistException, SQLException
	{
		HotelDTO hotel =  HotelDAO.getHotel(hotelId);
		if(hotel == null)
		{
			throw new NotExistException("검색하신 호텔 ID 정보가 없습니다.");
		}
		return hotel;
	}

	// 특정 호텔 id에 해당하는 '호텔 등급' 수정
	public static boolean updateHotelGrade(String hotelId, int hotelGrade) throws SQLException, NotExistException
	{
		notExistHotel(hotelId);
		return HotelDAO.updateHotelGrade(hotelId, hotelGrade);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 회원(Member) - CRUD
	public static void notExistMember(int memberId) throws NotExistException, SQLException
	{
		MemberDTO member = MemberDAO.getMember(memberId);
		if(member == null)
		{
			throw new NotExistException("검색하는 회원 ID가 미존재합니다.");
		}
	}
	
	// 모든 회원 정보 반환
	public static ArrayList<MemberDTO> getAllMembers() throws SQLException
	{
		return MemberDAO.getAllMembers();
	}
	
	// 회원 특정 id로 회원 검색
	public static MemberDTO getMember(int memberId) throws SQLException, NotExistException
	{
		MemberDTO member = MemberDAO.getMember(memberId);
		if(member == null)
		{
			throw new NotExistException("검색하신 회원 ID 정보가 없습니다.");
		}
		return member;
	}
	
	// 신규 회원 추가
	public static boolean addMember(MemberDTO member) throws SQLException
	{
		return MemberDAO.addMember(member);
	}
	
	// 특정 회원 id에 해당하는 '전화번호' 수정
	//public static boolean updateMemberMobile(int memberId, String memberMobile) throws SQLException, NotExistException
	public static boolean updateMemberMobile(MemberDTO updateMember) throws SQLException
	{
		//notExistMember(memberId);
		//return MemberDAO.updateMemberMobile(memberId, memberMobile);
		return MemberDAO.updateMemberMobile(updateMember);
	}
	
	// 회원 삭제
	public static boolean deleteMember(int memberId) throws SQLException, NotExistException
	//public static boolean deleteMember(MemberDTO deletemember) throws SQLException, NotExistException
	{
		notExistMember(memberId);
		return MemberDAO.deleteMember(memberId);
		//return MemberDAO.deleteMember(deletemember);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//모든 객실 유형 정보 검색
	public static ArrayList<RoomTypeDTO> getAllRoomType() throws SQLException
	{
		return RoomTypeDAO.getAllRoomTypes();
	}

}