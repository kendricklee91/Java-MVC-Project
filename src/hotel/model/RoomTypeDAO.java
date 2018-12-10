package hotel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hotel.model.dto.RoomTypeDTO;
import hotel.model.util.DBUtil;

public class RoomTypeDAO
{
	// 모든 객실 유형 검색해서 반환
	public static ArrayList<RoomTypeDTO> getAllRoomTypes() throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RoomTypeDTO> list = null;
		
		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from room_type");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<RoomTypeDTO>();
			
			while(rset.next())
			{
				list.add(new RoomTypeDTO(rset.getInt(1), rset.getString(2)));
			}
		}
		finally
		{
			DBUtil.close(conn, pstmt, rset);
		}
		return list;
	}
}
