package hotel.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import hotel.exception.NotExistException;
import hotel.model.HotelDAO;
import hotel.model.HotelService;
import hotel.model.MemberDAO;
import hotel.model.ReserveDAO;
import hotel.model.RoomDAO;
import hotel.model.dto.HotelDTO;
import hotel.model.dto.MemberDTO;
import hotel.model.dto.ReserveDTO;
import hotel.model.dto.RoomDTO;
import hotel.view.FailView;
import hotel.view.SuccessView;

public class HotelController
{
	private static Scanner in;
	static HotelService instance = HotelService.getInstance();
	
	static ArrayList<ReserveDTO> getAllReserve = null;
	static ArrayList<RoomDTO> getAllRoom = null;
	static ArrayList<HotelDTO> getAllHotel = null;
	static ArrayList<MemberDTO> getAllMember = null;
	
	static boolean deleteMember = false;
	
	static Scanner scan = new Scanner(System.in);
	
	public static void selectHRPMenu()
	{
		// 공통 사용 변수
		String hotelId;
		int memberId;
		int roomId;
		
		// 예약 추가 변수
		int reserveNo;
		//String hotelId;
		int peopleCount;
		String stayPeriod;
		String reserveCheck;
		String reserveCost;
		//int memberId;
		//int roomId;
		
		// 회원 추가 변수
		//int memberId;
		String memberName;
		String memberMobile;
		
		// 객실 수정 변수
		String roomPrice;
		String roomCheck;
		
		while(true)
		{
			System.out.println("\n");
			System.out.println("*****************************************************************************************************************************");
			System.out.println("[1. 예약 조회 | 2. 객실 조회 | 3. 호텔 조회 | 4. 회원 조회 | 5. 예약 추가  | 6. 회원 추가 | 7. 예약 수정 | 8. 객실 수정 | 9. 회원 수정 | 10. 회원 삭제 | 0. 종료 하기]");
			System.out.println("*****************************************************************************************************************************");
			
			in = new Scanner(System.in);
			System.out.println("\n번호를 입력해주세요.");
			
			int m1 = in.nextInt();
			System.out.println("입력하신 번호 : " + m1);
			
			switch(m1)
			{
				case 1:
					try // 예약 조회
					{
						getAllReserve = ReserveDAO.getAllReserves();
						if(getAllReserve.size() != 0)
						{
							System.out.println("\n예약 정보");
							SuccessView.allListView(getAllReserve);
						}
						/*else
						{
							FailView.showError("정상실행이지만 모든 예약 검색 오류 발생");
						}*/
					}
					catch (SQLException s)
					{
						s.printStackTrace();
						FailView.showError("모든 예약 검색 시 오류 발생");
				    }
					break;
				case 2: // 객실 조회
					try
					{
						getAllRoom = RoomDAO.getAllRooms();
						if(getAllRoom.size() != 0)
						{
							System.out.println("\n객실 정보");
							SuccessView.allListView(getAllRoom);
						}
						else
						{
							FailView.showError("정상실행이지만 모든 객실 검색 오류 발생");
						}
					}
					catch (SQLException s)
					{
						s.printStackTrace();
						FailView.showError("모든 객실 검색 시 오류 발생");
					}
					break;
				case 3: // 호텔 조회
					try
					{
						getAllHotel = HotelDAO.getAllHotels();
						if(getAllHotel.size() != 0)
						{
							System.out.println("\n호텔 정보");
							SuccessView.allListView(getAllHotel);
						}
						else
						{
							FailView.showError("정상실행이지만 모든 호텔 검색 오류 발생");
						}
					}
					catch (SQLException s)
					{
						s.printStackTrace();
						FailView.showError("모든 호텔 검색 시 오류 발생");
					}
					break;
				case 4: // 회원 조회
					try
					{
						getAllMember = MemberDAO.getAllMembers();
						if(getAllMember.size() != 0)
						{
							System.out.println("\n회원 정보");
							SuccessView.allListView(getAllMember);
						}
						else
						{
							FailView.showError("정상실행이지만 모든 회원 검색 오류 발생");
						}
					}
					catch (SQLException s)
					{
						s.printStackTrace();
						FailView.showError("모든 호텔 검색 시 오류 발생");
					}
					break;
				case 5: // 예약 추가
					System.out.println("\n추가할 예약 정보를 입력하세요.");
					
					System.out.println("\n예약 번호를 입력하세요.");
					reserveNo = scan.nextInt();
					
					System.out.println("\n객실의 투숙 인원을 입력하세요.");
					peopleCount = scan.nextInt();
					
					System.out.println("\n객실의 투숙 기간을 입력하세요.");
					stayPeriod = scan.next();
					
					System.out.println("\n객실의 결제 여부를 입력하세요.");
					reserveCheck = scan.next();
					
					System.out.println("\n결제 비용을 입력하세요.");
					reserveCost = scan.next();
					
					System.out.println("\n호텔 ID를 입력하세요.");
					hotelId = scan.next();
					
					System.out.println("\n회원 ID를 입력하세요.");
					memberId = scan.nextInt();
					
					System.out.println("\n객실 ID를 입력하세요.");
					roomId = scan.nextInt();					
					
					ReserveDTO rdto = new ReserveDTO(reserveNo, peopleCount, stayPeriod, reserveCheck, reserveCost, hotelId, memberId, roomId);
					
					try
					{
						HotelService.addReserve(rdto);
						System.out.println("정상적으로 새로운 예약 사항이 추가되었습니다.");
					}
					catch(SQLException s)
					{
						s.printStackTrace();
						FailView.showError("새로운 예약 사항 추가 오류 발생");
					}
					break;
				case 6: // 회원 추가
					//System.out.println("\n추가할 회원 정보를 입력하세요.");
					
					System.out.println("\n추가할 회원 ID를 입력하세요");
					memberId = scan.nextInt();
					
					System.out.println("\n추가할 회원의 이름을 입력하세요");
					memberName = scan.next();
					
					System.out.println("\n추가할 회원의 휴대전화 번호를 입력하세요");
					memberMobile = scan.next();
					
					MemberDTO mdto = new MemberDTO(memberId, memberName, memberMobile);
					
					try
					{
						HotelService.addMember(mdto);
						System.out.println("정상적으로 새로운 회원 정보가 추가되었습니다.");
					}
					catch(SQLException s)
					{
						s.printStackTrace();
						FailView.showError("새로운 회원 정보 추가 오류 발생");
					}
					break;
				case 7: // 예약 수정
					//System.out.println("\n수정할 예약 사항을 입력하세요.");
					System.out.println("\n예약번호를 입력하세요.");
					reserveNo = scan.nextInt();
					
					System.out.println("\n수정할 투숙 인원을 입력하세요.");
					peopleCount = scan.nextInt();
					
					System.out.println("\n수정할 투숙 기간을 입력하세요.");
					stayPeriod = scan.next();
					
					System.out.println("\n수정할 객실 이용가를 입력하세요.");
					reserveCost = scan.next();
					
					ReserveDTO urdto = new ReserveDTO(reserveNo, peopleCount, stayPeriod, reserveCost);
					
					try
					{
						HotelService.updateReserve(urdto);
						System.out.println("정상적으로 예약 정보가 수정되었습니다.");
					}
					catch(SQLException | NotExistException s)
					{
						s.printStackTrace();
						FailView.showError("예약 수정 작업 오류 발생");
					}
					break;
				case 8: // 객실 수정
					//System.out.println("\n수정할 객실 사항을 입력하세요.");
					
					System.out.println("\n수정할 객실 ID를 입력하세요.");
					roomId = scan.nextInt();
					
					System.out.println("\n수정할 객실 가격을 입력하세요.");
					roomPrice = scan.next();
					
					System.out.println("\n수정할 객실 예약 여부를 입력하세요.");
					roomCheck = scan.next();
					
					RoomDTO rodto = new RoomDTO(roomId, roomPrice, roomCheck);
					try
					{
						HotelService.updateReserve(rodto);
						System.out.println("정상적으로 객실 정보가 수정되었습니다.");
					}
					catch(SQLException | NotExistException s)
					{
						s.printStackTrace();
						FailView.showError("예약 수정 작업 오류 발생");
					}
					break;
				case 9: // 회원 수정
					//System.out.println("\n수정할 회원 사항을 입력하세요.");
					
					System.out.println("\n수정할 회원의 ID를 입력하세요.");
					memberId = scan.nextInt();
					
					System.out.println("\n수정할 회원의 휴대폰 번호를 입력하세요.");
					memberMobile = scan.next();
					
					//MemberDTO mdto = new RoomDTO(roomId, roomPrice, roomCheck);
					MemberDTO umdto = new MemberDTO(memberId, memberMobile);
					try
					{
						HotelService.updateMemberMobile(umdto);
						System.out.println("정상적으로 회원 정보가 수정되었습니다.");
					}
					catch(SQLException s)
					{
						s.printStackTrace();
						FailView.showError("예약 수정 작업 오류 발생");
					}
					break;
				case 10: // 회원 삭제
					System.out.println("\n삭제할 회원의 ID를 입력하세요.");
					memberId = scan.nextInt();
					try
					{
						deleteMember = HotelService.deleteMember(memberId);
						System.out.println("정상적으로 회원 정보가 삭제되었습니다.");
					}
					catch (SQLException | NotExistException s)
					{
						s.printStackTrace();
						FailView.showError("모든 예약 검색 시 오류 발생");
				    }
					break;
				case 0: // 종료 하기
					System.out.println("메뉴 선택으로 돌아갑니다.");
					break;
				default:
					break;
			}
			if(m1 == 0)
			{
				break;
			}
		}
	}
}
