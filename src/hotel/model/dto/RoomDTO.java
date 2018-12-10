package hotel.model.dto;

public class RoomDTO
{
	private int roomId;
	private String roomPrice;
	private String roomCheck;
	private int roomType;
	private String hotelId;
	
	public RoomDTO() {}
	public RoomDTO(int rid, String price, String check, int type, String hid)
	{
		roomId = rid;
		roomPrice = price;
		roomCheck = check;
		roomType = type;
		hotelId = hid;
	}
	
	public RoomDTO(int rid, String price, String check)
	{
		roomId = rid;
		roomPrice = price;
		roomCheck = check;
	}
	
	public int getRoomId()
	{
		return roomId;
	}
	public void setRoomId(int roomId)
	{
		this.roomId = roomId;
	}
	
	public int getRoomType()
	{
		return roomType;
	}
	public void setRoomType(int roomType)
	{
		this.roomType = roomType;
	}
	
	public String getHotelId()
	{
		return hotelId;
	}
	public void setHotelId(String hotelId)
	{
		this.hotelId = hotelId;
	}
	
	public String getRoomPrice()
	{
		return roomPrice;
	}
	public void setRoomPrice(String roomPrice)
	{
		this.roomPrice = roomPrice;
	}
	
	public String getRoomCheck()
	{
		return roomCheck;
	}
	public void setRoomCheck(String roomCheck)
	{
		this.roomCheck = roomCheck;
	}

	@Override
	public String toString()
	{
		return "°´½Ç Á¤º¸ [°´½Ç ID=" + roomId + ", °´½Ç À¯Çü=" + roomType + ", È£ÅÚ ID=" + hotelId + ", °´½Ç ÀÌ¿ë°¡="
				+ roomPrice + ", °´½Ç ¿¹¾à¿©ºÎ=" + roomCheck + "]";
	}
}