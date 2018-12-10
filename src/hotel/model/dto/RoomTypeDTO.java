package hotel.model.dto;

public class RoomTypeDTO
{
	private int roomType;
	private String roomDesc;
	
	public RoomTypeDTO() {}
	public RoomTypeDTO(int type, String desc)
	{
		roomType = type;
		roomDesc = desc;
	}
	
	public int getRoomType()
	{
		return roomType;
	}
	public void setRoomType(int roomType)
	{
		this.roomType = roomType;
	}
	
	public String getRoomDesc()
	{
		return roomDesc;
	}
	public void setRoomDesc(String roomDesc)
	{
		this.roomDesc = roomDesc;
	}
	
	@Override
	public String toString()
	{
		return "RoomTypeDTO [roomType=" + roomType + ", roomDesc=" + roomDesc + "]";
	}
}
