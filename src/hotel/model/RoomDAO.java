package hotel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hotel.model.util.DBUtil;
import hotel.model.dto.RoomDTO;

public class RoomDAO
{
	// 특정 객실 ID에 해당하는 '객실의 가격', '예약 여부' 수정
	//public static boolean updateRoomPriceCheck(int roomId, String roomPrice, String roomCheck) throws SQLException
	public static boolean updateRoomPriceCheck(RoomDTO updateRoom) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement("update room set room_price = ?, room_check = ? where room_id = ?");
			/*pstmt.setString(1, roomPrice);
			pstmt.setString(2, roomCheck);
			pstmt.setInt(3, roomId);*/
			
			pstmt.setString(1, updateRoom.getRoomPrice());
			pstmt.setString(2, updateRoom.getRoomCheck());
			pstmt.setInt(3, updateRoom.getRoomId());
			
			int result = pstmt.executeUpdate();
			if(result == 1)
			{
				return true;
			}	
		}
		finally
		{
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
	//id로 해당 객실의 모든 정보 반환
	public static RoomDTO getRoom(int roomId) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		RoomDTO room = null;
		
		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from room where room_id = ?");
			pstmt.setInt(1, roomId);
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				room = new RoomDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getString(5));
			}			
		}
		finally
		{
			DBUtil.close(conn, pstmt, rset);
		}
		return room;
	}
	
	// 모든 객실 검색해서 반환
	public static ArrayList<RoomDTO> getAllRooms() throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RoomDTO> list = null;

		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from room");
			
			rset = pstmt.executeQuery();			
			list = new ArrayList<RoomDTO>();
			
			while(rset.next())
			{
				list.add(new RoomDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getString(5)));
			}
		}
		finally
		{
			DBUtil.close(conn, pstmt, rset);
		}
		return list;
	}
}

